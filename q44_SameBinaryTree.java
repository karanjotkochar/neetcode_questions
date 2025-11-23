import java.util.LinkedList;
import java.util.Queue;

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
        // Brute force -- Depth First Search
        // time = o(n) and space = o(n)
        if (p == null && q == null)
            return true;

        if (p != null && q != null && p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else
            return false;
    }
    public static boolean isSameTree2(TreeNode p, TreeNode q) {
        // Breadth first search
        // time = o(n) and space = o(n)

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {                                    // && because we want loop to work until q1, q2 are empty

            for (int i = q1.size(); i>0; i--) {
                TreeNode nodeP = q1.poll();
                TreeNode nodeQ = q2.poll();

                if (nodeP == null && nodeQ == null)
                    continue;

                if (nodeP == null || nodeQ ==null || nodeP.val != nodeQ.val )
                    return false;

                q1.add(nodeP.left);
                q1.add(nodeP.right);

                q2.add(nodeP.left);
                q2.add(nodeQ.right);
            }
        }

        return true;
    }

}
