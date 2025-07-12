import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class q21_EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = {"1","2","+","3","*","4","-"};
        System.out.println(evalRPN(tokens));
        System.out.println(evalRPN2(tokens));
    }
    public static int evalRPN(String[] tokens) {
        // brute force
        // time = o(n*n) and space = o(n)
        List<String> ls = new ArrayList<>(Arrays.asList(tokens));

        while (ls.size() > 1) {
            for (int i=0; i< ls.size(); i++) {
                String token = ls.get(i);

                if ("+-*/".contains(token)) {
                    int a = Integer.parseInt(ls.get(i-2));
                    int b = Integer.parseInt(ls.get(i-1));
                    int result = 0;

                    if (token.equals("+")) {
                        result = a + b;
                    } else if (token.equals("-")) {
                        result = a - b;
                    } else if (token.equals("*")) {
                        result = a * b;
                    } else if (token.equals("/")) {
                        result = a / b;
                    }

                    ls.set(i-2, String.valueOf(result));
                    ls.remove(i);
                    ls.remove(i-1);
                    break;
                }
            }
        }

        int result = Integer.parseInt(ls.get(0));
        return result;
    }
    public static int evalRPN2(String[] tokens) {
        // stack
        // time = o(n) and space = o(n)
        Stack<Integer> stack = new Stack<>();

        for (String c : tokens) {
            if (c.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                int result = a+b;
                stack.push(result);

            } else if (c.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                int result = b-a;
                stack.push(result);

            } else if (c.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                int result = b*a;
                stack.push(result);

            } else if (c.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                int result = b/a;
                stack.push(result);

            } else {
                stack.push(Integer.parseInt(c));
            }
        }

        int result = stack.pop();
        return result;
    }
}
