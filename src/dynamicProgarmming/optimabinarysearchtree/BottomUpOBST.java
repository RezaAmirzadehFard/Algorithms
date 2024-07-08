package dynamicProgarmming.optimabinarysearchtree;

public class BottomUpOBST {
    public static void main(String[] args){
        double[] probable = {0, 0.25, 0.35, 0.25, 0.05, 0.10};
        double[][] obst = bottomUpOptimalBinarySearchTree(probable);

        for (int i = 1; i < obst.length - 1; i++) {
            for (int j = 1; j < obst[0].length; j++) {
                    System.out.printf("%.2f\t", obst[i][j]);
            }
            System.out.println();
        }

        System.out.println("Minimum Cost: " + obst[1][probable.length - 1]);
    }
    public static double[][] bottomUpOptimalBinarySearchTree(double[] p){
        int n = p.length - 1;
        double[][] r = new double[n + 2][n + 1];

        for (int i = 0; i <= n; i++) {
            r[i][i] = p[i];
        }

        for (int l = 2; l <= n; l++){
            double min = Double.MAX_VALUE;
            for (int i = 1; i <= n - l + 1; i ++){
                int j = i + l - 1;
                for (int t = i; t <= j; t++){
                    double q = r[i][t - 1] + r[t + 1][j] + sumProbabilities(p, i, j);
                    if (q < min){
                        min = q;
                    }
                }
                r[i][j] = min;
            }
        }
//        return r[1][n];
        return r;
    }

    public static double sumProbabilities(double[] p, int s, int e){
        double sum = 0;
        for (int i = s; i <= e; i++){
            sum += p[i];
        }
        return sum;
    }
}
