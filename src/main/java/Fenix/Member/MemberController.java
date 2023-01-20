package Fenix.Member;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/member")
@AllArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping
	public void addMember(@RequestBody MemberRequest request){

		memberService.createMember(request);
	}

	@GetMapping
	public List<Member> gettAll(){
		return memberService.getAllMembers();
	}

	@GetMapping("{memberId}")
	public Optional<Member> fetchMember(@PathVariable("memberId") Integer memberId){
		return memberService.fetchMember(memberId);
	}

	@DeleteMapping("{memberId}")
	public void deleteMember(@PathVariable("memberId") Integer memberId){
		memberService.deleteMemberById(memberId);
	}

	@PutMapping("{memberId}")
	public void updateMember(@PathVariable("memberId") Integer memberId,@RequestBody MemberRequest request){
		memberService.updateMember(memberId, request);
	}

	@PutMapping("/assignLodge/{memberId}")
	public String assignLodge(@PathVariable("memberId") Integer memberId ,@RequestBody MemberRequest request){
		return memberService.assignLodge(memberId, request.getLodgeId());
	}
}