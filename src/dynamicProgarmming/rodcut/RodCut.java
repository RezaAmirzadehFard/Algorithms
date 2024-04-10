package dynamicProgarmming.rodcut;

public class RodCut {

    public static void main(String[] args) {
        int[] price = {0,2,2,3,4,5,6,7};
        RodCut rod = new RodCut();
        int r = rod.rodCut(price, 7);
        System.out.println(r);
    }

    // Implementation of the rod cut problem with recursive approach
    public int rodCut(int p[], int n) {
        if (n == 0 || n == 1) {
            return p[n];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int q = p[i] + rodCut(p, n - i);
            if (q > max) {
                max = q;
            }
        }
        return max;
    }
}
