public class q46_LowestCommonAncestorBinaryTree {
    public static void main(String[] args) {

    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // recursion
        // time = o(height = logn) and space = o(h)

        if (root == null || p == null || q == null)
            return null;

        if (Math.max(p.val, q.val) < root.val) {                            // Max of both vales is less than root --> left
            return lowestCommonAncestor(root.left, p, q);
        } else if (Math.min(p.val, q.val) > root.val) {                     // Min of both vales is greater than root --> right
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;                                                    // one is min, one of max or equal to root
        }
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // iteration
        // time = o(logn) or o(height) and space = o(1)                     height = logn

        TreeNode curr = root;

        while (curr != null) {                                              // p and q are in the Tree, so will be found here ... loop begins
            if (p.val > curr.val && q.val > curr.val )
                curr = curr.right;                                          // both greater than root --> iterate in right sub tree
            else if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;                                           // both less than root --> iterate in left sub tree
            } else {
                return curr;                                                // one is min, one of max or equal to root
            }
        }

        return null;
    }
}