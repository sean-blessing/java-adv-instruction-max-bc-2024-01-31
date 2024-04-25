import java.util.Base64;

public class HashTestingApp {

	public static void main(String[] args) {
		System.out.println("hello hash");
		String originalInput = "MaxTrain";
		String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
		System.out.println("encoded MaxTrain: "+encodedString);
		
		String encodedString2 = 
				Base64.getEncoder().withoutPadding().encodeToString(originalInput.getBytes());
		System.out.println("encoded MaxTrain: "+encodedString2);
		System.out.println("bye");
	}

}
