package ArrayList;
import java.util.ArrayList;
public class OperationOnList {
    public static void main(String args[]) {
        //Declaration of array list
        ArrayList<Integer> list = new ArrayList<>();

        //to add elements in list
            //time complexity required to add is  constant =  O(1) 
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);

        //get operation
        int element = list.get(0);
        System.out.println(element);

        //Delete  operation
        list.remove(2);
        System.out.println(list);

        //set operation
        list.set(2,5 );
        System.out.println(list);

        //Contains operation
        System.out.println(list.contains(2));
        System.out.println(list.contains(4));

        //To get size of array list
        System.out.println(list.size());

        //To check is array list is empty or not
        System.out.println(list.isEmpty());

        //to print array list in loop form
        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
}
