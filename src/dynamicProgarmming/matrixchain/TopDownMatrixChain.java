package dynamicProgarmming.matrixchain;

public class TopDownMatrixChain {
    public static void main(String[] args) {
        TopDownMatrixChain tdMatrixChain = new TopDownMatrixChain();
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        int[][] memo = new int[p.length][p.length];
        int m = tdMatrixChain.topDownMatrixProduct(p, 1, 6, memo);
        System.out.println(m);
    }

    //  Top to Down (memoization)
    public int topDownMatrixProduct(int[] p, int i, int j, int[][] m) {
        if (i >= j) {
            return 0;
        }
        // this if -> check if we calculate cost of a sequence of Aij in past return the cost
        if (m[i][j] > 0) {
            return m[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int q = topDownMatrixProduct(p, i, k, m) + topDownMatrixProduct(p, k + 1, j, m) + (p[i - 1] * p[k] * p[j]);
            if (q < min) {
                min = q;
            }
        }
        m[i][j] = min;
        return min;
    }
}
