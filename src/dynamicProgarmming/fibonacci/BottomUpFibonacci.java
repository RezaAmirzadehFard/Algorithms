package dynamicProgarmming.fibonacci;

import java.util.Scanner;

public class BottomUpFibonacci {
    // Bottom-up
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of terms in the Fibonacci sequence: ");
        int n = input.nextInt();

        int[] memo = new int[n+1];
        memo[1] = 1;
        memo[2] = 1;

        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(memo[i] + " ");
        }
    }
}
