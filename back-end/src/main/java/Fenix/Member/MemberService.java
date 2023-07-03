package Fenix.Member;

import Fenix.LocalDate.LocalDateHelper;
import Fenix.Lodge.Lodge;
import Fenix.Lodge.LodgeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
	private final MemberRepository memberRepository;
	private final LodgeRepository lodgeRepository;

	public MemberService(MemberRepository memberRepository,
						 LodgeRepository lodgeRepository) {
		this.memberRepository = memberRepository;
		this.lodgeRepository = lodgeRepository;
	}

	public void createMember(MemberRequest request){
		Member member = new Member();
		member.setName(request.getName());
		member.setRegistration(request.getRegistration());
		member.setDegree(request.getDegree());
		Optional<Lodge> lodge = request.getLodgeId()!= null? lodgeRepository.findById(request.getLodgeId()) : null;
		if(lodge.isPresent() && lodge!=null){
			member.setLodge(lodgeRepository.findById(request.getLodgeId()).get());
		}
		member.setBirthDate(request.getBirthDate());
		member.setInitiationDate(request.getInitiationDate());
		member.setRedeemed(request.isRedeemed());
		member.setAttendanceRule(request.getAttendanceRule());
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
		//TODO: change null for a better way to treat NPE
		Optional<Lodge> lodge = request.getLodgeId()!= null? lodgeRepository.findById(request.getLodgeId()) : null;
		if(lodge.isPresent() && lodge!=null){
			member.setLodge(lodgeRepository.findById(request.getLodgeId()).get());
		}
		member.setBirthDate(request.getBirthDate());
		member.setInitiationDate(request.getInitiationDate());
		member.setRegistration(request.getRegistration());
		member.setRedeemed(request.isRedeemed());
		member.setAttendanceRule(request.getAttendanceRule());
		memberRepository.save(member);
	}

	public Optional<Member> fetchMember(Integer memberId) {
		return memberRepository.findById(memberId);
	}

	public boolean memberExists(Integer memberId){
		return memberRepository.findById(memberId).isPresent();
	}

	public LocalDate latestDateOrInitiationDate(Integer memberId, LocalDate date){
		LocalDate initiationDate = memberRepository.findById(memberId).get().getInitiationDate();
		//TODO: melhorar lógica, atualmente utiliza data de iniciação= 01/01/1900 para sempre retornar date caso nulo
		initiationDate = (initiationDate != null) ? initiationDate : LocalDate.of(1900,1,1);
		return LocalDateHelper.returnLatest(initiationDate,date);
	}

	public String assignLodge(Integer memberId, Integer lodgeId){
		String msg ="";
		Optional<Member> member = memberRepository.findById(memberId);
		Optional<Lodge> lodge = lodgeRepository.findById(lodgeId);
		msg += member.isEmpty() ? String.format("Não foi possível localizar o membro de ID: %d \n",memberId): "";
		msg += lodge.isEmpty() ? String.format("Não foi possível localizar a Loja de ID: %d \n",lodgeId): "";
		if(member.isPresent() && lodge.isPresent()){
			member.get().setLodge(lodge.get());
			msg = "Membro: "+member.get().getName()+" associado a loja: "+lodge.get().getName();
		}
		memberRepository.save(member.get());
		return msg;
	}


}
