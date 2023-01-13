package Fenix.Member.Registration;

import java.util.function.Predicate;

public class EmailValidator implements Predicate<String>{

	@Override
	public boolean test(String t) {
		// TODO: Regex to validate email
		return true;
	}

}
