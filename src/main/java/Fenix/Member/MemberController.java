package Fenix.Member;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDate;

import Fenix.Lodge.LodgeController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/member")
@AllArgsConstructor
public class MemberController {

	private final MemberRepository memberRepository;
	private final MemberService memberService;

	@PostMapping
	public void addMember(@RequestBody NewMemberRequest request){
		memberService.createMember(request);
	}
}



	/*

	//Code before Spring Boot
	private static List<Member> memberList= new ArrayList<>();
	private static final String MISSING_LODGE_MESSAGE = "Id da loja não cadastrada no sistema";

	public static void createNewMember(Integer id, String name, Integer degree, Integer lodge, LocalDate birthDate, LocalDate initiationDate) {
		try {
			if(LodgeController.lodgeExistsByUid(lodge)) {
				memberList.add(new Member(id, name, degree, lodge, birthDate, initiationDate));
			} else {
				throw new Exception(MISSING_LODGE_MESSAGE);
			}

		}catch(Exception e) {
			System.err.println("Ocorreu um erro ao criar novo membro: "+ e.getMessage());
		}
	}

	public static boolean insertNewMember(Member member) {
		if(member != null) {
			memberList.add(member);
			return true;
		}
		//TODO: throw exception
		return false;
	}

	public static List<Member> getMemberList(){
		return Collections.unmodifiableList(memberList);
	}

	public static Member getMemberById(Integer memberId) {
		return memberList.stream().filter(member -> memberId.equals(member.getId())).findFirst().orElse(null);
	}


}
*/
