import java.util.Scanner;

public class countFun {
    public static void countNumbers() {
        Scanner sc = new Scanner(System.in);
        
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
        
        while (true) {
            try {
                System.out.print("Enter a number or (enter a non-numeric value to stop): ");
                double number = Double.parseDouble(sc.nextLine());

                if (number > 0) {
                    positiveCount++;
                } else if (number < 0) {
                    negativeCount++;
                } else {
                    zeroCount++;
                }
            } catch (NumberFormatException e) {
                break; // Exit the loop if a non-numeric value is entered
            }
        }
        System.out.println("\nCount of positive numbers: " + positiveCount);
        System.out.println("Count of negative numbers: " + negativeCount);
        System.out.println("Count of zero numbers: " + zeroCount);
        
        sc.close();
    }
    public static void main(String[] args) {
        countNumbers();
    }
}
