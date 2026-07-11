import java.util.Scanner;

public class UserInterface {

	public static String sumOfArrays(String data)
			throws NegativeArraySizeException, NumberFormatException, ArrayIndexOutOfBoundsException {

		String[] elements = data.split(":");

		int size = Integer.parseInt(elements[0]);

		if (size < 0) {
			throw new NegativeArraySizeException("Provide a positive Integer to allocate memory for the array");
		}

		if (elements.length - 1 > size) {
			throw new ArrayIndexOutOfBoundsException("Error: Array index is out of range");
		}

		int sum = 0;
		for (int i = 1; i <= size; i++) {
			sum += Integer.parseInt(elements[i]);
		}

		return "Sum of the array elements is " + sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the data");
		String data = sc.nextLine();

		try {
			System.out.println(sumOfArrays(data));
		} catch (NumberFormatException e) {
			System.out.println("Provide a valid Integer");
		} catch (NegativeArraySizeException e) {
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
