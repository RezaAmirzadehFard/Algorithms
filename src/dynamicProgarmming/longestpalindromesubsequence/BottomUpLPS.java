package dynamicProgarmming.longestpalindromesubsequence;

public class BottomUpLPS {
    public static void main(String[] args) {
        char[] x = {'D','A','B','C','B','D','A','B','C'};
        //char[] y = {'B','D','C','A','B','A'};

        int lcs = bottomUpLongestPalindromeSubsequence(x);
        System.out.println(lcs);
    }

    // method 1
    public static int bottomUpLongestPalindromeSubsequence(char[] x){
        int n = x.length;
        int[][] c = new int[n][n];

        for (int i = 0; i < n; i++) {
            c[i][i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i+1; j < n-i; j++) {
                if (i > j)
                    c[i][j] = 0;
                else if (x[i] == x[j])
                    c[i][j] = c[i + 1][j - 1] + 2;
                else
                    c[i][j] = Math.max(c[i + 1][j], c[i][j - 1]);
            }
        }
        return c[0][n-1];
    }

    // method 2
    public static int bottomUpLongestPalindromeSubsequence2(char[] x){
        int n = x.length;
        int[][] c = new int[n][n];

        for (int i = 0; i < n; i++) {
            c[i][i] = 1;
        }

        for (int l = 1; l < n; l ++) {
            for (int i = 0; i < n-l; i++) {
                int j = i + l;
                if (i > j)
                    c[i][j] = 0;
                else if (x[i] == x[j])
                    c[i][j] = c[i + 1][j - 1] + 2;
                else
                    c[i][j] = Math.max(c[i + 1][j], c[i][j - 1]);
            }
        }
        return c[0][n-1];
    }
}
