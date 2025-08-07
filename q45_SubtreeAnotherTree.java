public class q45_SubtreeAnotherTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode subRoot = new TreeNode(2);
        subRoot.right = new TreeNode(4);
        subRoot.left = new TreeNode(5);

        System.out.println(isSubtree(root, subRoot));
    }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Brute force
        // time = o(m*n) and space = o(m+n)
                                                        // Order of IF Important **
        if (subRoot == null)                            // SubTree is empty, can be part of Big tree (Ex. any leaf node child)
            return true;

        if (root == null)                               // Edge case: Root is empty, subtree cannot be part of null
            return false;

        if (isIdentical(root, subRoot))                 // Check both trees are same
            return true;

        return isSubtree(root.left, subRoot) ||         // Check sub-tree on right side or left side
                isSubtree(root.right, subRoot);
    }
    private static boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;

        if (root != null && subRoot != null && root.val == subRoot.val)                                         // Node are same, check their children
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        else
            return false;
    }

}
