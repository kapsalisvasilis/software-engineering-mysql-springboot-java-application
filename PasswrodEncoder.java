package texnologia.logismikou;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswrodEncoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "dasdasfwqf";
		String encodedPassword= encoder.encode(rawPassword);
		//$2a$10$bgOKysN5KwxqWu.iJaYEAuOnXvdcc3jyMiEQCKR/Rl8fO3Ohnm1sS dasdasfwqf

		System.out.println(encodedPassword);
		
		
	}

}