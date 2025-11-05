public class q16_search2dMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,4,8}, {10,11,12,13}, {14,20,30,40}};
        int[][] matrix2 = {{1,3}};
        int target = 10;
        System.out.println(searchMatrix(matrix, target));
        System.out.println(searchMatrix2(matrix, target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        // brute force
        // time = O(m*n)
        for (int row=0; row<matrix.length; row++) {
            for (int col=0; col<matrix[row].length; col++) {

                if (matrix[row][col] == target)
                    return true;
            }
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        // binary search
        // time = O(m × log n)
        for (int row=0; row<matrix.length; row++) {
            int left = 0;
            int right = matrix[row].length-1;

            while (left <= right) {
                int mid = left + ((right-left)/2);
                if (target > matrix[row][mid])
                    left = mid+1;
                else if (target < matrix[row][mid])
                    right = mid-1;
                else
                    return true;
            }
        }

        return false;
    }

    // target: O(log(m*n))

}
