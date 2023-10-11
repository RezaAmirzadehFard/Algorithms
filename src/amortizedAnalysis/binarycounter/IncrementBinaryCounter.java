package amortizedAnalysis.binarycounter;

public class IncrementBinaryCounter {
    public static void main(String[] args){


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
}
