package dynamicProgarmming.longestcommonsubsequence;

public class BottomUpLCS {
    public static void main(String[] args){
        char[] x = {'A','B','C','B','D','A','B'};
        char[] y = {'B','D','C','A','B','A'};
        int lcs = bottomUpLongestCommonSubsequence(x,y,5,6);
        System.out.println(lcs);
    }
    public static int bottomUpLongestCommonSubsequence(char[] x, char[] y, int m, int n){
        int[][] c = new int[m+1][n+1];

        for(int i = 0; i <= m; i++){
            c[i][0] = 0;
        }

        for(int j = 0; j <= n; j++){
            c[0][j] = 0;
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    c[i][j] = 0;
                else if (x[i - 1] == y[j - 1])
                    c[i][j] = c[i - 1][j - 1] + 1;
                else
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
            }
        }
        return c[m][n];
    }
}
