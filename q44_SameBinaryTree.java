public class q44_SameBinaryTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.left = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);
        q.left = new TreeNode(3);

        System.out.println(isSameTree(p,q));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // Brute force
        // time = o(n) and space = o(n)
        if (p == null && q == null)
            return true;

        if (p != null && q != null && p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else
            return false;
    }
    // TODO: in BFS
}
