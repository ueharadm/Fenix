package Fenix.Member.Registration;

import Fenix.Member.Member;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegistrationController {
	
	private RegistrationService registrationService;
/*
	public Member register(String name, String phoneNumber, Integer id, String cpf, Integer degree, Integer lodge) {
		return registrationService.register(name, phoneNumber, id, cpf, degree, lodge);
	}
	
	public boolean isAValidDegree(Integer degree) {
		return (degree>=0 && degree<=33);
	}

	public Member fetchMemberById(Integer memberId) {
		// TODO Auto-generated method stub
		return null;
	}*/
}
