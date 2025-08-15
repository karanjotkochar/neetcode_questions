public class q50_ValidBinarySearchTree {
    public static void main(String[] args) {

    }
    public static boolean isValidBST(TreeNode root) {

        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);               // root, - infinity, + infinity
    }

    private static boolean dfs(TreeNode node, long left, long right) {
                                                                        // node, left boundary, right boundary
        if (node == null)
            return true;

        if ( !(node.val < right && node.val > left) ) {
            return false;
        }

        return dfs(node.left, left, node.val)                           // left node cannot be greater than root
                    &&
                        dfs(node.right, node.val, right);               // right is greater tha root (boundaries)
    }
}
