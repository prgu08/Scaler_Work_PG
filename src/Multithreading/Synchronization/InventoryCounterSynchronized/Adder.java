package Multithreading.Synchronization.InventoryCounterSynchronized;

import Multithreading.Synchronization.InventoryCounterSynchronized.InventoryCounter;

public class Adder implements Runnable {

    InventoryCounter counter;
    //private Lock lock;

    public Adder(InventoryCounter counter) {
        this.counter = counter;
        //this.lock = lock;
    }

    @Override
    public void run() {
        //add to counte r1000 times
        for (int i = 1; i <= 1000; i++) {
            //putting lock on critical section ie cs
           // lock.lock();
            synchronized (counter) {
                this.counter.count++;
                //lock.unlock();
            }
        }
    }
}
