import java.util.Arrays;
import java.util.Stack;

public class q23_DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {30,38,30,36,35,40,28};
//        dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
        System.out.println(Arrays.toString(dailyTemperatures2(temperatures)));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        // brute force
        // time = o(n*n) and space = o(1), o(n)
        int n = temperatures.length;
        int[] result = new int[n];

        for(int i=0; i<n; i++) {
            int count = 1;
            int j = i + 1;

            while (j<n) {
                if (temperatures[j] > temperatures[i]) {
                    break;
                }
                j++;
                count++;
            }

            count = (j==n) ? 0 : count;
            result[i] = count;
        }
        return result;
    }
    public static int[] dailyTemperatures2(int[] temperatures) {
        // using stack
        // time = o(n) and space = o(n)
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();

        for (int i=0; i<n; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                result[pair[1]] = i-pair[1];
            }
            stack.push(new int[]{t, i});
        }
        return result;
    }

//    TODO: Return again
}