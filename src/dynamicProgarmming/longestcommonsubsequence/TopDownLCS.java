package dynamicProgarmming.longestcommonsubsequence;

public class TopDownLCS {

    public static int topDownLongestCommonSubsequence(char[] x, char[] y, int m, int n, int[][] r){
        if (m == 0 || n == 0){
            return 0;
        }
        if (r[m][n] > 0){
            return r[m][n];
        }
        if (x[m-1] == y[n -1]){
            int p = topDownLongestCommonSubsequence(x,y,m-1,n-1,r) + 1;
            r[m][n] = p;
            return p;
        }else{
            int p = topDownLongestCommonSubsequence(x,y,m,n-1,r);
            int q = topDownLongestCommonSubsequence(x,y,m -1,n,r);
            int max = Math.max(p,q);
            r[m][n] = max;
            return max;
        }
    }
}
