package Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IOCode {
    public static void main(String[] args) throws IOException {
        // OutPut
        System.out.println("Enter a number :");

        // Input
        // only read one char at a time
        int num = System.in.read(); // this gives ASCII value like 0 -> 48
        System.out.println(num);
        System.out.println(num - 48); // this won't accept number like 55

        // BufferReader take input from file, system , keyboard
        // InputStreamReader in = new InputStreamReader(System.in); // System.in as it require InputStream object
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(bf.readLine());
        System.out.println(num1);

        // Buffer is resource
        bf.close();

        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        System.out.println(nums);
        sc.close();
    }
}
