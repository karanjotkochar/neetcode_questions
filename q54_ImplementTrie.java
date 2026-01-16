class TrieNode {
    // each node has 26 children (Array) and end of word tells completion of word
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

public class q54_ImplementTrie {
    // time = O(n) for each function, n = length of string
    // space = o(t), t = total no of nodes(TrieNodes) created
    private TrieNode root;

    public q54_ImplementTrie() {
        // initialise root node
        root = new TrieNode();
    }

    public void insert(String word) {
        // initialise curr (children array) and start from assigning to root and traverse till end
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        // initialise curr (children array) and start from assigning to root and traverse till end
        // check if end of word is true
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
                return false;
            }
            curr = curr.children[i];
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        // check for all characters and return true/false
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
                return false;
            }
            curr = curr.children[i];
        }
        return true;
    }
}
