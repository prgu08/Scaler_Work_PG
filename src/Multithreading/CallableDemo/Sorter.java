package Multithreading.CallableDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> arr;
    ExecutorService executorService;

    Sorter(List<Integer> arr, ExecutorService executorService) {
        this.arr = arr;
        this.executorService =executorService;//shallow copy(array in main and this class will point to same address)
    }

    @Override
    public List<Integer> call() throws Exception {
        //Business Logic (Merge Sort)
        //base case
        if (arr.size() <= 1) {
            return arr;
        }
        //recursive case
        int n = arr.size();
        int mid = n / 2;
        List<Integer> leftArr = new ArrayList<>();
        List<Integer> rightArr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i < mid) {
                leftArr.add(arr.get(i));
            } else {
                rightArr.add(arr.get(i));
            }
        }

        //Recurrsively sort 2 array
        Sorter leftSorter = new Sorter(leftArr, executorService);
        Sorter rightSorter = new Sorter(rightArr, executorService);

        Future<List<Integer>> leftFuture = executorService.submit(leftSorter);
        Future<List<Integer>> rightFuture = executorService.submit(rightSorter);
        leftArr = leftFuture.get();
        rightArr = rightFuture.get();

        //Merge the two sorted arrays
        List<Integer> output = new ArrayList<>();
        int j=0; int i =0;
        while(i<leftArr.size() && j<rightArr.size()){
            if(leftArr.get(i)<rightArr.get(j)){
                output.add(leftArr.get(i));
                i++;
            }else{
                output.add(rightArr.get(j));
                j++;
            }
        }
        //copy the remaining left
        while(i<leftArr.size()){
            output.add(leftArr.get(i));
            i++;
        }
        //copy the remaining right
        while(j<rightArr.size()){
            output.add(rightArr.get(j));
            j++;
        }


        return output;
    }
}
