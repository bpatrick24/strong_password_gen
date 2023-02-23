import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;



public class generatePassword extends Main implements ActionListener{
	

	public String genPassword() {
		
		SecureRandom random = new SecureRandom();
		String combinedChars = LOWER + UPPER + NUMBERS + SYMBOLS;
		StringBuilder password = new StringBuilder(16);
		
		for (int i = 0; i < 16; i++) {
			int num = random.nextInt(combinedChars.length());
			password.append(combinedChars.charAt(num));
		}
		
		return password.toString();
		
	}
	
	
}
