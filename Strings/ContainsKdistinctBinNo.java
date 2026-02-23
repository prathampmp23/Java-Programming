import java.util.HashSet;
import java.util.Set;

public class ContainsKdistinctBinNo {
    public boolean hasAllCodes(String s, int k) {
        long totalBin = (long) Math.pow(2, k); // 2^K total binary code
        Set<String> set = new HashSet<>();
        // n−k+1 total substrings
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }
        return totalBin == set.size();
    }

    public static void main(String[] args) {
        
    }
}
