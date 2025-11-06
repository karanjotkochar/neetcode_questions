import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class q22_GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n) {
        // Backtracking
        // time = o(4^n / sqrt(n)) and space = o(n)
        ArrayList<String> result = new ArrayList<>();
        StringBuilder stack = new StringBuilder();

        backtrack(0,0,n,result,stack);

        return result;
    }

    private static void backtrack(int openN, int closedN, int n, List<String> result, StringBuilder stack) {

        // n open, n close
        // close < open

        // add open --> open < n
        // add close --> close < open
        // valid: open = close = n

        if (openN == closedN && openN == n) {
            result.add(stack.toString());
            return;
        }

        if (openN < n) {
            stack.append("(");
            backtrack(openN+1, closedN, n, result, stack);
            stack.deleteCharAt(stack.length() - 1);
        }

        if (closedN < openN) {
            stack.append(")");
            backtrack(openN, closedN+1, n, result, stack);

            // Without delete, all new parentheses would keep appending to stack forever.
            // Instead, by deleting the last added character, we "go back" one step and explore another option.
            stack.deleteCharAt(stack.length() - 1);
        }

    }
}
