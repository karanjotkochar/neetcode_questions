import java.util.ArrayList;
import java.util.List;

public class q78_PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aab";
        partition(s);
    }

    public static List<List<String>> partition(String s) {
        // Backtracking
        // TC = O(n.2^n)
        // SC = O(n.2^n)

        List<List<String>> result = new ArrayList<>();              // result of all parts/partitions
        List<String> part = new ArrayList<>();                      // current chosen substrings.
        dfs(s, result, part, 0);
        System.out.println(result);
        return result;
    }

    public static void dfs(String s, List<List<String>> result, List<String> part, int i) {

        if (i >= s.length()) {
            result.add(new ArrayList<>(part));
            return;
        }

        for (int j = i; j < s.length(); j++) {

            if (isPalindrome(i, j, s)) {
                part.add(s.substring(i, j+1));
                dfs(s, result, part, j+1);

                part.remove(part.size() - 1);
            }
        }

    }

    public static boolean isPalindrome(int l, int r, String s) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
