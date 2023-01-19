package Fenix.Meeting;

import Fenix.Member.Member;
import Fenix.Member.MemberRepository;
import Fenix.Member.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.NoSuchFileException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MeetingService {

    private final MeetingRepository meetingRepository;
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public void createMeeting(MeetingRequest request) {
        Meeting meeting = new Meeting();
        meeting.setNumber(request.getNumber());
        meeting.setWorshipfulMasterId(request.getWorshipfulMasterId());
        meeting.setType(request.getType());
        meeting.setDate(request.getDate());
        meeting.setAttendees(request.getAttendees());
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
        meeting.setWorshipfulMasterId(request.getWorshipfulMasterId());
        meeting.setType(request.getType());
        meeting.setDate(request.getDate());
        meeting.setAttendees(request.getAttendees());
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
            meeting = meetingRepository.findById(meetingId).orElse(new Meeting());
            meeting.getAttendees().add(memberService.fetchMember(memberId).orElse(new Member()));
            meetingRepository.save(meeting);
            return meeting.getNumber()==null
                    ? ("Não foi possível localizar a reunião: "+meetingId)
                    : ("Member ID:"+memberId+" inserido na reunião "+meetingId);
        }

        return "Membro ID:"+memberId+" não cadastrado";
    }

    public String PrintAllMeetings(){
        try{
            List<Meeting> meetings = getAllMeetings();
            MeetingXlsxPrinter.printMeetings(meetings, "TesteAllMeetings.xlsx");
            return "Sucesso";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String printMeeting(Integer meetingId, String fileName) {
        try{
            List<Meeting> meetings = getAllMeetings();
            MeetingXlsxPrinter.printMeeting(meetingRepository.getReferenceById(meetingId), fileName+meetingId+".xlsx");
            return "Sucesso";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}



    /*

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }



}
*/