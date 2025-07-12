public class q19_reverseLinkedList {

    public static void main(String[] args) {
    }
    public static ListNode reverseList(ListNode head) {
        // optimal
        // time = o(n) and space = o(n)
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
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}
