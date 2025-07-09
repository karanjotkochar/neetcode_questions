import java.util.ArrayList;
import java.util.List;

public class q13_containerMostWater {
    public static void main(String[] args) {
        int[] heights = {1,7,2,5,4,7,3,6};
        // maxArea(heights);
        System.out.println(maxArea(heights));
        System.out.println(maxArea2(heights));
    }
    public static int maxArea(int[] heights) {
        // brute force method
        // time o(n) = n*n
        List<Integer> result = new ArrayList<>();
        for (int i=0; i < heights.length; i++) {
            for (int j = i+1; j < heights.length; j++) {
                Integer volume = (Math.min(heights[i], heights[j]))*(j-i);
                result.add(volume);
            }
        }

        return result.stream().max(Integer::compare).orElseThrow();
    }

    public static int maxArea2(int[] heights) {
        // two pointer approach
        // time o(n) = n
        int left = 0;
        int right = heights.length - 1;
        int result = 0;

        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            result = Math.max(result, area);

            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }

        return result;
    }
}
