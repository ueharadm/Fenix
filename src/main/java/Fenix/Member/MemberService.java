package Fenix.Member;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MemberService {
	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void createMember(NewMemberRequest request){
		Member member = new Member();
		member.setName(request.getName());
		member.setDegree(request.getDegree());
		member.setLodge(request.getLodge());
		member.setBirthDate(request.getBirthDate());
		member.setInitiationDate(request.getInitiationDate());
		memberRepository.save(member);
	}

}
