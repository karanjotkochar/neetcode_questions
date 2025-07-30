import java.util.Arrays;
import java.util.Stack;

public class q38_CarFleet {
    public static void main(String[] args) {
        int target = 10;
        int[] position = {1,4};
        int[] speed = {3,2};
        System.out.println(carFleet(target, position, speed));

    }
    public static int carFleet(int target, int[] position, int[] speed) {
        // stack
        // time = o(nlogn) and space = o(n)

        int[][] pair = new int[position.length][2];                     // pair of (position, speed)
        for (int i=0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a,b) -> Integer.compare(b[0], a[0]));        // Reverse + sorted
        Stack<Double> stack = new Stack<>();

        for (int[] p : pair) {
            stack.push((double) (target - p[0])/p[1] );            // time = distance difference/speed

            if (stack.size() >= 2                                       // only possible when more than 1 car
                    && stack.peek() <= stack.get(stack.size() - 2)) {   // since push done, so compare top of stack(current entry) with one below (previous top)
                stack.pop();
            }
        }

        return stack.size();
    }
}
