import java.util.ArrayList;
import java.util.List;

public class q32_ReorderLinkedList {
    public static void main(String[] args) {
        ListNode ls = new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(8, null))));
        print(ls);
        reorderList(ls);
        print(ls);
        reorderList2(ls);
        print(ls);
    }
    public static void reorderList(ListNode head) {
        // ArrayList
        // time = o(n) and space = o(n)
        List<ListNode> nodes = new ArrayList<>();
        ListNode curr = head;

        if (head == null) {
            return;
        }

        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }

        int i = 0;
        int j = nodes.size() - 1;
        while (i<j) {
            nodes.get(i).next = nodes.get(j);
            i++;

            nodes.get(j).next = nodes.get(i);
            j--;

            if (i>=j) {
                break;
            }
        }
        nodes.get(i).next = null;
    }

    public static void reorderList2(ListNode head) {
        // Fast and slow pointer
        // time = o(n) and space = o(1)
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode firstList = head;
        ListNode secondList = slow.next;

        // reverse second list
        slow.next = null;
        ListNode prev = null;
        while (secondList != null) {
            ListNode temp = secondList.next;
            secondList.next = prev;
            prev = secondList;
            secondList = temp;
        }
        secondList = prev; // head of second list

        // merge two linked lists
        while (secondList != null) {
            ListNode temp1 = firstList.next;
            ListNode temp2 = secondList.next;

            firstList.next = secondList;
            secondList.next = temp1;
            firstList = temp1;
            secondList = temp2;
        }

    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(" " + head.val);
            head = head.next;
        }
        System.out.println();
    }
}
