public class q15_binarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,2,4,6,8};
        int target = 4;
        System.out.println(search(nums, target));
        System.out.println(search2(nums, target));
    }
    public static int search(int[] nums, int target) {
        // brute force
        // time = o(n)
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target)
                return i;

        }
        return -1;
    }
    public static int search2(int[] nums, int target) {
        // iterative binary search
        // time = o(logn) and space = o(1)

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right-left)/2);

            if (nums[mid] > target)
                right = mid - 1;
            else if (nums[mid] < target)
                left = mid + 1;
            else
                return mid;
        }
        return -1;
    }

}
