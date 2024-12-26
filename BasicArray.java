public class BasicArray {
    public static void main(String args[]) {
        int values[] = new int[5];
        values[0] = 10;
        values[1] = 20;
        values[2] = 30;
        values[3] = 40;
        values[4] = 50;

        // ArrayIndexOutOfBoundsException
        // System.out.println(values[9]);

        // for loop
        System.out.print("For loop = ");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();

        // For-each loop
        System.out.print("For-each loop = ");
        for (int value : values) {
            System.out.print(value + " ");
        }
        System.out.println();
        // to print length of array
        System.out.println("Length of array is : " + values.length);

        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += values[i];
        }
        for (int value : values) {
            sum += value;
        }
        System.out.println("Sum of array is : " + sum);

        // To find smallest numbers in array
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < values.length; i++) {
            if (values[i] < min) {
                min = values[i];
            }
        }
        System.out.println("Smallest number is : " + min);

        // To find largest numbers in array
        int max = Integer.MIN_VALUE;
        for (int value : values) {
            if (value > min) {
                max = value;
            }
        }
        System.out.println("Largest number is : " + max);
    }

}
