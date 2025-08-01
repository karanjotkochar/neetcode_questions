public class q33_RemoveNodeEndLinkedList {
    public static void main(String[] args) {
        ListNode ls = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        int n = 2;
        print(ls);
        removeNthFromEnd(ls, n);
        removeNthFromEnd2(ls, n);
        print(ls);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // brute force
        // time = o(n) and space = o(1)
        int i = 0;
        ListNode curr = head;

        while (curr != null) {
            i++;
            curr = curr.next;
        }

        int removeIndex = i-n;
        if (removeIndex == 0) {
            return head.next;
        }

        curr = head;
        for (int k = 0; k < i-1; k++) {
            if ( (k+1) == removeIndex ) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }

        return head;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        // two pointer
        // time = o(n) and space = o(1)

        // dummy node to start from ), keeping one position back
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode left = dummy;
        ListNode right = head;

        // right reaches end of Linked List
        while (n>0) {
            right = right.next;
            n--;
        }

        // right is at end and left is one position back to the nth node
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

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
