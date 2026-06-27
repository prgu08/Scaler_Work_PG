package Multithreading.Synchronization.InventoryCounterExample;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {

    InventoryCounter counter;
    private Lock lock;

    public Adder(InventoryCounter counter, Lock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public void run() {
        //add to counte r1000 times
        for (int i = 1; i <= 1000; i++) {
            //putting lock on critical section ie cs
            lock.lock();
            this.counter.count++;
            lock.unlock();
        }
    }
}
