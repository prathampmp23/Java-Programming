package Heaps;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueues {
    public static void main(String[] args) {
        // This use default order of priority Ascending
        // PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        
        // This make order of priority in decreasing or reverse 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // Add O(logn)
        pq.add(3);  
        pq.add(4);
        pq.add(1);
        pq.add(7);

        while (!pq.isEmpty()) {
            // peek O(1)
            System.out.println(pq.peek()); 
            // remove  O(logn)
            pq.remove(); 
        }
    }
}
