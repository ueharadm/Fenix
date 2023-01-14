package Fenix.Meeting;

import Fenix.Member.Member;
import Fenix.Member.MemberRepository;
import Fenix.Member.MemberRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MeetingService {

    private final MeetingRepository meetingRepository;

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
}

    /*

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }



}
*/