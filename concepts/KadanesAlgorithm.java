package concepts;

public class KadanesAlgorithm {

    public static void main(String[] args) {
        // Maximum Subarray Sum - Kadane's Algorithm
        // TC = O(n)
        // SC = O(1)

        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        int currSum = 0;                                            // Stores the result (maximum sum found so far)
        int maxSub = arr[0];                                        // Maximum sum of subarray ending at current position

        // case 1: subarray sum +ve   current +ve --> extend
        // case 2: subarray sum -ve   current +ve --> new
        // case 3: subarray sum +ve   current -ve --> extend
        // case 4: subarray sum -ve   current -ve --> new

        for (int i : arr) {

            if (currSum < 0) {
                currSum = 0;
            }
            currSum = currSum + i;
            maxSub = Math.max(maxSub, currSum);
        }

        System.out.println(currSum);
    }
}
