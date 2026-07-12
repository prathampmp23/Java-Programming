package com.cts.functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface Functional {
	int operation(int a, int b);
}

public class LambdaExpression {

	public static void main(String[] args) {

		// Using lambda expressions to define the operations
		Functional add = (a, b) -> a + b;
		Functional multiply = (a, b) -> a * b;

		// Using the operations
		System.out.println(add.operation(6, 3));
		System.out.println(multiply.operation(4, 5));

//		Predicate - return boolean 
//		boolean test(T t) abstract method
		Predicate<Integer> p1 = (a) -> (a > 10);
		System.out.println(p1.test(15)); // true
		System.out.println(p1.test(10)); // false

		Predicate<Integer> p2 = (x) -> x % 2 == 0;
		System.out.println(p2.test(15)); // false
		System.out.println(p2.test(10)); // true

		System.out.println(p1.and(p2).test(20)); // true
		System.out.println(p1.or(p2).test(4)); // true

//		Function - take input of any type and return output of given type
//		R apply(T t) abstract method (return single value)
		Function<Integer, Integer> f = x -> {
			int fact = 1;
			for (int i = 2; i <= x; i++) {
				fact = fact * i;
			}
			return fact;
		};

		System.out.println(f.apply(5));
		System.out.println(f.apply(7));

//		Consumer - take one input but wont return anything
//		void accept(T t) abstract method 
		Consumer<Integer> c = (x) -> {
			System.out.println(x);
		};
		
		c.accept(23);
		c.accept(2003);
		
//		Supplier - takes nothing but return value of type
//		T get() - abstract method 
		Supplier<Double> s = () -> {
			return 10000 * Math.random();
		};
		
		System.out.println(s.get());
		
//		BiFunction - 
		BiFunction<Integer, Integer, Boolean> b1 = (a,b) -> a > b;
		System.out.println(b1.apply(5, 6));
		
//		BiConsumer
//		BiPredicate

	}
}
