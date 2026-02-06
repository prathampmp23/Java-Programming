import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupOfAnagrams {
    /*
     * For each word:-
     * 1. Convert to char array
     * 2. Sort it
     * 3. Convert back to string → key
     * 4. Put the word into map.get(key)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        /*
         * Input: strs = ["eat","tea","tan","ate","nat","bat"]
         * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
         */
    }
}
