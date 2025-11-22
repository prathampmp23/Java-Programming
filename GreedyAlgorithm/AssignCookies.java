package GreedyAlgorithm;

import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length;
        int m = s.length;
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < n && j < m) {
            if (s[j] >= g[i]) {
                ans++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int g[] = {1,2,3};
        int s[] = {1,1};
        System.out.println(findContentChildren(g, s));
        int g2[] = {1,2};
        int s2[] = {1,2,3};
        System.out.println(findContentChildren(g2, s2));
    }
}
