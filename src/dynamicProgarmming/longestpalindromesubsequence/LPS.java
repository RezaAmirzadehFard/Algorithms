package dynamicProgarmming.longestpalindromesubsequence;

public class LPS {
    public static int longestPalindromeSubsequence(char[] x, int i, int j, boolean[] data) {
        if ((i == 0 || j == 0) && (i > j)) {
            return 0;
        }
        if (i == j){
            data[i - 1] = true;
            return 1;
        }
        if (x[i-1] == x[j-1]) {
            data[i-1] = data[j-1] = true;
            return longestPalindromeSubsequence(x, i+1, j-1, data) + 2;
        } else {
            boolean[] temp1 = data.clone();
            boolean[] temp2 = data.clone();
            int p = longestPalindromeSubsequence(x,i,j-1, temp1);
            int q = longestPalindromeSubsequence(x,i+1,j, temp2);
            for (int k = 0; k < data.length; k++) {
                data[k] = p > q ? temp1[k] : temp2[k];
            }
            return Math.max(p,q);
        }
    }

    public static void main(String[] args) {
        char[] msg = "carpacpr".toCharArray();
        boolean[] data = new boolean[msg.length];
        System.out.println(longestPalindromeSubsequence(msg, 1, msg.length, data));
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (data[i]) res.append(msg[i]);
        }

        System.out.println(res);
    }
}
