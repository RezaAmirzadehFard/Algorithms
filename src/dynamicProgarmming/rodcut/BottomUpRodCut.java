package dynamicProgarmming.rodcut;

public class BottomUpRodCut {
    public static void main(String[] args){
        BottomUpRodCut buRod = new BottomUpRodCut();
        int[] price = {0,2,2,3,4,5,6,7};
        int r = buRod.bottomUpRodCut(price, 7);
        System.out.println(r);

    }

    // Implementation the rod cut problem with bottom-up approach
    // method 1
    public int bottomUpRodCut(int p[], int n) {
        int r[] = new int[n + 1];
        if (n < 1) {
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


    // based on CLRS pseudocode
    // method 2
    public static int bottomUpRodCut2(int[] p, int n){
        // init an array to store solutions of subproblems
        int[] r = new int[n+1];
        r[0]=0;
        // we use rod with length j, and solve from bottom (rod with less length) to up (rod with length n) with order
        for (int j = 1; j <= n; j++){
            int q = Integer.MIN_VALUE;
            for(int i = 1; i <= j; i++){
                q = max(q, p[i] + r[j-i]);
            }
            // store maximum value of rod with length j to r[j]
            r[j] = q;
        }
        return r[n];
    }

    public static int max(int n1, int n2){
        if (n1 > n2)
            return n1;
        else
            return n2;
    }

    public static int[] extendBottomUpRodCut(int[] p, int n){
        int[] r = new int[n+1];
        int[] s = new int[n+1];
        r[0] = 0;
        for (int j = 1; j <= n; j++){
            int max = Integer.MIN_VALUE;
            for(int i = 1; i <= j; i++){
                int q = p[i] + r[j - i];
                if (q > max){
                    max = q;
                    s[j] = i;
                }
            }
        }
        return s;
    }

    public static void printExtendedBottomUpRodCut(int[] p, int n){
        int[] c = extendBottomUpRodCut(p, n);
        while(n>0){
            System.out.println(c[n]);
            n = n - c[n];
        }

    }
}
