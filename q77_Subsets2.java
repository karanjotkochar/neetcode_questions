import java.util.*;

public class q77_Subsets2 {

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        subsetsWithDup(nums);
        System.out.println(subsetsWithDup(nums));
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        // Brute force -- Backtracking
        // TC = O(n.2^n)
        // SC = O(2^n)

        Arrays.sort(nums);                                      // using sorting will keep duplicates numbers adjacent
        Set<List<Integer>> result = new HashSet<>();            // using hashset avoids duplicates
        List<Integer> subset = new ArrayList<>();
        dfs(nums, result, subset, 0);
        return new ArrayList<>(result);
    }

    public static void dfs(int[] nums, Set<List<Integer>> result, List<Integer> subset, int i ) {

        if (i >= nums.length) {
            result.add( new ArrayList<>(subset) );              // result is a Hashset --> adds no duplicates arraylist ** IMP
            return;
        }

        // case 1: include i
        subset.add(nums[i]);
        dfs(nums, result, subset, i+1);

        // case 2: exclude i
        subset.remove( subset.size() - 1);
        dfs(nums, result, subset, i+1);

    }
    //----------------------------------------------------------------------------------------------------------
    // Solution 2

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        // Backtracking
        // TC = O(n.2^n)
        // SC = O(2^n) -- better

        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        dfs2(nums, subset, 0);
        return result;
    }

    public static void dfs2(int[] nums, List<Integer> subset, int i) {

        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        // case 1: include i
        subset.add(nums[i]);
        dfs2(nums, subset, i+1);

        // case 2: enclude i
        subset.remove(subset.size() - 1);

        // special case: during exclude --> check for duplicate
        while (i+1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }
        dfs2(nums, subset, i+1);

    }

}
