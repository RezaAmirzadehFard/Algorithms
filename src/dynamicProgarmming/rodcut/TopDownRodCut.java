package dynamicProgarmming.rodcut;

public class TopDownRodCut {
    public int topDownRudCut(int p[], int n, int r[]) {
        if (n == 0 || n == 1) {
            return p[n];
        }
        if (r[n] > 0) {
            return r[n];
        }

        int max = -1;
        for (int k = 1; k <= n; k++) {
            int q = p[k] + topDownRudCut(p, n - k, r);
            if (q > max) {
                max = q;
            }
        }
        r[n] = max;
        return max;
    }
}
