package dynamicProgramming.coinchange;
import java.util.Arrays;

public class TopDownOneDCoinChange {
    public static void main(String[] args) {
        int coins[] = {1,2,3,4};
        int price = 800;
        long mem[] = new long[price+1]; 
        Arrays.fill(mem,-1);
        System.out.println( oneDCoinChange(coins,price,mem));

    }
// Using 1d array instead of 2d to reduce space complexity
    private static long oneDCoinChange(int[] coins, int price, long[] mem) {
        if(price==0){
            return 0;
        }
        if(price<0){
            return Integer.MAX_VALUE;
        }
        if(mem[price]>-1){
            return mem[price];
        }
        long q= Integer.MAX_VALUE;
        for (int c:coins) {
            q=Math.min(q,oneDCoinChange(coins,price-c,mem)+1);

        }
        mem[price]=q;
        return mem[price];
    }
}
