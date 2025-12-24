package Core;

    // **** Interface ****
    // 1. Normal interface
    interface ChessPlayer {
        void moves();
    }

    class Queen implements ChessPlayer {
        public void moves() {
            System.out.println("up down left right diagonal (in all direction)");
        }
    }

    class Rook implements ChessPlayer {
    public void moves() {
        System.out.println("up down left right diagonal");
    }
    }
    
    class King implements ChessPlayer {
        public void moves() {
            System.out.println("up down left right diagonal (by one moves)");
        }
    }
    
    // 2.Functional interface
    @FunctionalInterface // anotation , if we dont write then more than one method can be written
    interface A {
        void show();
    }
    
    class B implements A {
        public void show() {
            System.out.println("in show");
        }
    }
    
    // more example with parameters
    interface Add {
        int add(int a, int b);
    }
    public class InterfaceCode {
    public static void main(String[] args) {
        // Interface
        Queen q1 = new Queen();
        q1.moves();
        King k1 = new King();
        k1.moves();
        
        A objA = new A() { // as we can't instantiate interface object thats why we use,
        // --->>> anonymous inner class
            public void show() {
                System.out.println("inner show");
            }
        };
        objA.show();

        // lambda expression is only use with functional interface like
        A objANew = () -> System.out.println("new inner show");
        objANew.show();

        // if we need to pass variable
        // A objANew = (int i, int j) -> System.out.println("new inner show" + i + j);
        // or when it is single variable to pass
        // A objANew = i -> System.out.println("new inner show" + i);

        // example
        // Add ob = new Add() {
        //     public int add(int a, int b) {
        //         return a + b;
        //     }
        // };
        // Add ob = (int a,int b) -> { 
        //     return a+b;
        // };
        // when there is one statement and if return then dont write return
        Add ob = (int a,int b) -> a + b;
        int result = ob.add(2, 3);
        System.out.println(result);
    }
}
