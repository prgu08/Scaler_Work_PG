package Multithreading.Synchronization.InventoryCounterSynchronized;

import Multithreading.Synchronization.InventoryCounterSynchronized.InventoryCounter;

public class Subtractor implements Runnable {

    private InventoryCounter counter;
   // private Lock lock;

    public Subtractor(InventoryCounter counter){
        this.counter=counter;
       // this.lock=lock;
    }
    @Override
    public void run() {
        //subtract from counter 1000 times
        for (int i = 0; i < 1000; i++) {
            synchronized (counter) {
                //lock.lock();
                this.counter.count--;
                //lock.unlock();
            }
        }
    }
}
