package dynamicProgarmming.knapsack;

public class TopDownKnapsack {

    public int topDownKnapsack(int[] v, int[] w, int kpw, int n, int[][] r) {
        if (kpw == 0 || n == 0) {
            return 0;
        }
        if (r[n][kpw] > 0) {
            return r[n][kpw];
        }
        if (w[n] > kpw) {
            int p = topDownKnapsack(v, w, kpw, n - 1, r);
            r[n][kpw] = p;
            return p;
        } else {
            int p = topDownKnapsack(v, w, kpw, n - 1, r);
            int q = topDownKnapsack(v, w, kpw - w[n], n - 1, r) + v[n];
            if (q > p) {
                r[n][kpw] = q;
                return q;
            } else {
                r[n][kpw] = p;
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

    public static void main(String[] args) {
        int v[] = {0, 1, 4, 6, 8, 9, 11};
        int w[] = {0, 3, 5, 3, 7, 11, 2};
        int kpw = 20;
        int b[][] = new int[7][kpw + 1];

        for (int i = 0; i < b.length; ++i) {
            for (int j = 0; j < b[0].length; ++j) {
                b[i][j] = 0;
            }
        }

        TopDownKnapsack kp = new TopDownKnapsack();
        int result = kp.topDownKnapsack(v, w, kpw, 6, b);

        System.out.println(result);

    }
}
