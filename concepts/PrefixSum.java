package concepts;

import java.util.Arrays;

public class PrefixSum {

    public static void main(String[] args) {
        // calculating the sum of sub arrays in an integer array.

        int[] arr = {2, 3, -4, 5};
        int[] prefixArr = new int[arr.length];

        prefixArr[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefixArr[i] = prefixArr[i-1] + arr[i];
        }

        System.out.println(Arrays.toString(prefixArr));

    }

}
