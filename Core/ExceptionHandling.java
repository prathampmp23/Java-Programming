package Core;

// Custom Exception 
class CustomExcption extends Exception {
    public CustomExcption(String s) {
        super(s); // calls Exception class constructor
    }
}

// throws use
class A {
    public void show() throws ClassNotFoundException {
        Class.forName("CustomException");
    }
}

public class ExceptionHandling {

    public static void main(String[] args) {
        /*
         * Exception Basics :
         * Definition: An exceptional condition that disrupts normal program flow.
         * Source: Triggered by runtime issues (I/O, bad input) or programming errors
         * (null dereference).
         * Flow: Thrown, optionally caught; otherwise propagates up the call stack.
         * Intent: Signal recoverable problems or indicate bugs depending on type.
         * Outcome: If unhandled, terminates the thread and reports a stack trace.
         * 
         * Hierarchy (Java)
         * Throwable: Root type for all exceptions and errors.
         * Error: Serious JVM issues (e.g., OutOfMemoryError); not meant to be caught.
         * Exception: Recoverable conditions; includes checked and unchecked subclasses.
         * RuntimeException: Unchecked exceptions (e.g., NullPointerException,
         * IllegalArgumentException).
         * Custom: Domain-specific types extend Exception or RuntimeException based on
         * recoverability.
         * 
         * Types of Exceptions
         * 
         * 1. Checked Exceptions
         * Definition: Subclasses of Exception (excluding RuntimeException) enforced at
         * compile-time.
         * Contract: Methods must throw or handle; callers must acknowledge via
         * try/catch or throws.
         * Examples: IOException, SQLException, ClassNotFoundException, ParseException.
         * Use When: The caller can reasonably recover (retry, fallback, ask for
         * different input).
         * Pros/Cons: Encourages handling but can lead to verbose code and leaky
         * abstractions if overused.
         * 
         * 
         * 2. Unchecked Exceptions
         * Definition: Subclasses of RuntimeException; no compile-time enforcement.
         * Nature: Programming errors or precondition violations (often not recoverable
         * locally).
         * Examples: NullPointerException, IndexOutOfBoundsException,
         * ArithmeticException, IllegalStateException, IllegalArgumentException.
         * Use When: Signaling bugs, invalid API usage, or violations of method
         * preconditions.
         * Pros/Cons: Cleaner signatures; risk of missed handling if misuse masks
         * recoverable states.
         */
        // int i = 0;
        // int j = 10;
        // below line give Exception in thread "main" java.lang.ArithmeticException: /
        // by zero
        // System.out.println(j / i);

        // try catch block
        int a = 4;
        int b = 0;
        try {
            b = a / 0;
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            System.out.println(e);
        }
        System.out.println(b);
        System.out.println("Bye");

        // multiple catch block
        int i = 4;
        int j = 5;
        int arr[] = new int[5];
        // String str = null;
        try {
            j = i / j;
            System.out.println(arr[10]);
            // System.out.println(str.length());
        } catch (ArithmeticException e) {
            System.out.println("Cant divide by zero");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("stay in array limit");
        } catch (Exception e) {
            System.out.println("Something went wrong " + e);
        }
        System.out.println(j);
        System.out.println("Bye");

        // throw keyword
        int x = 4;
        int y = 0;
        try {
            y = x / y;
            if (y == 0) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException e) {
            y = x / 1;
            System.out.println("Thats the default value");
        }
        System.out.println(y);

        // custom Exception
        int p = 4;
        int q = 0;
        try {
            p = p / 2;
            if (q == 0) {
                throw new CustomExcption("called custom Exception");
            }
        } catch (CustomExcption e) {
            q = p / 1;
            System.out.println("Thats the default value " + e);
        }
        System.out.println(p);
        System.out.println("Its work");

        // throws keyword

        // insted of this
        // try {
        // Class.forName("Core.ExceptionHandling");
        // } catch (ClassNotFoundException e) {
        // System.out.println("class not found");
        // }

        // use this but it is not better to throws exception in main method so use
        // tryCatch block
        // public static void main(String[] args) throws ClassNotFoundException {
        // Class.forName("Core.ExceptionHandling");

        A obj = new A();
        try {
            obj.show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // print which method calls which
        }
    }
}
