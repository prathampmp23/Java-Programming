import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class table {
    public static void main(String args[]) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter the number whose table you want to print: ");
            int number = Integer.parseInt(bufferedReader.readLine().trim());

            System.out.println("Table of " + number + " is:");
            for (int i = 1; i <= 10; i++) {
                System.out.println(number + " x " + i + " = " + (number * i));
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
