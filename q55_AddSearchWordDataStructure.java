class TrieNode2 {
    TrieNode2[] children = new TrieNode2[26];
    boolean word = false;
}

public class q55_AddSearchWordDataStructure {
    // using Trie Data structure and DFS
    // time = O(n) for all functions, n = length of string
    // space = O(n+t), t = total no of nodes(TrieNodes) created
    private TrieNode2 root;

    public q55_AddSearchWordDataStructure() {
        root = new TrieNode2();
    }

    public void addWord(String word) {
        TrieNode2 curr = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[i] == null) {
                curr.children[i] = new TrieNode2();
            }
            curr = curr.children[i];
        }
        curr.word = true;
    }

    public boolean search(String word) {
        // using DFS -- recursion to search word
        return dfs(word, 0, root);
    }
    private boolean dfs(String word, int j, TrieNode2 root) {
        TrieNode2 curr = root;

        // want to iterate this word, hence this for loop
        for (int i = j; i<word.length(); i++) {
            char c = word.charAt(i);
            int x = c - 'a';

            if (c == '.') {
                // when '.' --> get all the children and iterate --> if not null, dfs and recursion
                for (TrieNode2 child : curr.children) {
                    if (child != null && dfs(word, i+1, child)) {
                        return true;
                    }
                }
                return false;

            } else {
                if (curr.children[x] == null) {
                    return false;
                }
                curr = curr.children[x];
            }

        }

        return curr.word;
    }
}
