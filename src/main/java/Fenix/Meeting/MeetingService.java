package Fenix.Meeting;

import Fenix.Member.Member;
import Fenix.Member.MemberRepository;
import Fenix.Member.MemberRequest;
import Fenix.Member.MemberService;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MeetingService {

    private final MeetingRepository meetingRepository;
    private final MemberService memberService;

    public void createMeeting(MeetingRequest request) {
        Meeting meeting = new Meeting();
        meeting.setNumber(request.getNumber());
        meeting.setType(request.getType());
        meeting.setDate(request.getDate());
        meeting.setPresentMemberIds(request.getPresentMemberIds());
        meetingRepository.save(meeting);
    }

    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    public Optional<Meeting> fetchMeeting(Integer meetingId) {
        return meetingRepository.findById(meetingId);
    }

    public void deleteMeetingById(Integer meetingId) {
        meetingRepository.deleteById(meetingId);
    }

    public void updateMeeting(Integer meetingId, MeetingRequest request) {
        Meeting meeting = new Meeting();
        meeting.setId(meetingId);
        meeting.setNumber(request.getNumber());
        meeting.setType(request.getType());
        meeting.setDate(request.getDate());
        meeting.setPresentMemberIds(request.getPresentMemberIds());
        meetingRepository.save(meeting);
    }

    public List<Meeting> filterMeetings(LocalDate initDate, LocalDate finalDate) {
        return meetingRepository.findAll().stream()
                .filter(meeting -> meeting.getDate().compareTo(initDate)>=0)
                .filter(meeting -> meeting.getDate().compareTo(finalDate)<=0)
                .collect(Collectors.toList());
    }

    public List<Meeting> filterMeetingsByDegree(LocalDate initDate, LocalDate finalDate, MeetingType meetingType) {
        return filterMeetings(initDate, finalDate).stream()
                .filter(meeting -> meeting.getType().compareTo(meetingType)<=0)
                .collect(Collectors.toList());
    }

    public String checkInMember(Integer meetingId, Integer memberId) {
        if(memberService.memberExists(memberId)){
            Meeting meeting = new Meeting();
            meeting = meetingRepository.findById(meetingId).get();
            meeting.getPresentMemberIds().add(memberId);
            meetingRepository.save(meeting);
            return "Membero ID:"+memberId+" inserido na reunião "+meetingId;
        }
        return "Membro ID:"+memberId+" não cadastrado";
    }
}

    /*

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }



}
*/