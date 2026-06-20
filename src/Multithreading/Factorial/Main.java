package Multithreading.Factorial;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*Factorial t = new Factorial(598019898);
        t.start();*///automatic call the run method
        //putting main thread on sleep
        //Thread.sleep(100);
        //t.join();
        /*t.join(2000);
        if(t.getIsFinished()){
            System.out.println(t.getResult());
        }
        else{
            System.out.println("Calc took too long to finish");
        }
        System.out.println(t.getResult());
        System.out.println("Main is completed");*/

        //Using Multiple Threads at same time
        // Let say we have list of arrays of no whose factorial is to be find
        List<Integer> inputNumbers = new ArrayList<>(Arrays.asList(12345,56789898,9876));
        List<Factorial> factThreads = new ArrayList<>();
        for(long no:inputNumbers){
            Factorial t = new Factorial(no);
            factThreads.add(t);
        }
        for(Thread t1:factThreads){
            t1.start();
            System.out.println(t1.getState());
        }
        // joining with main
        for(Thread t1 : factThreads){
            t1.join(2000);
        }
        for(int i=0; i<inputNumbers.size(); i++){
            Factorial t = factThreads.get(i);
            if(t.getIsFinished()){
                System.out.println(t.getResult());
            }
            else{
                System.out.println("Couldn't complete calc in 2s");
            }
        }
    }
}
