import java.util.Arrays;

public class q8_productOfArray {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,3};
//        productExceptSelf(nums);
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        // brute force method
        // time o(n) = n*n and space o(n) = n
        int n = nums.length;
        int[] ans = new int[n];

        for (int i=0; i < n ; i++) {
            int result = 1;
            for (int j=0; j < n ; j++) {
                if (i != j){
                    result = result * nums[j];
                }
            }
            ans[i] = result;
        }
        return ans;
    }

//    TODO: method 2 -- prefix sum
}
