import java.util.stream.IntStream;

public class SumApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the array sum app");

		int[] nums1 = {10,15,3,7};
		int sum = 10;
		IntStream.of(nums1).forEach(System.out::println);
		System.out.println("sum "+sum+" exists? "+checkPair(nums1, sum));
		
		System.out.println("bye");
	}
	
	private static boolean checkPair(int nums[], int k)
	{
	    for (int i = 0; i < nums.length; i++) {
	        for (int j = i+1;  j < nums.length; j++) {
	        	System.out.println("Sum ["+i+","+j+"]: "+nums[i]+"+"+nums[j]);
	            if (nums[i] + nums[j] == k) {
	                return true;
	            }
	        }
	    }

	    return false;
	}

}
