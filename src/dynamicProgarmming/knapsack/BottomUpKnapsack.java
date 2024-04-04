package dynamicProgarmming.knapsack;

public class BottomUpKnapsack {

    public static void main(String[] args) {
        int[] value = {0, 1, 2, 3};
        int[] weight = {0, 4, 5, 1};
        int number = 3;
        int knapsackWeight = 4;

        int kp = bottomUpKnapsack(weight, value, knapsackWeight, number);
        System.out.println(kp);
    }

    public static int bottomUpKnapsack(int[] w, int[] v, int kpw, int n) {
        int[][] r = new int[n + 1][kpw + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= kpw; ++j) {
                //r[i,j] = r[n,kpw]
                if (w[i] > j) {
                    r[i][j] = r[i - 1][j];
                } else {
                    int q = r[i - 1][j];
                    int p = r[i - 1][j - w[i]] + v[i];
                    if (q > p) {
                        r[i][j] = q;
                    } else {
                        r[i][j] = p;
                    }
                }
            }
        }
        return r[n][kpw];
    }

}
