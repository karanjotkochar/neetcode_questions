import java.util.HashMap;

public class q37_LRUCache_v2 {
    private int capacity;
    private HashMap<Integer, NodeLL> cache;                 // map (key and node)
    private NodeLL left;                                    // dummy left and right nodes, default values zero and connected to each other
    private NodeLL right;
    public static void main(String[] args) {
    }
    public q37_LRUCache_v2(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new NodeLL(0,0);                // left for LRU and right for MRU
        this.right = new NodeLL(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    private void remove(NodeLL node_passed) {               // remove node from the list (passed node is middle node, there is left and right to it)
        NodeLL prv = node_passed.prev;          //left
        NodeLL nxt = node_passed.next;          //right
        prv.next = nxt;
        nxt.prev = prv;
    }
    private void insert(NodeLL node_passed) {               // insert node at the rightmost position, before right pointer
        NodeLL prv = this.right.prev;           //left
        // and right = this.right               //right

        prv.next = node_passed;
        node_passed.prev = prv;

        node_passed.next = this.right;
        this.right.prev = node_passed;
    }
    public int get(int key) {
        if (cache.containsKey(key)) {
            NodeLL getNode = cache.get(key);                // from key --> get value (Node) + remove/insert to make MRU
            remove(getNode);
            insert(getNode);
            return getNode.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {                       // from key --> get value (Node) + remove + new node + put in hashmap
            remove(cache.get(key));
        }
        NodeLL putNode = new NodeLL(key, value);
        cache.put(key, putNode);                            // hashmap has pointer to new node
        insert(putNode);                                    // add to doubly linked list which exist b/w left and right

        if (cache.size() > capacity) {                      // capacity exceeded? -> remove lru from left (always) --> gives node
            NodeLL lru = this.left.next;                    // remove from the linked list and delete from cache
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
class NodeLL {
    int key;                                                    // Node has (key, value) && (left, right pointer)
    int val;
    NodeLL prev;
    NodeLL next;

    NodeLL(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}