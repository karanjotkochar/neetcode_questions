import java.util.HashMap;
import java.util.HashSet;

public class q31_LinkedListCycleDetection {
    public static void main(String[] args) {
        ListNode ls = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        // hasCycle(ls);
        System.out.println(hasCycle(ls));
        System.out.println(hasCycle2(ls));
    }
    public static boolean hasCycle(ListNode head) {
        // hash set
        // time = o(n) and space = o(n)
        HashSet<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
    public static boolean hasCycle2(ListNode head) {
        // fast and slow pointers
        // time = o(n) and space = o(1)
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(" " + head.val);
            head = head.next;
        }
    }

}
