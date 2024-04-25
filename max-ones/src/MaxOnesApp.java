
public class MaxOnesApp {

	public static void main(String[] args) {
		System.out.println("Welcome to Max Ones");
		int[] nums1 = {1,1,0,1,1,1};
		System.out.println("1: "+ findMaxConsecutiveOnes(nums1));
		
		int[] nums2 = {1,0,1,1,0,1};
		System.out.println("1: "+ findMaxConsecutiveOnes(nums2));
		
		System.out.println("bye");
	}
	
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                if (i==(nums.length-1)) {
                	maxOnes = Integer.max(maxOnes, count);
                }
            }
            else {
                maxOnes = Integer.max(maxOnes, count);
                count = 0;
            }
        }
        return maxOnes;
    }

}
