public class q30_MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        ListNode ls = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode ls2 = new ListNode(1, new ListNode(3, new ListNode(5, null)));

        print(ls);
        print(ls2);
        mergeTwoLists(ls, ls2);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // brute force
        // time = o(n+m) and space = o(1)

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        if (list1 != null) {
            node.next = list1;
        } else {
            node.next = list2;
        }

        return dummy.next;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(" " + head.val);
            head = head.next;
        }
    }

}