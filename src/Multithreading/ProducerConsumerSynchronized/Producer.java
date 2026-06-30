package Multithreading.ProducerConsumerSynchronized;

import java.util.Queue;

public class Producer implements Runnable {
    private Queue<Object> q;
    private int maxSize;
    private String name;

    public Producer(Queue<Object> q, int maxSize, String name) {
        this.q = q;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run(){
        //Each Producer wants to continuously produces
        //T-shirt and add them to the queue if there is space available
        while(true){
            synchronized (q) {
                if (q.size() < this.maxSize) {
                    System.out.println("adding - "+ q.size());
                    q.add(new Object());
                }
            }
        }
    }
}
