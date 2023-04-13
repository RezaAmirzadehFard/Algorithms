package dynamicProgarmming.fibonacci;

import java.util.Scanner;

public class Fibonacci {
    // normal
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of terms in the Fibonacci sequence: ");
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        System.out.println("\nThe value of " + n + " in fibonacci manner is : " + fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
