package dynamicProgarmming.rodcut;

public class TopDownRodCut {
    public static void main(String[] args){
        int[] price = {0,1,5,8,9,10,17,17,20,24,30};

        // function gets the revenue array in argument
        int[] revenue = new int[price.length];

        TopDownRodCut tdRodCut = new TopDownRodCut();
        int r1 = tdRodCut.topDownRudCut(price,8,revenue);
        System.out.println(r1);

        //================================================//


        // function doesn't get the revenue array in argument
        int r2 = TopDownRodCut.memoizedRodCut(price,4);
        //System.out.println(r2);
    }
    // method 1
    public int topDownRudCut(int p[], int n, int r[]) {
        if (n == 0 || n == 1) {
            return p[n];
        }
        if (r[n] > 0) {
            return r[n];
        }
        int max = -1;
        for (int i = 1; i <= n; i++) {
            int q = p[i] + topDownRudCut(p, n - i, r);
            if (q > max) {
                max = q;
            }
        }
        r[n] = max;
        return max;
    }

    // method 2
    // based on CLRS pseudocode
    // Top-Down
    public static int memoizedRodCut(int[] p,int n){
        int[] r = new int[n+1];
        for(int i = 0; i <=n; i++){
            r[i] = Integer.MIN_VALUE;
        }
        return memoizedRodCutAux(p,n,r);
    }

    public static int memoizedRodCutAux(int[] p, int n, int[] r){
        if(n == 0){
            return p[n];
        }
        if (r[n] > 0){
            return r[n];
        }
        int q = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++){
            q = max(q, p[i] + memoizedRodCutAux(p, n - i, r));
        }
        r[n] = q;
        return q;
    }

    public static int max(int n1, int n2){
        if (n1 > n2)
            return n1;
        else
            return n2;
    }
}
