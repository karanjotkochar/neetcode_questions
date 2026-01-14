import java.util.ArrayList;
import java.util.List;

public class q53_CombinationSum {

    public void main(String[] args) {
        int[] nums = {2,5,6,9};
        int target = 9;
        combinationSum(nums, target);
    }
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();
        backtrack(nums, target, curr, 0);
        return result;
    }

    private void backtrack(int[] nums, int target, List<Integer> curr, int i) {

        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0 || i >= nums.length) {
            return;
        }

        // include i
        curr.add(nums[i]);
        backtrack(nums, target - nums[i], curr, i );

        // backtrack -- exclude i
        curr.remove(curr.size() - 1);
        backtrack(nums, target, curr, i+1);

    }
}
