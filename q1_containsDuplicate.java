import java.util.HashSet;

public class q1_containsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
//        System.out.println(hasDuplicate(nums));
        System.out.println(hasDuplicate2(nums));
    }
    public static boolean hasDuplicate(int[] nums) {
        // brute force, O(n) = n*n
        for (int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i]==nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasDuplicate2(int[] nums) {
        // hash set data structure, O(n = n)
        HashSet<Integer> hashSet = new HashSet<Integer>();
        int i=0;
        while (i < nums.length) {
            hashSet.add(nums[i]);
            i++;
        }
        if (hashSet.size() != nums.length)
            return true;
        else
            return false;
    }

}
