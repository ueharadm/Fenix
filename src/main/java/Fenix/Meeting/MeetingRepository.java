package Fenix.Meeting;

import java.time.LocalDate;
import java.time.LocalDate;

import Fenix.Member.MemberController;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {}


/*
	public static void populateMeetingList() {
		MeetingController.createNewMeeting(0, MeetingType.APRENDIZ, LocalDate.of(2022, 1, 01));
		MeetingController.createNewMeeting(1, MeetingType.APRENDIZ, LocalDate.of(2022, 2, 01));
		MeetingController.createNewMeeting(2, MeetingType.APRENDIZ, LocalDate.of(2022, 3, 01));
		MeetingController.createNewMeeting(3, MeetingType.APRENDIZ, LocalDate.of(2022, 4, 01));
		MeetingController.createNewMeeting(4, MeetingType.APRENDIZ, LocalDate.of(2022, 5, 01));
		MeetingController.createNewMeeting(5, MeetingType.APRENDIZ, LocalDate.of(2022, 6, 01));
		MeetingController.createNewMeeting(6, MeetingType.APRENDIZ, LocalDate.of(2022, 7, 01));
		MeetingController.createNewMeeting(7, MeetingType.APRENDIZ, LocalDate.of(2022, 8, 01));
		MeetingController.createNewMeeting(8, MeetingType.APRENDIZ, LocalDate.of(2022, 9, 01));
		MeetingController.createNewMeeting(9, MeetingType.APRENDIZ, LocalDate.of(2022, 10, 01));
		//MeetingController.createNewMeeting(10, MeetingType.APRENDIZ, LocalDate.of(2022, 11, 01));
		//MeetingController.createNewMeeting(11, MeetingType.APRENDIZ, LocalDate.of(2022, 12, 01));
	}*/
