package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class mostFreqNum {

    public static int mostFrequent(ArrayList<Integer> num, int key) {
        int count[] = new int[1001];

        // Building our count array
        for (int i = 0; i < num.size() - 1; i++) {
            if (num.get(i) == key) {
                count[num.get(i + 1)]++;
            }
        }

        // Find the index with the greatest entry
        int maxValue = 0;
        int target = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxValue) {
                target = i;
                maxValue = count[i];
            }
        }

        return target;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int key = sc.nextInt();
        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            arr.add(num);
        }
        sc.close();
        int ans = mostFrequent(arr, key);
        System.out.println(ans);
    }
}
