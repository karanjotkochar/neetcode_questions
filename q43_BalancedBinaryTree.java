public class q43_BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right.left = new TreeNode(4);

        System.out.println(isBalanced(root));
        System.out.println(isBalanced2(root));
    }
    public static boolean isBalanced(TreeNode root) {
        // Brute force
        // time = o(n*n) and space = o(n)
        if (root == null)
            return true;

        int leftHeight = heightTree(root.left);
        int rightHeight = heightTree(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
    private static int heightTree(TreeNode root) {
        if (root == null)
            return 0;

        int left = heightTree(root.left);
        int right = heightTree(root.right);

        return Math.max(left, right) + 1;
    }
    public static boolean isBalanced2(TreeNode root) {
        // Optimized DFS
        // time = o(n) and space = o(h)
        return dfs(root)[0] == 1;                                   // the boolean value is 1 or True
    }
    private static int[] dfs(TreeNode root) {                       // calculating boolean and height at the same time
        if (root == null)
            return new int[]{1,0};                                  // int[i,j] = [boolean value (if balanced tree), height of tree]

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        boolean balanced = (left[0] == 1 && right[0] == 1) && (Math.abs(left[1] - right[1]) <= 1);          // left[1], right[1] is height

        int height = Math.max(left[1], right[1]) + 1;

        return new int[]{balanced ? 1: 0, height};
    }
}