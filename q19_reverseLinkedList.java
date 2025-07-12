public class q19_reverseLinkedList {

    public static void main(String[] args) {

        ListNode ls = new ListNode(1,
                        new ListNode(2,
                        new ListNode(3,
                        new ListNode(4,
                        new  ListNode(5, null)))));
        print(ls);
        System.out.println();

        ListNode ls2 = reverseList(ls);
        print(ls2);
    }
    public static ListNode reverseList(ListNode head) {
        // optimal
        // time = o(n) and space = o(1)
        ListNode prev = null;
        ListNode current = head;
        ListNode temp;

        while(current != null) {
            temp = current.next;
            current.next = prev;

            prev = current;
            current = temp;
        }

        return prev;
    }
    public static void print(ListNode head) {

        while (head != null) {
            System.out.print(" " + head.val);
            head = head.next;
        }
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
