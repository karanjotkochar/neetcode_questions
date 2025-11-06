public class q18_TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,2,0,3,1,0,1,3,2,1};
        System.out.println(trap(height));
        System.out.println(trap2(height));
    }
    public static int trap(int[] height) {
        // brute force
        // time = o(n*n) and space = o(1)
        if (height.length == 0 || height == null)
            return 0;

        int n = height.length;
        int result = 0;

        for (int i=0; i<n; i++) {
            int leftMax = height[i];            // this initialization prevents negative result
            int rightMax = height[i];

            for (int j=0; j<i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j=i+1; j<n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            result = result + ( Math.min(leftMax, rightMax) - height[i] );
        }

        return result;
    }

    public static int trap2(int[] height) {
        // prefix and suffix array: 2 arrays maintaining balance
        // time = o(n) and space = o(n)
        int n = height.length;
        int result = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        if (n == 0)
            return 0;

        leftMax[0] = height[0];
        for (int i=1; i<n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[n-1] = height[n-1];
        for (int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        for (int i=0; i<n; i++) {
            result = result + ( Math.min(leftMax[i], rightMax[i]) - height[i] );
        }
        return result;
    }
    // Method 3: Two Pointer approach --> time = o(n) and space = o(1)
}
