package dynamicProgarmming.rodcut;

public class RodCut {
    // Implementation of the rod cut problem with recursive approach
    public int rudCut(int p[], int n) {
        if (n == 0 || n == 1) {
            return p[n];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int q = p[i] + rudCut(p, n - i);
            if (q > max) {
                max = q;
            }
        }
        return max;
    }
}
