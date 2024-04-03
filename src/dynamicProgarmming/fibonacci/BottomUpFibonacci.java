package dynamicProgarmming.fibonacci;

import java.util.Scanner;

public class BottomUpFibonacci {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of terms in the Fibonacci sequence: ");
        int n = input.nextInt();
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 1;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        for (int i = 0; i <= n; i++) {
            System.out.print(memo[i] + " ");
        }
    }

    public static int bottomUpFibonacci(int n){
        int[] r = new int[n+1];
        r[0] = 0;
        r[1] = 1;
        int q = -1;
        for (int i = 2; i <= n; i++) {
            q = r[i-1] + r[i-2];
            r[i] = q;
        }
        return q;
    }
}