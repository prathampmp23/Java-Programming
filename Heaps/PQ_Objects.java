package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ_Objects {

    // this is how we compare class objects
    static class Student implements Comparable<Student> { // overriding
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        // override parent function
        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }

    }

    public static void main(String[] args) {

        // PriorityQueue<Student> pq = new PriorityQueue<>();

        // This make order of priority in decreasing or reverse 
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new Student("A", 4));
        pq.add(new Student("B", 2));    
        pq.add(new Student("C", 7));
        pq.add(new Student("D", 5));

        while (!pq.isEmpty()) {
            // peek O(1)
            System.out.println(pq.peek().name + "->" + pq.peek().rank);
            // remove O(logn)
            pq.remove();
        }
    }
}
