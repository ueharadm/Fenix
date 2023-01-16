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
	public void addMeeting(@RequestBody MeetingRequest request) {

		meetingService.createMeeting(request);
	}

	@GetMapping
	public List<Meeting> getAll() {
		return meetingService.getAllMeetings();
	}

	@GetMapping("{meetingId}")
	public Optional<Meeting> fetchMeeting(@PathVariable("meetingId") Integer meetingId) {
		return meetingService.fetchMeeting(meetingId);
	}

	@DeleteMapping("{meetingId}")
	public void deleteMeeting(@PathVariable("meetingId") Integer meetingId) {
		meetingService.deleteMeetingById(meetingId);
	}

	@PutMapping("{meetingId}")
	public void updateMeeting(@PathVariable("meetingId") Integer meetingId, @RequestBody MeetingRequest request) {
		meetingService.updateMeeting(meetingId, request);
	}

	record FilterMeetingsRequest(LocalDate initDate, LocalDate finalDate) {
	}

	@PostMapping("/filter")
	public List<Meeting> filterMeetingsByDate(@RequestBody FilterMeetingsRequest request) {
		return meetingService.filterMeetings(request.initDate, request.finalDate);
	}

	record FilterMeetingsByDegreeRequest(LocalDate initDate, LocalDate finalDate, MeetingType meetingType) {
	}

	@PostMapping("/filterByDegree")
	public List<Meeting> filterMeetings(@RequestBody FilterMeetingsByDegreeRequest request) {
		return meetingService.filterMeetingsByDegree(request.initDate, request.finalDate, request.meetingType);
	}

	record MemberIdRequest(Set<Integer> memberIds) {
	}

	@PutMapping("/checkIn/{meetingId}")
	public String checkInMember(@PathVariable("meetingId") Integer meetingId, @RequestBody MemberIdRequest request) {
		String msg = "";
		for (Integer memberId : request.memberIds) {
			msg += meetingService.checkInMember(meetingId, memberId) + "\n";
		}
		return msg;
	}
}