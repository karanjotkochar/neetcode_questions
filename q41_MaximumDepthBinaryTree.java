public class q41_MaximumDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);

        System.out.println(maxDepth(root));
    }
    public static int maxDepth(TreeNode root) {
        // DFS
        // time = o(n) and space = 0(n) or o(logn)

        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left,right) + 1;
    }

}
