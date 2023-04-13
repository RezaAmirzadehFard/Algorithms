package dynamicProgarmming.coinchange;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        // Base case: no coins needed to make change for 0
        if (amount == 0) {
            return 0;
        }

        // Initialize minimum number of coins required to be the maximum possible value
        int minCoins = Integer.MAX_VALUE;

        // Try using each coin denomination to make change for amount
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                // Recursive call to find minimum number of coins required to make change for amount - coins[i]
                int numCoins = coinChange(coins, amount - coins[i]);

                // Update minimum number of coins required if numCoins is smaller
                if (numCoins != Integer.MAX_VALUE && numCoins + 1 < minCoins) {
                    minCoins = numCoins + 1;
                }
            }
        }

        // Return the minimum number of coins required
        return minCoins;
    }

    // coinChange
    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25}; // Example set of coin denominations
        int amount = 27; // Example amount to make change for

        int minCoins = coinChange(coins, amount);
        System.out.println("Minimum number of coins required: " + minCoins);
    }


}
