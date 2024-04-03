package dynamicProgarmming.fibonacci;

import java.util.Scanner;

public class TopDownFibonacci {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of terms in the Fibonacci sequence: ");
        int n = input.nextInt();

        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacciTopDown(i, memo) + " ");
        }

    }
    // We can write top-down fibonacci function in two ways.
    // Method 1
    public static int fibonacciTopDown(int n, int[] memo) {
        if(n==0 || n == 1)
            return n;

        if (memo[n] > 0) {
            return memo[n];
        }

        int q = fibonacciTopDown(n - 1, memo) + fibonacciTopDown(n - 2, memo);
        memo[n] = q;

        return q;
    }

    // method 2
    public static int memoizedFibonacci(int n){
        int[] r = new int[n+1];
        for (int i = 0; i <=n; i++){
            r[i] = 0;
        }
        return memoizedFibonacciAux(n, r);
    }

    public static int memoizedFibonacciAux(int n, int[] r){
        if (n == 0 || n == 1){
            return n;
        }
        int q;
        if (r[n] > 0){
            return r[n];
        }else {
            q = memoizedFibonacciAux(n - 1, r) + memoizedFibonacciAux(n - 2, r);
            r[n] = q;
        }
        return q;
    }

}