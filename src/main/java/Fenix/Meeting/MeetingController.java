package Fenix.Meeting;

import java.util.*;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/meeting")
@AllArgsConstructor
public class MeetingController {
	private final MeetingService meetingService;

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