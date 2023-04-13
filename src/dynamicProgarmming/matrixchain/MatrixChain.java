package dynamicProgarmming.matrixchain;

public class MatrixChain {
    // simple recursive form
    public int matrixProduct(int[] p, int i, int j) {
        if (i == j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int q = matrixProduct(p, i, k) + matrixProduct(p, k + 1, j) + (p[i - 1] * p[k] * p[j]);

            if (q < min) {
                min = q;
            }

        }

        return min;
    }

    public static void main(String[] args) {

        int p[] = {2, 3, 5, 3, 9, 7};

        MatrixChain m = new MatrixChain();

        int result = m.matrixProduct(p, 1, 5);


    }
}
