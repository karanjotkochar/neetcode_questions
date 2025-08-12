import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q47_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        // BFS
        // time = o(n) and space = o(n)

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();                   // take the node (Poll)
                if (node != null) {
                    level.add(node.val);                        // add to individual level list

                    queue.add(node.left);                       // add node's left child
                    queue.add(node.right);                      // add node's right child
                }
            }

            if (level.size() > 0) {                             // individual list exist, add it
                result.add(level);
            }

        }
        return result;
    }
}
