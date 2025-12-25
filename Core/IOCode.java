package Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IOCode {

    // For CSES coding platform specifically Format
    public static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws IOException {
        // OutPut
        System.out.println("Enter a number :");

        // Input
        // only read one char at a time
        int num = System.in.read(); // this gives ASCII value like 0 -> 48
        System.out.println(num);
        System.out.println(num - 48); // this won't accept number like 55

        // BufferReader take input from file, system , keyboard
        // InputStreamReader in = new InputStreamReader(System.in); // System.in as it
        // require InputStream object
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(bf.readLine());
        System.out.println(num1);

        // Buffer is resource
        bf.close();

        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        System.out.println(nums);
        scanner.close();

        // For CSES coding platform specifically Format ,but also this can be possible like Scanner
        // BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        FastScanner sc = new FastScanner(); // instance
        int n = sc.nextInt();

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            set.add(c);
        }

        System.out.println(set.size());
    }
}
