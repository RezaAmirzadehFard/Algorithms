package dynamicProgarmming.fibonacci;

import java.util.Scanner;

public class TopDownFibonacci {
    // Top Down
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of terms in the Fibonacci sequence: ");
        int n = input.nextInt();

        int[] memo = new int[n+1];
        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacciTopDown(i, memo) + " ");
        }
    }

    public static int fibonacciTopDown(int n, int[] memo) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibonacciTopDown(n-1, memo) + fibonacciTopDown(n-2, memo);
        return memo[n];
    }
}
