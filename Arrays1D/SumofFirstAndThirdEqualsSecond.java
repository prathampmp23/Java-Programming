package Arrays1D;

public class SumofFirstAndThirdEqualsSecond {

    public static void sumOf1stAnd3rd(int arr[]) {
        int count = 0;
        if (arr.length == 1 || arr.length == 2)
            return;

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] + arr[i + 1] == arr[i]) {
                count++;
            }
        }
        System.out.println("Count = "+count);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 3, 5, 2, 4, 2 };
        sumOf1stAnd3rd(arr);
    }
}
