import java.util.Arrays;
import java.util.HashMap;

public class q34_CopyLinkedListRandomPointer {
    public static void main(String[] args) {
        Node node1 = new Node(3);
        Node node2 = new Node(7);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        node1.random = null;
        node2.random = node4;
        node3.random = node1;
        node4.random = node2;

    }
    public static Node copyRandomList(Node head) {
        // Two Pass algorithm using HashMap
        // time = o(n) and space = o(n)

        HashMap<Node, Node> map = new HashMap<>();
        map.put(null, null);                // edge case

        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val); // make copy of node
            map.put(curr, copy);            // put current node(key), copy of node(val)
            curr = curr.next;
        }

        curr = head;
        while (curr != null) { // connecting pointers
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);

            curr = curr.next;
        }
        return map.get(head);
    }
    // TODO: Revise again
}

class Node {
    int val;
    Node next;
    Node random;
    public Node (int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
