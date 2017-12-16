import java.util.ArrayList;
import java.util.List;

public class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()){
            TrieNode cur = node.letters[c-'a'];
            if (cur == null){
                node.letters[c-'a'] = new TrieNode();
            }
            node = cur;
            node.words.add(word);
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()){
            TrieNode cur = node.letters[c - 'a'];
            if (cur == null){
                return false;
            }
            node = cur;
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()){
            TrieNode cur = node.letters[c-'a'];
            if (cur == null){
                return false;
            }
            node = cur;
        }
        if (!node.words.isEmpty()){
            return false;
        }

        return true;
    }

    public class TrieNode{
        TrieNode[] letters = new TrieNode[26];
        boolean isEnd = false;
        List<String> words = new ArrayList<>();
    }

}
