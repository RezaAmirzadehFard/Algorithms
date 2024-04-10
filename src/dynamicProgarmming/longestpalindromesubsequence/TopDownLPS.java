package dynamicProgarmming.longestpalindromesubsequence;

public class TopDownLPS {
    public static void main(String[] args) {
        char[] x = {'c', 'a', 'r', 'p', 'a', 'c', 'p', 'r'};
        int[][] memo = new int[x.length][x.length];
        int lcs = topDownLongestPalindromeSubsequence(x, 0, 7, memo);
        System.out.println(lcs);
    }

    public static int topDownLongestPalindromeSubsequence(char[] x, int i, int j, int[][] r) {
        if ((i == 0 || j == 0) && (i > j)) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (r[i][j] > 0) {
            return r[i][j];
        }
        if (x[i] == x[j]) {
            int p = topDownLongestPalindromeSubsequence(x, i + 1, j - 1, r) + 2;
            r[i][j] = p;
            return p;
        } else {
            int p = topDownLongestPalindromeSubsequence(x, i, j - 1, r);
            int q = topDownLongestPalindromeSubsequence(x, i + 1, j, r);
            int max = Math.max(p, q);
            r[i][j] = max;
            return max;
        }
    }
}
