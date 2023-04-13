package dynamicProgarmming.rodcut;

public class RodCut {
    public int rudCut(int p[], int n) {

        if (n == 0 || n == 1) {
            return p[n];
        }

        int max = -1;
        for (int k = 1; k <= n; k++) {
            int q = p[k] + rudCut(p, n - k);
            if (q > max) {
                max = q;
            }
        }
        return max;
    }
}
