package Arrays1D;

// import java.util.*;
public class SearchString {

    // method for searching string by linear search
    public static int searchString(String st[], String key) {
        for (int i = 0; i < st.length; i++) {
            if (key.equals(st[i])) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        // Scanner sc = new Scanner(System.in);
        String st[] = { "pratham", "manish", "potdar" };
        int result = searchString(st, "pratham");
        if (result == -1) {
            System.out.println("String not found");
        } else {
            System.out.println("String is found at place: " + result);
        }
    }
}
