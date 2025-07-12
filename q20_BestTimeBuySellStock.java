public class q20_BestTimeBuySellStock {
    public static void main(String[] args) {
        int[] prices = {10,8,7,5,2};
//        maxProfit(prices);
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
    }
    public static int maxProfit(int[] prices) {
        // brute force
        // time = o(n*n) and space = o(1)
        int result = 0;
        int n= prices.length;;

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (prices[j] > prices[i]) {
                    int diff = prices[j] - prices[i];
                    result = Math.max(diff, result);
                }
            }
        }

        return result;
    }
    public static int maxProfit2(int[] prices) {
        // two pointer
        // time = o(n) and space = o(1)
        int left = 0;
        int right = left + 1;
        int maxProfit = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int diff = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, diff);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}
