public class q71_MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = new int[]{2,-3,4,-2,2,1,-1,4};
        maxSubArray(nums);
    }

    public static int maxSubArray(int[] nums) {
        // Maximum Subarray Sum - Kadane's Algorithm
        // TC = O(n)
        // SC = O(1)

        int currSum = 0;
        int maxSub = nums[0];

        for (int i : nums) {

            if (currSum < 0) {
                currSum = 0;
            }
            currSum = currSum + i;
            maxSub = Math.max(maxSub, currSum);
        }

        return maxSub;
    }

}
