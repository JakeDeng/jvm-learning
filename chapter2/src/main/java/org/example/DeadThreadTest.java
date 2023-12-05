package org.example;

public class DeadThreadTest {
    public static void main(String[] args) {
        //create a lambda function
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + " Start");
            //DeadThread dead = new DeadThread();
            LiveThread live = new LiveThread();
            System.out.println(Thread.currentThread().getName() + " End");
        };

        Thread t1 = new Thread(r, "Thread 1");
        Thread t2 = new Thread(r, "Thread 2");

        t1.start();
        t2.start();
    }
}

class DeadThread{
    static {
        if(true){
            System.out.println(Thread.currentThread().getName() + " init dead thread class");
            while(true) {

            }
        }
    }
}

class LiveThread{
    //clinit will only gets run once
    static {
        if (true){
            System.out.println(Thread.currentThread().getName() + " init live thread class");
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
        }
    }
}
