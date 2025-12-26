package Core;

// if class wont extend another class than Thread then use 
// class Class_Name extends Thread {
//     public void run() {}
// }

// if it extends another class than Thread then use implements Runnable
class Aclass implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("hii");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } // waiting state
        }
    }
}

class Bclass implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("hello");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } // waiting state
        }
    }
}


class Counter {
    int count;
    public synchronized void increment() {
        count++;
    }
}

public class ThreadsCode {

    public static void main(String[] args) throws InterruptedException {
        // *** if "extends Thread" is used ***
        // Aclass obj1 = new Aclass();
        // Bclass obj2 = new Bclass();

        // System.out.println(obj1.getPriority());
        // System.out.println(obj2.getPriority());

        // obj2.setPriority(Thread.MAX_PRIORITY);

        // If class used "extend Thread"
        // obj1.start();
        // obj2.start();

        // *** if "implements Runnable" is used ***
        // Runnable obj1 = new Aclass();
        // Runnable obj2 = new Bclass();

        // Using Lambda Expression class can not be written it should be like
        // we instantiate a runnable interface with anonymous class
        // Runnable obj1 = new Runnable() {
        //     public void run() {
        //         for (int i = 1; i <= 10; i++) {
        //             System.out.println("hii");
        //             try {
        //                 Thread.sleep(10);
        //             } catch (InterruptedException e) {
        //                 e.printStackTrace();
        //             } 
        //         }
        //     }
        // };

        // // Into Lambda Expression
        // Runnable obj1 = () -> { // anonymous class 
        //     for (int i = 1; i <= 10; i++) {
        //         System.out.println("hii");
        //         try {
        //             Thread.sleep(10);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         } 
        //     }
        // };
        // Runnable obj2 = () -> { 
        //     for (int i = 1; i <= 10; i++) {
        //         System.out.println("hello");
        //         try {
        //             Thread.sleep(10);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         } 
        //     }
        // };

        // // As Runnable interface dont have thread method
        // Thread T1 = new Thread(obj1);
        // Thread T2 = new Thread(obj2);

        // T1.start();
        // T2.start();

        // *** Race Condition ***
        // Use of Thread Safe
        Counter c = new Counter();

        Runnable obja = () -> { 
            for (int i = 1; i <= 1000; i++) {
                c.increment();
            }
        };
        Runnable objb = () -> { 
            for (int i = 1; i <= 1000; i++) {
                c.increment();
            }
        };

        Thread Ta = new Thread(obja);
        Thread Tb = new Thread(objb);

        Ta.start();
        Tb.start();

        // this will give diff value as it wont wait for other Thread to complete
        System.out.println(c.count);

        // This make wait till the both thread complete then print
        // but we still don't control thread as it amy provide diff o/p
        // because if both thread appears on same time
        Ta.join();
        Tb.join();  
            
        System.out.println(c.count);
        
        // to get proper o/p we use keyword "syncronized" 
        // to wait other Thread before one finish increment
        System.out.println(c.count);

    }
}