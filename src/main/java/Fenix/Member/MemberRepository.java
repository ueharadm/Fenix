package Fenix.Member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {}

	/* TODO: Implement a proper Repository and DAO Class
	 * This class will start the implementation as a Mock Service
	 */
	
	
	/*
	public static void populateMemberList() {
		MemberController.createNewMember("Aprendiz", "11111111", 600000, "123.123.123-01", 01, 01);
		MemberController.createNewMember("Companheiro", "22222222", 500000, "123.123.123-02", 02, 01);
		MemberController.createNewMember("Mestre", "33333333", 400000, "123.123.123-03", 04, 01);
		MemberController.createNewMember("Irmao 4", "44", 444444, "444.444.444-44", 33, 01);
		MemberController.createNewMember("Irmao 5", "55", 555555, "555.555.555-55", 05, 01);
		MemberController.createNewMember("Irmao 6", "66", 666666, "666.666.666-66", 06, 01);
		MemberController.createNewMember("Irmao 7", "77", 777777, "777.777.777-77", 07, 01);
	}
	
	
	public static Member findByEmail(String email) {
		//TODO: implement find by email on database
		return new Member("MOCK","MOCK","MOCK",1,"MOCK",1,1,email);
	}
	
	public static Member findById(Integer memberId) {
		return MemberController.getMemberList().stream().filter(member -> memberId.equals(member.getId())).findFirst().orElse(null);
	}

}*/
