import com.sun.source.tree.Tree;

public class q40_InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        invertTree(root);
        print(root);
    }
    public static TreeNode invertTree(TreeNode root) {
        // Depth First Search
        // time = o(n) and space = o(n)

        if (root == null)
            return null;

        TreeNode tempVal = root.left;

        root.left = root.right;
        root.right = tempVal;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void print(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        print(root.left);
        print(root.right);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}