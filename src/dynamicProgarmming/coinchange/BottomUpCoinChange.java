package dynamicProgarmming.coinchange;

public class BottomUpCoinChange {
    public static void main(String[] args){
        int[] coins = {0, 1, 4, 6};
        int m = 8;
        int number = coins.length - 1;
        int minCoins = bottomUpCoinChange(coins, number, m);
        System.out.println(minCoins);
    }

    public static int bottomUpCoinChange(int[] coins, int n, int m) {
        int[][] r = new int[n + 1][m + 1];

        for (int j = 1; j <= m; j++) {

            for (int i = 1; i <= n; i++) {
                //r[i,j] => r[n,m]
                r[0][j] = Integer.MAX_VALUE;
                r[i][0] = 0;
                if (coins[i] > j) {
                    r[i][j] = r[i - 1][j];
                } else {
                    int q = r[i-1][j];
                    int p = r[i][j - coins[i]] + 1;
                    if (q > p) {
                        r[i][j] = p;
                    } else {
                        r[i][j] = q;
                    }
                }
            }
        }
        return r[n][m];
    }
}
