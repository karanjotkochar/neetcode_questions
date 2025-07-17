public class q26_SearchRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,1,2};
        int target = 1;
        System.out.println(search(nums, target));
        System.out.println(search2(nums, target));
    }
    public static int search(int[] nums, int target) {
        // brute force
        // time = o(n) and space = o(1)
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }
    public static int search2(int[] nums, int target) {
        // binary search
        // time = o(logn) and space = o(1)
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (nums[mid] == target) {
                return mid;
            }

            // left portion
            if (nums[mid] >= nums[left]) {
                // in left portion there are three cases:
                // target > num[mid] or target < num[mid]
                // and also if target is less than left most element
                // same for right portion
                    if (target < nums[left] || target > nums[mid])
                        left = mid + 1;

                    else if (target < nums[mid])
                        right = mid - 1;
            }
            // right portion
            else {
                if (target > nums[right] || target < nums[mid])
                    right = mid - 1;

                else if (target > nums[mid])
                    left = mid + 1;
            }
        }

        return -1;
    }
}
