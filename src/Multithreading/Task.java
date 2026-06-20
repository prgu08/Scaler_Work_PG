package Multithreading;

public class Task implements Runnable{
    @Override
    public void run() {
        //business logic of the task that you need to run Concurrently
        System.out.println("Hello from" +Thread.currentThread().getName());
    }
}
