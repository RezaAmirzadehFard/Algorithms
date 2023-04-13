package dynamicProgarmming.matrixchain;

public class BottomUpMatrixChain {
    public int bottomUpMatrixChain(int p[], int s[][]) {
        int n = p.length;
        int r[][] = new int[n - 1][n - 1];

        for (int l = 1; l <= n - 1; l++) {        // length of sequence
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
}