package Fenix.Member;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void createMember(MemberRequest request){
		Member member = new Member();
		member.setName(request.getName());
		member.setRegistration(request.getRegistration());
		member.setDegree(request.getDegree());
		member.setLodge(request.getLodge());
		member.setBirthDate(request.getBirthDate());
		member.setInitiationDate(request.getInitiationDate());
		memberRepository.save(member);
	}

	public List<Member> getAllMembers(){
		return memberRepository.findAll();
	}

	public void deleteMemberById(Integer memberId){
		memberRepository.deleteById(memberId);
	}

	public void updateMember(Integer memberId, MemberRequest request){
		Member member = new Member();
		member.setId(memberId);
		member.setName(request.getName());
		member.setDegree(request.getDegree());
		member.setLodge(request.getLodge());
		member.setBirthDate(request.getBirthDate());
		member.setInitiationDate(request.getInitiationDate());
		member.setRegistration(request.getRegistration());
		memberRepository.save(member);
	}

	public Optional<Member> fetchMember(Integer memberId) {
		return memberRepository.findById(memberId);
	}
}
