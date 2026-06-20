package Multithreading.CallableDemo;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer> l = List.of(7,3,1,2,4,6,17,12);
        //dynamic  thread pool genrate threads automatically (on demand) when required
        ExecutorService executorService = Executors.newCachedThreadPool();

        Sorter sorter = new Sorter(l,executorService);
        //use of future
        //using future ensures whenever we have output we can store it in future (a kind of box ) meanwhile other
        // task not related to this can keep processing
        Future<List<Integer>> output = executorService.submit(sorter);
       // List<Integer>output = sorter.call();
        System.out.println("Unrealted work `");
        System.out.println(output.get());//Blocking code "whenever we use output.get ie future .get it will wait for the futuure's output to come
        executorService.shutdown();
    }
}
