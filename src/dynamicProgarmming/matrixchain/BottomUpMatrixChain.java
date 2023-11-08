package dynamicProgarmming.matrixchain;

public class BottomUpMatrixChain {
    public static void main(String[] args){
    }
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
        int n = p.length - 1;       // because p have indices of 0,1,...,n-1,n => length of p is n+1
        int[][] m = new int[n][n];
        int[][] s = new int[n][n];

        for (int i = 0; i < n; i++) { // the minimum cost for sequences with size of one
            m[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) { // is the chain length
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= n - l + 1; i++) { // loop from range i to j (n-l+1)
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