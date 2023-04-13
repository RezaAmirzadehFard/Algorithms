package amortizedAnalysis;

import java.util.Arrays;
import java.util.Scanner;

public class IncrementCounter {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of bit in your binary number:");
        int size = sc.nextInt();            // number of time you need to increment
        int[] arr = new int[size];
        System.out.println("Enter the elements of the binary counter :");

        for(int i=0; i<size; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < size ; i++){
            System.out.println(Arrays.toString(arr));
            increment(arr);
        }

    }
    public static void increment(int a[]){
        int k = a.length;

        for ( int i = k - 1; i >= 0; --i){
            if ( a[i] == 1){
                a[i] = 0;
            }else {
                a[i] = 1;
                return ;
            }
        }
    }
}
