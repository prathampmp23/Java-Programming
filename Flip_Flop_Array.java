import java.util.Scanner;

class Flip_Flop_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        // Declare the 5X5 2D array to store the input
        String arr[] = new String[5];
        // Input 2D Array using Scanner Class and check data validity
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextLine();
        }
        char matrix[][] = new char[5][5];
        for (int i = 0; i < 5; i++) {
            char[] charArray = arr[i].toCharArray();
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = charArray[j];
            }
        }
        // Perform the Flip-Flop Operation
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == '0') {
                    System.out.print('1');
                } else {
                    System.out.print('0');
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
