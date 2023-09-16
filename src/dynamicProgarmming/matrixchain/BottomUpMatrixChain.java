package dynamicProgarmming.matrixchain;

public class BottomUpMatrixChain {
    public int bottomUpMatrixChain(int p[], int s[][]) {
        int n = p.length;
        int r[][] = new int[n - 1][n - 1];

        for (int l = 1; l <= n - 1; l++) {        // length of the sequence
            for (int i = 1; i <= n - l; i++) {    // start of multiply
                int j = i + l;                 // end of multiply
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j - 1; k++) {  // last multiply
                    int q = r[i][k] + r[k + 1][j] + p[i - 1] * p[k] * p[j];

                    if (q < min) {
                        min = q;
                        s[i][j] = k;
                    }
                }
                r[i][j] = min;
            }
        }
        return r[1][n - 1];
    }


    public static int[][] matrixChainOrder(int[] p) {
        int n = p.length - 1;
        int[][] m = new int[n][n];
        int[][] s = new int[n][n];

        for (int i = 0; i < n; i++) {
            m[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= l + i - 1; i++) {
                int j = l + i - 1;
                for (int k = i; k <= j; k++) {
                    int q = m[i][k] + m[k][j] + p[i - 1] * p[k] * p[j];
                    if (q < min){
                        min = q;
                        s[i][j] = k;
                    }
                }
                m[i][j] = min;
            }
        }
        return m;
    }
}