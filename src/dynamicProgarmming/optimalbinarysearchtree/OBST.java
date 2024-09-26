package dynamicProgarmming.optimalbinarysearchtree;

public class OBST {
    public static void main(String[] args){
        double[] probable = {0, 0.25, 0.35, 0.25, 0.05, 0.10};
        double obst = optimaBinarySearchTree(probable, 1,5);
        System.out.println(obst);
    }

    public static double optimaBinarySearchTree(double[] p, int i, int j){
        if (i == j) {
            return p[i];
        } else if (i > j) {
            return 0;
        }

        double min = Double.MAX_VALUE;
        for (int t = i; t <= j; t++) {
            double q = optimaBinarySearchTree(p, i, t-1) + optimaBinarySearchTree(p, t + 1, j) + sumProbabilities(p,i,j);
            if (q < min) {
                min = q;
            }
        }
        return min;
    }

    public static double sumProbabilities(double[] p, int s, int e){
        double sum = 0;
        for (int i = s; i <= e; i++) {
            sum = sum + p[i];
        }
        return sum;
    }
}
