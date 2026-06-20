package Multithreading.NumberPrinterExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args){
        /*for(int i=0; i<100; i++){
            Thread t = new Thread(new NumberPrinter(i));
        }*/
        //Insted of using 100 threads we will use 10 threads using executble service in jav
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i=0; i<100; i++){
            if(i==5 || i==10 || i==20){
                System.out.println("Debug");
            }
            executor.execute(new NumberPrinter(i));
        }
        executor.shutdown();
    }
}
