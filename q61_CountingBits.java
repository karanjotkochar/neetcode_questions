import java.util.Arrays;

public class q61_CountingBits {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(Arrays.toString(countBits(n)));
        System.out.println(Arrays.toString(countBits2(n)));
    }

    // brute force solution --> use n%2 and n/2 --> logn time complexity for n values ==> nlogn TC
    public static int[] countBits(int n) {
        // Bit Manipulation (DP) problem

        // use DP --> reuse values
        // use offset --> most significant bit (2,4,8, ...)
        // 1+ dp[n-2], 1+ dp[n-4], 1+ dp[n-8], ...

        // TC = O(n)
        // space = O(n)

        int[] dp = new int[n+1];
        int offset = 1;

        for (int i=1; i<=n; i++) {
            if (offset * 2 == i) {
                offset = i;
            }

            dp[i] = 1 + dp[i - offset];
        }

        return dp;
    }
    public static int[] countBits2(int n) {
        // In-built function
        // TC = O(n.logn)
        // space = O(n)

        int[] result = new int[n+1];

        for (int i=0; i<=n; i++){
            result[i] = Integer.bitCount(i);
        }

        return result;
    }
}
