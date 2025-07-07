import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class q9_validParentheses {
    public static void main(String[] args) {
        String s = "[]";
        // isValidParentheses(s);
        System.out.println(isValidParentheses(s));
        System.out.println(isValidParentheses2(s));
    }
    public static boolean isValidParentheses(String s) {
        // Brute force method
        // time o(n) = n*n and space o(n) = n
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }

        return s.isEmpty();
    }

    public static boolean isValidParentheses2(String s) {
        // Stack
        // time o(n) = n and space o(n) = n
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> characterMap = new HashMap<>();

        characterMap.put(')','(');
        characterMap.put('}','{');
        characterMap.put(']','[');

        for (char c : s.toCharArray()) {
            if (characterMap.containsKey(c)){
                if (!stack.isEmpty() && stack.peek() == characterMap.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
             else {
                 stack.push(c);
            }
        }

        return stack.isEmpty();
    }

}