package Core;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
// import java.util.function.Function;
// import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamAPICode {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 3, 4, 5, 6, 7);
        System.out.println(nums);

        int sum = 0;
        for (int n : nums) {
            if (n % 2 == 0) {
                n = n * 2;
                sum += n;
            }
        }
        System.out.println(sum);

        // loops to print List elements
        // Normal for loop
        for (int i = 0; i < nums.size(); i++) {
            System.out.print(nums.get(i) + " ");
        }
        System.out.println();

        // Enhanced for loop
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();

        // using .forEach() method of list
        nums.forEach(n -> System.out.print(n+ " "));
        System.out.println();

        // ** How this above code works ?, it take consumer object and it is also functional interface
        // Consumer<Integer> con = new Consumer<Integer>() {
        //     public void accept(Integer n) {
        //         System.out.println(n);
        //     }
        // };

        // So Lambda expression is possible
        Consumer<Integer> con =  n -> System.out.print(n + " ");
        nums.forEach(con);
        System.out.println();
        // or 
        nums.forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        
        // ***** Stream API ****** //
        // Stream : whatever changes made in stream don't affect nums (list) data
        // But we can use the stream only once
        Stream<Integer> s1 = nums.stream();
        // s1.forEach(n -> System.out.print(n+ " "));

        // we can't print again and again this give exception
        // Exception in thread "main" java.lang.IllegalStateException: 
        // stream has already been operated upon or closed
        // s1.forEach(n -> System.out.print(n+ " "));
        
        // to filter even numbers from list using .filter() return new stream
        Stream<Integer> s2 = s1.filter(n -> n%2==0);
        // s2.forEach(n -> System.out.print(n+ " "));

        // double the even list elements using .map() return new stream
        Stream<Integer> s3 = s2.map(n -> n*2);
        // s3.forEach(n -> System.out.println(n));

        // using .reduce() return new single used datatype value like int
        int result = s3.reduce(0, (c,e) -> c+e);
        System.out.println(result); // sum

        // all the above stream logic in single line
        int ans = nums.stream()
            .filter(n -> n%2==0)
            .map(n -> n*2)
            .reduce(0, (c,e) -> c+e);

        System.out.println(ans);

        // ** how .filter(n -> n%2==0) works
        // Predicate<Integer> pred = new Predicate<Integer>() {
        //     public boolean test(Integer n) {
        //         return n%2 == 0;
        //     }
        // };

        // lambda expression
        // Predicate<Integer> pred = n -> n%2 == 0;
        // s1.filter(pred);
        // or
        // s1.filter(n -> n%2 == 0);

        // ** how .map(n -> n*2) works
        // Function<what it except, and what it return>
        // Function<Integer, Integer> fun = new Function<Integer,Integer>() {
        //     public Integer apply(Integer n) {
        //         return n*2;
        //     }
        // };

        // lambda Expression
        // Function<Integer, Integer> fun = n -> n*2;
        // s2.map(fun);
        // or
        // s2.map(n -> n*2);
        
        // to sort stream
        Stream<Integer> sortedNums = nums.stream()
            .filter(n -> n%2==0)
            .map(n -> n*2)
            .sorted();

        sortedNums.forEach(n -> System.out.print(n+ " "));

        // in multi threading use "nums.parallelStream()"
        // *** but don't use .sorting() with parallelStream()
    }
}
