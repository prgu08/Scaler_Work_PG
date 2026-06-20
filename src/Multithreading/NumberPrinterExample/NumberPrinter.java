package Multithreading.NumberPrinterExample;

public class NumberPrinter implements Runnable {
   /* public static void main(String[] args){
        for(int i=0; i<=100; i++){
            System.out.println("Hello from " +Thread.currentThread().getName()+ " i: is "+i);
        }
    }
*/
    // Our aim is to create 100 threds each thred have one task ie print the number
    int number;

    NumberPrinter(int number){
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Printing Number From "+number+" from " +Thread.currentThread().getName());

    }
}
