package amortizedAnalysis.binarycounter;

import java.util.Arrays;
import java.util.Scanner;

public class IncrementBinaryCounter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose one option:");
        System.out.println("1. Have Binary number for binary incrementing.");
        System.out.println("2. Have Decimal number for binary incrementing.");
        System.out.println("Enter your option number:");
        int option = sc.nextInt();
        switch(option){
            case 1: {
                System.out.println("Enter the number of bit in your binary number:");
                int numBit = sc.nextInt();
                int[] arr = new int[numBit];
                System.out.println("Enter your initial bit of number for counting : (split bit with whitespace)");
                for(int i=0; i<numBit; i++) {
                    arr[i] = sc.nextInt();
                }

                System.out.println("Enter number of increment operation:");
                int numInc = sc.nextInt();
                for (int i = 0; i < numInc ; i++){
                    System.out.println(Arrays.toString(arr));
                    increment1(arr);
                }
                break;
            }
            case 2: {
                System.out.println("Enter your Decimal Number:");

                break;
            }
            default: System.out.println("Please choose correct option.");
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
