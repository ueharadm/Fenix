package Fenix.Meeting;

import java.util.*;
import java.time.LocalDate;

import Fenix.Member.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/meeting")
@AllArgsConstructor
public class MeetingController {
	private final MeetingService meetingService;
	private final MemberRepository memberRepository;

	@PostMapping
	public void addMeeting(@RequestBody MeetingRequest request){

		meetingService.createMeeting(request);
	}

	@GetMapping
	public List<Meeting> gettAll(){
		return meetingService.getAllMeetings();
	}

	@GetMapping("{meetingId}")
	public Optional<Meeting> fetchMeeting(@PathVariable("meetingId") Integer meetingId){
		return meetingService.fetchMeeting(meetingId);
	}

	@DeleteMapping("{meetingId}")
	public void deleteMeeting(@PathVariable("meetingId") Integer meetingId){
		meetingService.deleteMeetingById(meetingId);
	}

	@PutMapping("{meetingId}")
	public void updateMeeting(@PathVariable("meetingId") Integer meetingId,@RequestBody MeetingRequest request){
		meetingService.updateMeeting(meetingId, request);
	}

	record FilterMeetingsRequest(LocalDate initDate, LocalDate finalDate){}
	@PostMapping("/filter")
	public List<Meeting> filterMeetingsByDate(@RequestBody  FilterMeetingsRequest request){
		return meetingService.filterMeetings(request.initDate, request.finalDate);
	}

	record FilterMeetingsByDegreeRequest(LocalDate initDate, LocalDate finalDate, MeetingType meetingType){}
	@PostMapping("/filterWithDegree")
	public List<Meeting> filterMeetings(@RequestBody  FilterMeetingsByDegreeRequest request){
		return meetingService.filterMeetingsByDegree(request.initDate, request.finalDate, request.meetingType);
	}

	record MemberIdRequest(Set<Integer> memberIds){}
	@PutMapping("/checkIn/{meetingId}")
	public String checkInMember(@PathVariable("meetingId") Integer meetingId, @RequestBody MemberIdRequest request) {
		String msg = "";
		for (Integer memberId: request.memberIds){
			msg += meetingService.checkInMember(meetingId, memberId)+ "\n";
		}
		return msg;
	}



	/*@PostMapping("/filter")
	public List<Meeting> filterMeetingsByDate(@RequestBody LocalDate initDate, @RequestBody LocalDate finalDate, @RequestBody MeetingType meetingType){
		return meetingService.filterMeetings(initDate,finalDate, meetingType);
	}*/
}

	/*
	//TODO: Limpar código anterior ao Spring Boot

	private static List<Meeting> meetingList = new ArrayList<Meeting>();
	private static Integer lastUid = 0;
	
	public static Meeting createNewMeeting(Integer meetingUid, MeetingType type, LocalDate date) {
		meetingList.add(new Meeting(meetingUid, type, date));
		updateLastUid(meetingUid);
		return meetingList.get(meetingList.size()-1);
	}

	public static void updateLastUid(Integer newLastUid) {
		lastUid = newLastUid;
	}
	
	public static void insertmeetingListIntoMeeting(ArrayList<meeting> meetingList) {
		
	}
	
	public static Meeting findMeetingByUid(Integer uid) {
		for (Meeting meeting : meetingList) {
			if(meeting.getMeetingUid()==uid) {
				return meeting;
			}
		}
		System.err.println("Não existe reunião com este número cadastrada");
		return null;
	}

	public static List<Meeting> getMeetingList() {
		return Collections.unmodifiableList(meetingList);
	}
	
	
	private static Integer getIndexOfMeeting(Integer meetingId) {
		return meetingList.indexOf(findMeetingByUid(meetingId));
	}
	
	private static Integer getIndexOfLastMeeting() {
		return getIndexOfMeeting(lastUid);
	}

	public static Meeting getLastMeeting() {
		return meetingList.get(getIndexOfLastMeeting());
	}
	
	public static void checkInmeetingByIdOnLastMeeting (Integer meetingId) {
		meetingList.get(getIndexOfLastMeeting()).getPresentmeetingIds().add(meetingId);
	}
	
	public static void checkInmeetingOnMeeting (Integer meetingId, Integer meetingId) {
		meetingList.get(getIndexOfMeeting(meetingId)).getPresentmeetingIds().add(meetingId);
		
	}
}
*/