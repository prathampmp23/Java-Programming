package Stack;

import java.util.ArrayList;

public class ArrayListStack {

    public static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        // check Arraylist is empty or not
        public static boolean isEmpty() {
            return list.size() == 0; // if size == 0 then return true else false
        }

        // Push operation
        public static void push(int data) {
            list.add(data); // O(1)
        }

        // Pop operation
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1); // O(1)
            list.remove(list.size() - 1); // O(1)
            return top;
        }

        // Peek operation
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        // Stack s = new Stack();
        // Push
        Stack.push(1);
        Stack.push(2);
        Stack.push(3);
        while (!Stack.isEmpty()) {
            // Peek
            System.out.println(Stack.peek());
            // Pop
            Stack.pop();
        }
    }
}
