import java.util.HashSet;

public class q36_FindDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2};
        System.out.println(findDuplicate(nums));
        System.out.println(findDuplicate2(nums));
    }
    public static int findDuplicate(int[] nums) {
        // brute force: HashSet
        // time = o(n) and space = o(n)
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for (int i=0; i<n; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }

        return -1;
    }

    public static int findDuplicate2(int[] nums) {
        // LinkedList problem + Floyd's Algorithm
        // time = o(n) and space = o(1)

        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];              // fast and slow pointer
            fast = nums[nums[fast]];
            if (slow == fast)
                break;
        }

        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2)
                return slow;
        }
    }
    // TODO: Algorithm
}
