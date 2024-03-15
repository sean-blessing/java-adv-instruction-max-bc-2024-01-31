import java.util.ArrayList;
import java.util.List;

public class ScratchApp {

	public static void main(String[] args) {
		System.out.println("hi");
		
		int number = Console.getInt("Enter an integer between 1 and 5000: ", 0, 5001);
		
		List<Integer> factors = new ArrayList<>();
		
		// prime # definition: a number which is only evenly divisible between one and itself.
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				factors.add(i);
			}
		}
		
		if (factors.size()==2) {
			System.out.println(number+" is a prime number.");
		}
		else {
			StringBuilder factorsStr = new StringBuilder();
			//String factorsStr = "";
			for (int factor: factors) {
				factorsStr.append(factor + " ");
				//factorsStr += factor + " ";
			}
			System.out.println(factors.size()+" factors: "+factorsStr.toString());
		}		
		System.out.println("bye");

	}

}
