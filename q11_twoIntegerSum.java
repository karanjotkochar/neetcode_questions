import java.util.Arrays;
import java.util.HashMap;

public class q11_twoIntegerSum {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4};
        int target = 3;
        twoSum(numbers, target);
        System.out.println(Arrays.toString(twoSum(numbers, target)));
        System.out.println(Arrays.toString(twoSum2(numbers, target)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        // hashmap approach
        // time o(n) = n and space o(n) = n
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i=0; i< numbers.length; i++) {
            int num = numbers[i];
            int diff = target - num;

            if (hashMap.containsKey(diff)) {
                return new int[] {hashMap.get(diff), i+1};
            }
            hashMap.put(num,i+1);

        }
        return new int[] {};
    }

    public static int[] twoSum2(int[] numbers, int target) {

        // IMPORTANT: 1-indexed Array, index starts with index = 1
        // time O(n) = n, space o(n) = 1
        // two pointer approach
        int left = 0;
        int right = numbers.length-1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{left+1, right+1};
            }
        }
        return new int[]{};
    }

}
