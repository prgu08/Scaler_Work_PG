package Multithreading.Factorial;

import java.math.BigInteger;

public class Factorial extends Thread{
    private long number;
    private BigInteger result;
    boolean isFinished;
    Factorial(long number){
        this.number = number;
        result = BigInteger.valueOf(0); // or BigInteger.ZERO;
        isFinished = false;

    }
    @Override
    public void run(){
        result = factorial(number);
        isFinished = true;
    }

    BigInteger factorial(long n){
        BigInteger ans = BigInteger.ONE;
        for(long i=2; i<=n; i++){
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }
    public BigInteger getResult(){
        return result;
    }
    public boolean getIsFinished(){
        return isFinished;
    }
}
