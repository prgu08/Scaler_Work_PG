package Multithreading.CallableDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> arr;

    Sorter(List<Integer> arr){
        this.arr =arr; //shallow copy(array in main and this class will point to same address)
    }

    @Override
    public List<Integer> call() throws Exception {
        //Business Logic (Merge Sort)
        //base case
        if(arr.size()<=1){
            return arr;
        }
        //recursive case
        int n = arr.size();
        int mid = n/2;
        List<Integer> leftArr = new ArrayList<>();
        List<Integer> rightArr = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(i<mid){
                leftArr.add(arr.get(i));
            }else{
                rightArr.add(arr.get(i));
            }
        }

        //Recurrsively sort 2 array
        return List.of();
    }
}
