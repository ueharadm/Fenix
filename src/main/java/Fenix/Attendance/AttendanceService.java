package Fenix.Attendance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Fenix.Meeting.Meeting;
import Fenix.Meeting.MeetingService;
import Fenix.Meeting.MeetingType;
import Fenix.Member.Member;
import Fenix.Member.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AttendanceService {

    private final MeetingService meetingService;
    private final MemberService memberService;

    /*public List<Meeting> getMeetingsByDate(LocalDate InitDate, LocalDate finalDate){
        return null;
    }*/

    public AttendanceResponse calculateAttendanceRate(AttendanceRateRequest request) {

        //TODO: implement 1 year rule for general and 2 year rule for redeemed, for the time being the user must give initDate and finalDate
        return switch (request.getRule()) {
            case GERAL -> generalAttendanceRate(request);
            case REMIDO -> redeemedAttendanceRate(request);
            case OFICIAL -> officerAttendanceRate(request);
            default ->
                    throw new UnsupportedOperationException("Rule must be GENERAL, REDEEMED or OFFICER\nRule: " + request.getRule().toString());
        };
    }


    private AttendanceResponse officerAttendanceRate(AttendanceRateRequest request) {
        //Officers are exempted from Attendance on lodge meetings
        AttendanceResponse response=new AttendanceResponse();
        response.setAttendanceRate(1.0);
        response.setTotalMeetings(0);
        response.setTotalAttendedMeetings(0);
        response.setAttendedMeetings(new ArrayList<Meeting>());
        return response;
    }


    private AttendanceResponse redeemedAttendanceRate(AttendanceRateRequest request) {
        //MVP: User must give the initDate and finalDate for accounting period
        //TODO: implement a 2-year accounting period for members with age>60, masonYears>25 and hasRedeemedBadge()
        return generalAttendanceRate(request);
    }

    public AttendanceResponse generalAttendanceRate (AttendanceRateRequest request){
        //MVP: User must give the initDate and finalDate for accounting period
        //TODO: implement a 1-year accounting period from the closure of the previous month
        AttendanceResponse response = new AttendanceResponse();
        Member member = memberService.fetchMember(request.getMemberId()).orElseThrow(IllegalStateException::new);

        List<Meeting> meetings = meetingService.filterMeetingsByDegree(
                memberService.latestDateOrInitiationDate(member.getId(),request.getInitDate()),
                memberService.latestDateOrInitiationDate(member.getId(),request.getFinalDate()),
                MeetingType.valueOf(member.getDegree().toString()));
        long totalMeetings = meetings.size();

        List<Meeting> attendedMeetings = meetings.stream()
                .filter(meeting -> meeting.getAttendees().contains(member))
                .collect(Collectors.toList());
        long totalAttendedMeetings = attendedMeetings.size();

        response.setAttendanceRate((double)totalAttendedMeetings/(double)totalMeetings);
        response.setTotalMeetings(totalMeetings);
        response.setTotalAttendedMeetings(totalAttendedMeetings);
        response.setAttendedMeetings(attendedMeetings);
        return response;
    }

    public AttendanceResponse memberAttendanceRate(Integer memberId) throws Exception{
        AttendanceResponse response = new AttendanceResponse();
        Optional<Member> member = memberService.fetchMember(memberId);
        CalculationPeriod period = getCalculationPeriodByRule(member.orElseThrow(IllegalStateException::new).getAttendanceRule());

        List<Meeting> meetings = meetingService.filterMeetingsByDegree(
                memberService.latestDateOrInitiationDate(memberId, period.initDate),
                memberService.latestDateOrInitiationDate(memberId, period.finalDate),
                MeetingType.valueOf(member.get().getDegree().toString()));
        long totalMeetings = meetings.size();

        List<Meeting> attendedMeetings = meetings.stream()
                .filter(meeting -> meeting.getAttendees().contains(member.get()))
                .collect(Collectors.toList());
        long totalAttendedMeetings = attendedMeetings.size();

        if (member.get().getAttendanceRule().equals(AttendanceRule.OFICIAL)) {
            response.setAttendanceRate(1.0);
        } else {
            response.setAttendanceRate((double) totalAttendedMeetings / (double) totalMeetings);
        }
        response.setTotalMeetings(totalMeetings);
        response.setTotalAttendedMeetings(totalAttendedMeetings);
        response.setAttendedMeetings(attendedMeetings);
        return response;
    }

    record CalculationPeriod (LocalDate initDate, LocalDate finalDate){}

    public CalculationPeriod getCalculationPeriodByRule(AttendanceRule rule) {
        LocalDate today = LocalDate.now();
        LocalDate initDate;
        LocalDate finalDate;


        switch (rule) {
            case GERAL -> {
                initDate = today.minusYears(1).withDayOfMonth(1);
                finalDate = today.minusMonths(1).withDayOfMonth(today.minusMonths(1).lengthOfMonth());
                return new CalculationPeriod(initDate, finalDate);
            }
            case REMIDO -> {
                initDate = today.minusYears(2).withDayOfMonth(1);
                finalDate = today.minusMonths(1).withDayOfMonth(today.minusMonths(1).lengthOfMonth());
                return new CalculationPeriod(initDate, finalDate);
            }
            case OFICIAL -> {
                return new CalculationPeriod(LocalDate.now(), LocalDate.now());
            }
            default ->
                    throw new UnsupportedOperationException("Rule must be GENERAL, REDEEMED or OFFICER\nRule: " + rule.toString());
        }
    }
}