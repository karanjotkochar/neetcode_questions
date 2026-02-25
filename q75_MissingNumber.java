import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class q75_MissingNumber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        missingNumber(nums);
        System.out.println(missingNumber(nums));
        System.out.println(missingNumber2(nums));
        System.out.println(missingNumber3(nums));
    }

    public static int missingNumber(int[] nums) {
        // Brute force
        // TC = O(n.logn)
        // SC= O(n)

        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {

            if (nums[i] != i) {
                return i;
            }
        }

        return n;

    }

    public static int missingNumber2(int[] nums) {
        // Using HashSet
        // TC = O(n)
        // SC = (n)

        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }

    public static int missingNumber3(int[] nums) {
        // Using XOR
        // TC = O(n)
        // SC = O(1)

        int n = nums.length;
        int xorr = n;

        for (int i=0; i<n; i++) {               // xor based on (a^a = 0, a^0 = a)
            xorr = xorr^( i^nums[i] );          // xorr = n ^ (0 ^ nums[0]) ^ (1 ^ nums[1]) ^ (2 ^ nums[2])
        }

        return xorr;
    }
}
