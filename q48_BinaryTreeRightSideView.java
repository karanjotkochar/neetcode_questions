import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q48_BinaryTreeRightSideView {
    public static void main(String[] args) {

    }
    public static List<Integer> rightSideView(TreeNode root) {
        // BFS
        // time = o(n) and space = o(n)
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode rightSide = null;                      // Initiate right side, to add value every iteration
            int qLen = queue.size();

            for (int i = 0; i < qLen ; i++){                // Important Loop
                TreeNode node = queue.poll();               // adds all child nodes one by one + iterates to qLen
                if (node != null) {                         // @ last qLen = node for result + all child in queue
                    rightSide = node;
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (rightSide != null) {                        // add value inside right side to result
                result.add(rightSide.val);
            }
        }

        return result;
    }
}
