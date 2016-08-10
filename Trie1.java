import java.util.HashMap;

class TrieNode1 {
    boolean isWord;
    HashMap<Character, TrieNode1> nexts;

    public TrieNode1() {
        nexts = new HashMap<Character, TrieNode1>();
    }
}


public class Trie1 {
    private TrieNode1 root;

    public Trie1() {
        root = new TrieNode1();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] s = word.toCharArray();

        TrieNode1 p = root;
        int i = 0, n = s.length;

        // traverse existing
        while (i < n) {
            TrieNode1 next = p.nexts.get(s[i]);
            if (next != null) {
                p = next;
                i ++;
            } else {
                break;
            }
        }

        // append new nodes
        while (i < n) {
            TrieNode1 newTrie = new TrieNode1();
            p.nexts.put(s[i], newTrie);
            p = newTrie;
            i ++;
        }

        // set word end
        p.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode1 p = root;

        for (int i = 0; i < word.length(); i ++) {
            TrieNode1 child = p.nexts.get(word.charAt(i));
            if (child == null) {
                return false;
            }
            p = child;
        }

        return p.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode1 p = root;

        for (int i = 0; i < prefix.length(); i ++) {
            TrieNode1 child = p.nexts.get(prefix.charAt(i));
            if (child == null) {
                return false;
            }
            p = child;
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("keydsdsds");
        System.out.println(trie.startsWith("key"));
    }
}