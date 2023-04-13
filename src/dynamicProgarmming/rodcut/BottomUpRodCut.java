package dynamicProgarmming.rodcut;

public class BottomUpRodCut {
    public int bottomUpRodCut(int p[], int n) {
        int r[] = new int[n + 1];

        if (n <= 1) {
            r[n] = p[n];
        }

        for (int l = 2; l <= n; l++) {
            int max = -1;
            for (int k = 1; k <= l; k++) {
                int q = p[k] + r[l - k];
                if (q > max) {
                    max = q;
                }
            }
            r[l] = max;
        }
        return r[n];
    }
}
