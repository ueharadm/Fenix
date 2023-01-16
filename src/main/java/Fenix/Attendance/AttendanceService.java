package Fenix.Attendance;

import java.time.LocalDate;
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

        switch(request.getRule()){
            case GENERAL:
                return generalAttendanceRate(request);
            case REDEEMED:
                redeemedAttendanceRate();
            case OFFICER:
                officerAttendanceRate();
            default:
                throw new UnsupportedOperationException("Rule must be GENERAL, REDEEMED or OFFICER\nRule: "+ request.getRule().toString());
        }



    }

    private void officerAttendanceRate() {
        //TODO: yet to be implemented
    }

    private void redeemedAttendanceRate() {
        //TODO: yet to be implemented
    }

    public AttendanceResponse generalAttendanceRate (AttendanceRateRequest request){

        AttendanceResponse response = new AttendanceResponse();
        Member member = memberService.fetchMember(request.getMemberId()).get();

        List<Meeting> meetings = meetingService.filterMeetingsByDegree(
                memberService.latestDateOrInitiationDate(member.getId(),request.getInitDate()),
                memberService.latestDateOrInitiationDate(member.getId(),request.getFinalDate()),
                MeetingType.valueOf(member.getDegree().toString()));
        long totalMeetings = meetings.stream().count();

        List<Meeting> attendedMeetings = meetings.stream()
                .filter(meeting -> meeting.getPresentMemberIds().contains(request.getMemberId()))
                .collect(Collectors.toList());
        long totalAttendedMeetings = attendedMeetings.stream().count();

        response.setAttendanceRate((double)totalAttendedMeetings/(double)totalMeetings);
        response.setTotalMeetings(totalMeetings);
        response.setTotalAttendedMeetings(totalAttendedMeetings);
        response.setAttendedMeetings(attendedMeetings);
        return response;
    }
}