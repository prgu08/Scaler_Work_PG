package Multithreading.Synchronization.InventoryCounterExample;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable {

    private InventoryCounter counter;
    private Lock lock;

    public Subtractor(InventoryCounter counter, Lock lock){
        this.counter=counter;
        this.lock=lock;
    }
    @Override
    public void run() {
        //subtract from counter 1000 times
        for (int i = 0; i < 1000; i++) {
            lock.lock();
            this.counter.count--;
            lock.unlock();
        }
    }
}
