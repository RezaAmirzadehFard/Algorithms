package dynamicProgarmming.optimalbinarysearchtree;

public class TopDownOBST {
    public static void main(String[] args){
        double[] probable = {0, 0.25, 0.35, 0.25, 0.05, 0.10};
        double[][] memo = new double[probable.length][probable.length];
        double obst = topDownOptimalBinarySearchTree(probable, 1,5, memo);
        System.out.println(obst);
    }
    public static double topDownOptimalBinarySearchTree(double[] p, int i, int j, double[][] r){
        if (i == j){
            return p[i];
        } else if (i > j){
            return 0;
        }

        if (r[i][j] > 0){
            return r[i][j];
        }

        double min = Double.MAX_VALUE;
        for (int t = i; t <= j; t++){
            double q = topDownOptimalBinarySearchTree(p, i, t - 1, r) + topDownOptimalBinarySearchTree(p, t + 1, j, r) + sumProbabilities(p,i,j);

            if (q < min){
                min = q;
            }
        }
        r[i][j] = min;
        return min;
    }

    public static double sumProbabilities(double[] p, int s, int e){
        double sum = 0;
        for (int i = s; i <= e; i++){
            sum += p[i];
        }
        return sum;
    }

}
