import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q51_KthSmallestIntegerBST {
    public static void main(String[] args) {

    }
    public static int kthSmallest(TreeNode root, int k) {
        // Brute force
        // time = o(nlogn) and space = o(n)
        List<Integer> result = new ArrayList<>();

        dfs(root, result);
        Collections.sort(result);
        return result.get(k-1);
    }

    private static void dfs(TreeNode node, List<Integer> result) {

        if (node == null)
            return;

        result.add(node.val);

        dfs(node.left, result);
        dfs(node.right, result);
    }
    //----------------------------------------------------------------------
    //----------------------------------------------------------------------
    public static int kthSmallest2(TreeNode root, int k) {
        // Inorder Traversal
        // time = o(n) and space = o(n)
        List<Integer> result = new ArrayList<>();

        dfs2(root, result);
        return result.get(k-1);
    }

    private static void dfs2(TreeNode node, List<Integer> result) {

        if (node == null)
            return;

        dfs(node.left, result);                             // INORDER = left. root, right
        result.add(node.val);
        dfs(node.right, result);
    }

}
