import java.util.HashSet;
import java.util.Set;

public class q17_longestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {2,20,4,10,3,4,5};
        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive2(nums));
    }
    public static int longestConsecutive(int[] nums) {
        // brute force
        // time = O(n*n) and space = O(n)
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            int streak = 0;
            int current = num;
            while (set.contains(current)) {
                streak++;
                current++;
            }
            result = Math.max(result,streak);
        }

        return result;
    }
    public static int longestConsecutive2(int[] nums) {
        // hashset
        // time = O(n) and space = O(n)
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set){
            if (!set.contains(num-1)){
                int length = 1;
                while (set.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }
        return longest;
    }
}
