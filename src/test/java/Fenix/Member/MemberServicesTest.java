package Fenix.Member;

import static org.junit.Assert.*;

import org.junit.Test;

import Fenix.Meeting.MeetingController;
import Fenix.Member.Member;
import Fenix.Member.Registration.RegistrationController;
import Fenix.Member.Registration.RegistrationRequest;
import Fenix.Member.Registration.RegistrationService;

public class MemberServicesTest {

	private RegistrationService registrationService = new RegistrationService();
	private RegistrationController registrationController = new RegistrationController(registrationService);
	private MeetingController meetingController = new MeetingController();
	
	@Test
	public void shouldRegisterAnValidMember() {
		
		//Given
		String memberName = "José da Silva";
		String memberPhone = "+55 99999-9999";
		Integer memberId = 123465;
		String memberCpf = "123.123.123-12";
		Integer memberDegree = 33;
		Integer memberLodge = 01;
		
		//When
		registrationController.register(memberName, memberPhone, memberId, memberCpf, memberDegree, memberLodge);
		
		//Then
		Member member = registrationController.fetchMemberById(memberId);
		assertEquals(memberName, member.getName());
		assertEquals(memberPhone, member.getPhoneNumber());
		assertEquals(memberId, member.getId());
		assertEquals(memberCpf, member.getCpf());
		assertEquals(memberDegree, member.getDegree());
		assertEquals(memberLodge, member.getLodge());
	}
	
	@Test
	public void shouldStartANewMeeting() {
		//Meeting newMeeting = meetingController.startNewMeeting();
		
		
		
	}

}