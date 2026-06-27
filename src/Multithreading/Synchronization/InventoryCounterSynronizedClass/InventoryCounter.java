package Multithreading.Synchronization.InventoryCounterSynronizedClass;

public class InventoryCounter {
    private Integer count = 0;

    public InventoryCounter() {
        this.count = count;
    }

    public synchronized void increment() {
        this.count++;
    }

    public synchronized void decrement() {
        this.count--;
    }

    public Integer getCount() {
        return count;
    }
}
