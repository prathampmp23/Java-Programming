package Tries;

public class StartWithProblem {

    // Creation
    static class Node {
        Node children[] = new Node[26];
        boolean endOfWord = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    // Insert
    // T.c = O(L) where L is largest word length
    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        // for last char
        curr.endOfWord = true;
    }

    // Start With Prefix
    // T.c = O(L) where L is largest word length
    public static boolean startWithPefix(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return true;
    }

    public static void main(String[] args) {
        String words[] = { "apple", "mango", "man", "woman" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        String prefix = "app";
        System.out.println(startWithPefix(prefix));
    }

}
