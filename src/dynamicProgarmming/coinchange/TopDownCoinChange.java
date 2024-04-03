package dynamicProgarmming.coinchange;

public class TopDownCoinChange {

    public static void main(String[] args) {
        int[] coins = {0, 1, 4, 6};
        int amount = 8;
        int n = coins.length - 1;
        int[][] memo = new int[n + 1][amount + 1];

        for (int i = 0; i < memo.length; ++i) {
            for (int j = 0; j < memo[0].length; ++j) {
                memo[i][j] = 0;
            }
        }

        int minCoins = topDownCoinChange(coins, n, amount, memo);
        System.out.println("Minimum number of coins required: " + minCoins);
    }

    public static int topDownCoinChange(int[] coins, int n, int m, int[][] memo) {
        if (m == 0) {
            return 0;
        } else if (n == 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[n][m] > 0) {
            return memo[n][m];
        }
        if (coins[n] > m) {
            int p = topDownCoinChange(coins, n - 1, m, memo);
            memo[n][m] = p;
            return p;
        } else {
            int p = topDownCoinChange(coins, n - 1, m, memo);
            int q = topDownCoinChange(coins, n, m - coins[n], memo) + 1;
            if (q > p) {
                memo[n][m] = p;
                return p;
            } else {
                memo[n][m] = q;
                return q;
            }
        }
    }

}