package amortizedAnalysis.binarycounter;

public class IncrementBinaryCounter {
    public static void main(String[] args){

        // example for increment1 function
        int[] arr1 = new int[4];
        System.out.print("Input Number:    ");
        for (int e:
                arr1) {
            System.out.print(" "+ e);
        }
        increment1(arr1);
        System.out.println("\n================");
        System.out.print("First increment: ");
        for (int e:
                arr1) {
            System.out.print(" "+ e);
        }
        increment1(arr1);
        System.out.print("\n================\n");
        System.out.print("Second increment:");
        for (int e:
                arr1) {
            System.out.print(" "+ e);
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
