package Stack;

public class ArrayStack {
    private int[] stack; // array to store elements
    private int top; // points to top index
    private int capacity; // maximum size of stack

    // Constructor
    public ArrayStack(int size) {
        stack = new int[size];
        capacity = size;
        top = -1; // stack is empty initially
    }

    // Push element x into stack
    public void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = x;
    }

    // Pop top element and return it
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    // Return top element without removing it
    public int peek() {
        if (isEmpty())
            return -1;
        return stack[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(2);
        stack.push(5);
        stack.push(10);

        int topEl = stack.peek(); // returns 10
        System.out.println(topEl);

        int removeEl = stack.pop(); // returns 10
        System.out.println(removeEl);

        System.out.println(stack.isEmpty()); // returns false
    }
}
