package dynamicProgarmming.knapsack;

public class Knapsack {
    public int knapsack(int[] v, int[] w, int kpw, int n) {
        if (kpw == 0 || n == 0) {
            return 0;
        }
        if (w[n] > kpw) {
            return knapsack(v, w, kpw, n - 1);
        } else {
            int p = knapsack(v, w, kpw, n - 1);
            int q = knapsack(v, w, kpw - w[n], n - 1) + v[n];
            if (q > p) {
                return q;
            } else {
                return p;
            }
        }
    }

    public void printItem(int[][] c, int[] w, int n, int kpw) {
        if (n == 0 || kpw == 0) {
            return;
        }
        System.out.println(c[n][kpw]);

        printItem(c, w, n - c[n][kpw], kpw - w[c[n][kpw]]);
    }
}
