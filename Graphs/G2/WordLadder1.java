package Graphs.G2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder1 {
    class Pair {
        String str;
        int len;

        public Pair(String str, int len) {
            this.str = str;
            this.len = len;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }

        set.remove(beginWord);
        while (!q.isEmpty()) {
            String word = q.peek().str;
            int steps = q.peek().len;
            q.poll();
            if (word.equals(endWord) == true)
                return steps;

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacementCharArr[] = word.toCharArray();
                    replacementCharArr[i] = ch;

                    String replacedWord = new String(replacementCharArr);
                    if (set.contains(replacedWord) == true) {
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }

    /*
     * A transformation sequence from word beginWord to word endWord using a
     * dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk
     * such that:
     * 
     * Every adjacent pair of words differs by a single letter.
     * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to
     * be in wordList.
     * sk == endWord
     * Given two words, beginWord and endWord, and a dictionary wordList, return the
     * number of words in the shortest transformation sequence from beginWord to
     * endWord, or 0 if no such sequence exists.
     * 
     * 
     * 
     * Example 1:
     * Input: beginWord = "hit", endWord = "cog", wordList =
     * ["hot","dot","dog","lot","log","cog"]
     * Output: 5
     * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot"
     * -> "dog" -> cog", which is 5 words long.
     */
}
