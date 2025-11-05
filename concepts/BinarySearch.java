package concepts;

public class BinarySearch {

    public static void main(String[] args) {
        // searching algorithm that operates on a sorted search space
        // repeatedly dividing it into halves to find a target value in logarithmic time O(log N)

        // Iterative Binary Search Algorithm:  O(log n) Time and O(1) Space

        int[] nums = {-1,0,2,4,6,8};
        int target = 4;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] > target)
                right = mid - 1;
            else if (nums[mid] < target)
                left = mid + 1;
            else {
                System.out.println("found mid at " + mid);
                break;
            }

        }

        // TODO Recursive Binary Search Algorithm
    }
}
