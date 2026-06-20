package Multithreading;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello from main");
        System.out.println(Thread.currentThread().getName());
        // Until now we have one thread only not do any thing concurrenlt we will make another thread
        // and tell it the process we want to do it .
        //how to create another thread in java
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        t1.start();
        t2.start();
        System.out.println("We are done");
    }
}
