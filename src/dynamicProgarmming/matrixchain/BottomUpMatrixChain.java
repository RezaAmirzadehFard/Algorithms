package dynamicProgarmming.matrixchain;

public class BottomUpMatrixChain {
    public static void main(String[] args) {
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        int[][] save = new int[p.length][p.length];
        BottomUpMatrixChain buMatrix = new BottomUpMatrixChain();
        int[][] m = matrixChainOrder(p);


        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if (m[i][j] > 0)
                    System.out.printf("%d \t", m[i][j]);
                else
                    System.out.printf("%d\t\t", m[i][j]);
            }
            System.out.println();
        }

        System.out.println("Minimum Cost: " + m[1][p.length - 1]);
    }

    public int bottomUpMatrixChain(int p[], int s[][]) {
        int n = p.length;
        int r[][] = new int[n][n];

        for (int i = 0; i < n; i++) { // the minimum cost for sequences with size of one
            r[i][i] = 0;
        }

        for (int l = 2; l <= n - 1; l++) {        // length of the sequence
            for (int i = 1; i <= n - l; i++) {    // start of multiply
                int j = i + l - 1;                 // end of multiply
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {  // last multiply
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
        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) { // the minimum cost for sequences with size of one
            m[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) { // is the chain length
            for (int i = 1; i <= n - l + 1; i++) { // [1]*
                int j = l + i - 1;
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) { // find best k for range between i, j (k: is the last position that multiply occurs between two matrices
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < min) {
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

// [1]: in this loop we examine the range for 'i', when we have a sequence with length 'l' and start index of a sequence is 'i' for i = 1,2,3,4,...,n-l we can choose i.
// if l = 3, m[i ,i+3] for i = 1,2,3,4,...,n-3
// for example if we have a matrix chain like <A1,A2,A3,A4,A5,A6,A7>
// n=7 and l = 2, the last i we can use is 7-2+1 = 6
// i = 1, j = l+i-1 = 2+1-1 = 2  => A1*A2
// i = 2, j = l+i-1 = 2+2-1 = 3  => A2*A3
// i = 3, j = l+i-1 = 2+3-1 = 4  => A3*A4
// i = 4, j = l+i-1 = 2+4-1 = 5  => A4*A5
// i = 5, j = l+i-1 = 2+5-1 = 6  => A5*A6
// i = 6, j = l+i-1 = 2+6-1 = 5  => A6*A7