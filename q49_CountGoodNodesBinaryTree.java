public class q49_CountGoodNodesBinaryTree {
    public static void main(String[] args) {

    }

    public static int goodNodes(TreeNode root) {

        return dfs(root, root.val);
    }
    private static int dfs(TreeNode node, int maxValue) {       // creating function as max value of root has to compared with rest (to keep static)
        int result = 0;

        if (node == null)
            return 0;

        result = (node.val >= maxValue) ? 1 : 0;                // comparing and updating in each flow the max value
        maxValue = Math.max(node.val, maxValue);

        result += dfs(node.left, maxValue);
        result += dfs(node.right, maxValue);

        return result;
    }
}
