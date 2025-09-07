package Arrays2D;

import java.util.Scanner;

public class MagicalLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] % 2 != 0) {
                    sum += arr[i][j];
                }
            }
            if (sum % 2 == 0 && sum != 0) {
                count++;
            }
        }

        System.out.println(count);
        sc.close();

    }
}
