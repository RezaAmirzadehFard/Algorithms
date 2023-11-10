package dynamicProgarmming.coinchange;

public class BottomUpCoinChange {
    static int bottomUpCoinChange(int[] coins, int n, int m) {
        int r[][] = new int[n + 1][m + 1];

        for (int j = 1; j < m; ++j) {
            for (int i = 1; i <= n; ++i) {
                //r[i,j] = r[n,m]
                r[0][j] = Integer.MAX_VALUE;
                if (coins[n] > j) {
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
