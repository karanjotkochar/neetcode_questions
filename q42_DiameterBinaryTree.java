public class q42_DiameterBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root));
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        // Brute force
        // time = o(n*n) and space = o(n)
        if (root == null)
            return 0;

        int leftHeight = heightTree(root.left);
        int rightHeight = heightTree(root.right);
        int diaRoot = leftHeight + rightHeight;                                                             // Diameter of root node

        int diaChild = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));        // Diameter of child nodes

        return Math.max(diaRoot, diaChild);
    }
    private static int heightTree(TreeNode root) {
        if (root == null)
            return 0;
        int left = heightTree(root.left);
        int right = heightTree(root.right);

        return Math.max(left, right) + 1;
    }
    public static int diameterOfBinaryTree2(TreeNode root) {
        // Optimised DFS                                                    // exactly same, just calculating height and dia at same time
        // time = o(n) and space = o(n) or o(logn)
        int[] result = new int[1];                                          // Global variable -- keeps track of maximum value
        dfs(root, result);
        return result[0];
    }
    private static int dfs(TreeNode root, int[] result) {                   // dfs function: return heights <** Important **>
        if (root == null)
            return 0;

        int left = dfs(root.left, result);
        int right = dfs(root.right, result);
        result[0] = Math.max(result[0], left + right);

        return Math.max(left, right) + 1;
    }

}