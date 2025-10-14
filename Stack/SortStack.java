package Stack;

import java.util.Stack;

public class SortStack {
    public static void insertSorted(Stack<Integer> stack, int element) {
        // Base Case: If stack is empty or element is greater than or equal to the top
        // element
        // For descending order, if the new element is larger or equal, it should be at
        // the top.
        if (stack.isEmpty() || element >= stack.peek()) {
            stack.push(element);
            return;
        }

        // Recursive Step: Pop top, recursively insert, then push top back
        int temp = stack.pop();
        insertSorted(stack, element);
        stack.push(temp);
    }

    public static void sortStack(Stack<Integer> stack) {
        // Base Case: If stack is empty, it's already sorted
        if (stack.isEmpty()) {
            return;
        }

        // Recursive Step: Pop element, sort remaining stack, then insert element
        int temp = stack.pop();
        sortStack(stack); // Sort the rest of the stack
        insertSorted(stack, temp); // Insert the popped element into its correct sorted position
    }

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(30);
        myStack.push(-5);
        myStack.push(18);
        myStack.push(14);
        myStack.push(-3);

        System.out.println("Original Stack: " + myStack);

        sortStack(myStack);

        System.out.println("Sorted Stack (descending, top is greatest): " );
        while (!myStack.isEmpty()) {
            // Peek
            System.out.println(myStack.peek());
            // Pop
            myStack.pop();
        }


    }
}
