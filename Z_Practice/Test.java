package Z_Practice;

public class Test {

    public static int linearSearch(String arr[], String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String arr[] = { "samosa", "poha", "idli", "kauchori", "sambarvada", "upma" };
        String key = "poha";
        System.out.println("String is found at index : " + linearSearch(arr, key));
    }
}
