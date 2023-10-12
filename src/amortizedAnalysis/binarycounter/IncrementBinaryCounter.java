package amortizedAnalysis.binarycounter;

import java.util.Arrays;
import java.util.Scanner;

public class IncrementBinaryCounter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of bit in your binary number:");
        int numBit = sc.nextInt();

        // example for increment1 function
        int[] arr = new int[numBit];
        System.out.println("Enter your initial bit of number for counting :");

        for(int i=0; i<numBit; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter number of increment operation:");
        int numInc = sc.nextInt();
        for (int i = 0; i < numInc ; i++){
            System.out.println(Arrays.toString(arr));
            increment1(arr);
        }

        }

    // This increment function implementing with while loop
    // in this function input parameter msb is a[0] and a[a.length - 1] is lsb
    // msb: Most significant bit, lsb: least significant bit
    public static void increment1(int[] a){
        int i = a.length - 1;
        while ( i >= 0  && a[i] == 1){
            a[i] = 0;
            i--;
        }
        if( i >= 0)
            a[i] = 1;
    }


    // This increment function implementing with for loop
    public static void increment2(int[] a){
        int k = a.length;
        for( int i = k - 1; i >= 0; i--){
            if(a[i] == 1){
                a[i] = 0;
            }else{
                a[i] = 1;
                return;
            }
        }
    }
}
