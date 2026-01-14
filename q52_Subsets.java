import java.util.ArrayList;
import java.util.List;

public class q52_Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        subsets(nums);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        // Backtracking
        // total subsets = 2^n and length = n
        // time O(n) = O(n * 2^n)
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, result);
        return result;
    }

    private static void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> result) {

        // Backtracking --> recursive technique, solution step by step,
        // finish exploring a path, undo the last choice and explore alternative paths.

        if (i >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        // include i
        subset.add(nums[i]);
        dfs(nums, i+1, subset, result);

        // backtrack -- exclude i
        subset.remove(subset.size()-1);
        dfs(nums, i+1, subset, result);

    }
}
