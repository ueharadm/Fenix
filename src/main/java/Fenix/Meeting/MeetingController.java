package Fenix.Meeting;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import Fenix.Member.Member;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/meeting")
public class MeetingController {
	
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
	
	public static void insertMemberListIntoMeeting(ArrayList<Member> memberList) {
		
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
	
	public static void checkInMemberByIdOnLastMeeting (Integer memberId) {
		meetingList.get(getIndexOfLastMeeting()).getPresentMemberIds().add(memberId);
	}
	
	public static void checkInMemberOnMeeting (Integer memberId, Integer meetingId) {
		meetingList.get(getIndexOfMeeting(meetingId)).getPresentMemberIds().add(memberId);
		
	}
}
