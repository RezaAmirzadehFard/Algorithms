package dynamicProgarmming.knapsack;

public class BottomUpKnapsack {
    static int bottomUpKnapsack(int[] w, int[] v, int kpw, int n, int[][] s) {
        int r[][] = new int[n + 1][kpw + 1];

        for (int i = 1; i < kpw; ++i) {
            for (int j = 1; j <= n; ++j) {
                //r[j,i] = r[n,kpw]
                if (w[j] > i) {
                    r[j][i] = r[j - 1][i];
                } else {
                    int q = r[j - 1][i];
                    int p = r[j - 1][i - w[j]] + v[j];

                    if (q > p) {
                        r[j][i] = q;
                    } else {
                        r[j][i] = p;
                    }
                }
            }
        }
        return r[n][kpw];
    }

    public void printItem(int[][] c, int[] w, int n, int kpw) {
        if (n == 0 || kpw == 0) {
            return;
        }
        System.out.println(c[n][kpw]);

        printItem(c, w, n - c[n][kpw], kpw - w[c[n][kpw]]);
    }
}
