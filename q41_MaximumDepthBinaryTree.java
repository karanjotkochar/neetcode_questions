import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class q41_MaximumDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);

        System.out.println(maxDepth(root));
        System.out.println(maxDepth2(root));
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
    public static int maxDepth2(TreeNode root) {
        // Breadth First Search
        // time = o(n) and space = o(n)
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);                                    // add root to queue : begin level calculation
        }

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();                            // size of current queue to iterate

            for (int i=0; i<size; i++) {
                TreeNode node = q.poll();                   // remove node from left: poll

                if (node.left != null)                      // add to right: add and calculate = previous level
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);
            }
            level++;
        }
        return level;
    }

}
