public class q72_JumpGame {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0,1,0};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {

        // Greedy solution:
        // start from end (goal post) and instead shift the goal in a greedy way
        // TC = O(n)
        // SC = O(1)
        int goal = nums.length - 1;                       // start from end: goal post

        for (int i = nums.length-2; i>=0; i--) {

            if ( i+nums[i] >= goal ) {                    // jump length = i + nums[i] --> if jump length possible/able to jump --> shift goal post
                goal = i;                                 // shift goal post
            }
        }

        return goal == 0;
    }
}
