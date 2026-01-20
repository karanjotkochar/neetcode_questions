import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q58_CombinationSum2 {

    public void main(String[] args) {
        int[] candidates = {9,2,2,4,6,1,5};
        int target = 8;
        combinationSum2(candidates, target);
    }
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // using backtracking
        // time = O(n * 2^n)
        // space = O(n)
        result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        // sorting --> duplicates appear next to each other
        Arrays.sort(candidates);

        backtrack(candidates, target, 0, current, 0);
        return result;
    }
    private void backtrack(int[] candidates, int target, int i, List<Integer> current, int total) {

        // If total == target --> add a copy of current to result
        if (total == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        // If total > target or i == len(candidates) --> stop exploring
        if (total > target || i == candidates.length) {
            return;
        }

        // take/include the current candidate
        current.add(candidates[i]);
        backtrack(candidates, target, i+1, current, total + candidates[i]);

        // skip/exclude the current candidate plus skipping all duplicates
        current.remove(current.size() - 1);

        while (i+1 < candidates.length && candidates[i] == candidates[i+1]) {
            i++;
        }
        backtrack(candidates, target, i+1, current, total);
    }
}
