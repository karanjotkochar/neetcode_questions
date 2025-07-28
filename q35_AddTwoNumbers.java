public class q35_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode ls = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode ls2 = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode ls3 = addTwoNumbers(ls, ls2);
        print(ls3);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Iteration
        // time = o(m+n) and space = o(1) or o(max(m,n))

        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry !=0) {

            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int val = v1 + v2 + carry;

            carry = val / 10;
            val = val % 10;
            curr.next = new ListNode(val);

            curr = curr.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return dummy.next;
    }
    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(" " + head.val);
            head = head.next;
        }
        System.out.println();
    }
}
