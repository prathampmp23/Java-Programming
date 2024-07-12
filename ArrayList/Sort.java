package ArrayList;
import java.util.ArrayList;
import java.util.Collections;
public class Sort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(9);
        list.add(7);
        list.add(2);
        list.add(5);
        System.out.println(list);

        //Print in asending order
        Collections.sort(list);
        System.out.println(list);
        
        //To print in decending order
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
    
}