package Fenix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("api/v1")
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}
}





	/*
		//TODO: Remover testes
		//Testando aplicação
		
		
		//Inicializa dados mockados
		LodgeRepository.populateLodgeList();
		MemberRepository.populateMemberList();
		MeetingRepository.populateMeetingList();
		
		
		
		//Imprime todas as lojas cadastradas
		System.out.println("Imprime todas as lojas cadastradas:\n");
		for (Lodge lodge : LodgeController.getLodgeList()) {
			System.out.println(lodge.toString());
		}
		
		
		//Imprime todos os membros cadastrados
		System.out.println("\n\nImprime todos os membros cadastrados:\n");
		for (Member member : MemberController.getMemberList()) {
			System.out.println(member.toString());
		}
		
		Meeting newMeeting = MeetingController.getLastMeeting();
		
		
		MeetingController.checkInMemberByIdOnLastMeeting(MemberController.getMemberList().get(0).getId());
		MeetingController.checkInMemberByIdOnLastMeeting(MemberController.getMemberList().get(1).getId());
		
		MeetingController.checkInMemberByIdOnLastMeeting(MemberController.getMemberList().get(5).getId());
		
		MeetingController.checkInMemberOnMeeting(MemberController.getMemberList().get(4).getId(), 0);
		MeetingController.checkInMemberOnMeeting(MemberController.getMemberList().get(4).getId(), 1);
		MeetingController.checkInMemberOnMeeting(MemberController.getMemberList().get(4).getId(), 2);
		MeetingController.checkInMemberOnMeeting(MemberController.getMemberList().get(4).getId(), 3);
		MeetingController.checkInMemberOnMeeting(MemberController.getMemberList().get(4).getId(), 4);
		MeetingController.checkInMemberOnMeeting(MemberController.getMemberList().get(4).getId(), 5);
		//MeetingController.checkInMemberOnMeeting(MemberController.getMemberList().get(4).getId(), 6);
		MeetingController.checkInMemberOnMeeting(MemberController.getMemberList().get(4).getId(), 7);
		//MeetingController.checkInMemberOnMeeting(MemberController.getMemberList().get(4).getId(), 8);
		MeetingController.checkInMemberOnMeeting(MemberController.getMemberList().get(4).getId(), 9);
		//MeetingController.checkInMemberOnMeeting(MemberController.getMemberList().get(4).getId(), 10);
		//MeetingController.checkInMemberOnMeeting(MemberController.getMemberList().get(4).getId(), 11);
		
		//Imprime todas as reuniões criadas
		System.out.println("\n\nImprime todas as reuniões criadas:\n");
		for (Meeting meeting: MeetingController.getMeetingList()) {
			System.out.println(meeting.toString());
		}
		
		
		System.out.println("\n\n\nReuniões de Janeiro a dezembro:");
		Double a = AttendanceService.calculateAttendanceRate(MemberController.getMemberList().get(4).getId(), YearMonth.of(2022, 1),YearMonth.of(2022, 12));
		System.out.println("Taxa de presença: "+a*100+"%");
		
		System.out.println("\n\n\nReuniões de Janeiro a Maio");
		Double b = AttendanceService.calculateAttendanceRate(MemberController.getMemberList().get(4).getId(), YearMonth.of(2022, 1),YearMonth.of(2022, 5));
		System.out.println("Taxa de presença: "+b*100+"%");

	}

}*/
