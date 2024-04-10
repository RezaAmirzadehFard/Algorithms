package dynamicProgarmming.knapsack;

public class Knapsack {
    public static void main(String[] args){
        int[] value = {0,1,2,3};
        int[] weight = {0,4,5,1};
        int number = 3;
        int knapsackWeight = 4;

        int kp = knapsack(value, weight, knapsackWeight ,number);
        System.out.println(kp);
    }
    public static int knapsack(int[] v, int[] w, int kpw, int n) {
        if (kpw == 0 || n == 0) {
            return 0;
        }
        if (w[n] > kpw) {
            return knapsack(v, w, kpw, n - 1);
        } else {
            int p = knapsack(v, w, kpw, n - 1);
            int q = knapsack(v, w, kpw - w[n], n - 1) + v[n];
            if (q > p) {
                return q;
            } else {
                return p;
            }
        }
    }
}
