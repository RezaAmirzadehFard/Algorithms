package dynamicProgarmming.coinchange;

public class TopDownCoinChange {
    public static int coinChange(int[] coins,int n, int m, int[][] memo) {
        // Base case: no coins needed to make change for 0
        if (m == 0) {
            return 0;
        } else if (n == 0) {
            return Integer.MAX_VALUE;
        }


        if (memo[n][m] > 0) {
            return memo[n][m];
        }
        if (coins[n] > m) {
            int p = coinChange(coins, n - 1, m, memo);
            memo[n][m] = p;
            return p;
        } else {
            int p = coinChange(coins, n - 1, m, memo);
            int q = coinChange(coins, n, m-coins[n], memo) + 1;
            if (q > p) {
                memo[n][m] = p;
                return p;
            } else {
                memo[n][m] = q;
                return q;
            }
        }
    }


    // Top-Down coin change
    public static void main(String[] args) {
        int[] coins = {0, 1, 5, 10, 25}; // Example set of coin denominations
        int amount = 27; // Example amount to make change for
        int n = coins.length - 1;
        int[][] memo = new int[n+1][n+1]; // Memoization table


        for (int i = 0; i < memo.length; ++i) {
            for (int j = 0; j < memo[0].length; ++j) {
                memo[i][j] = 0;
            }
        }

        int minCoins = coinChange(coins,n, amount, memo);
        System.out.println("Minimum number of coins required: " + minCoins);
    }
}
