package amortizedAnalysis;

import java.util.Arrays;

public class DecrementCounter {

    public static void main(String[] args) {

        int[] binary = {1, 0, 0, 1}; // initialize the binary array to 1001
        System.out.println(Arrays.toString(binary)); // prints [1, 0, 0, 1]
        decrement(binary); // decrements the binary array
        System.out.println(Arrays.toString(binary)); // prints [1, 0, 0, 0]
        decrement(binary);
        System.out.println(Arrays.toString(binary)); // prints [0, 1, 1, 1]
        decrement(binary);
        System.out.println(Arrays.toString(binary)); // prints [0, 1, 1, 0]
        decrement(binary);
        System.out.println(Arrays.toString(binary)); // prints [0, 1, 0, 1]
        // and so on...
    }
    public static void decrement(int[] a) {
        int k = a.length;

        for (int i = k - 1; i >= 0; --i) {
            if (a[i] == 0) {
                a[i] = 1;
                return;
            } else {
                a[i] = 0;
            }
        }
    }
}
