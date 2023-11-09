package dynamicProgarmming.coinchange;

public class CoinChange {
    public static int coinChange(int[] coins,int n, int m) {
        // Base case: no coins needed to make change for 0
        if (m == 0) {
            return 0;
        } else if (n == 0) {
            return Integer.MAX_VALUE;
        }

        if (coins[n] > m) {
            return coinChange(coins,n-1,m);
        }else {
            int p = coinChange(coins, n - 1, m);
            int q = coinChange(coins, n, m - coins[n]) + 1;
            if (q > p) {
                return p;
            } else {
                return q;
            }
        }
    }

    // coinChange
    public static void main(String[] args) {
        int[] coins = {0, 1, 4, 6}; // Example set of coin denominations
        int m = 8; // Example amount to make change for
        int n = coins.length - 1;
        int minCoins = coinChange(coins,n, m);
        System.out.println("Minimum number of coins required: " + minCoins);
    }
}
