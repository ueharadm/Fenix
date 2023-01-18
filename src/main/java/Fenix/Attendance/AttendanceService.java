package Fenix.Attendance;

import java.util.ArrayList;
import java.util.List;
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
        switch(request.getRule()){
            case GENERAL:
                return generalAttendanceRate(request);
            case REDEEMED:
                return redeemedAttendanceRate(request);
            case OFFICER:
                return officerAttendanceRate(request);
            default:
                throw new UnsupportedOperationException("Rule must be GENERAL, REDEEMED or OFFICER\nRule: "+ request.getRule().toString());
        }
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
        Member member = memberService.fetchMember(request.getMemberId()).get();

        List<Meeting> meetings = meetingService.filterMeetingsByDegree(
                memberService.latestDateOrInitiationDate(member.getId(),request.getInitDate()),
                memberService.latestDateOrInitiationDate(member.getId(),request.getFinalDate()),
                MeetingType.valueOf(member.getDegree().toString()));
        long totalMeetings = meetings.stream().count();

        List<Meeting> attendedMeetings = meetings.stream()
                .filter(meeting -> meeting.getAttendeesIds().contains(request.getMemberId()))
                .collect(Collectors.toList());
        long totalAttendedMeetings = attendedMeetings.stream().count();

        response.setAttendanceRate((double)totalAttendedMeetings/(double)totalMeetings);
        response.setTotalMeetings(totalMeetings);
        response.setTotalAttendedMeetings(totalAttendedMeetings);
        response.setAttendedMeetings(attendedMeetings);
        return response;
    }
}