package concepts;

import java.util.Arrays;

public class TwoPointer {

    public static void main(String[] args) {
        // where you use two pointers that traverse a data structure -- array, list, string
        // either toward each other or in the same direction

        // sorted input
        // pairs or sub arrays
        // sliding window problem
        // slow--fast pointer -- Floyd’s Cycle (Tortoise and Hare)

        int[] numbers = {1, 2, 3, 4, 5};
        int target = 3;

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                int[] result =  new int[]{left, right};
                System.out.println("True");
                System.out.println(Arrays.toString(result));
                break;
            }
        }
    }
}
