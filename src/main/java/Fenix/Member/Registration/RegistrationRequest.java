package Fenix.Member.Registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
	private final String name;
	private final String phoneNumber;
	private final int id;
	private final String cpf;
	private final int degree;
	private final int lodge;
	private final String email;
}
