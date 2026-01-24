public class q59_SingleNumber {

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        singleNumber(nums);
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        // Bit Manipulation -- using XOR
        // time = O(n)
        // space = O(1)

        int result = 0;

        for (int num : nums) {
            result = result ^ num;
        }

        return result;
    }
}