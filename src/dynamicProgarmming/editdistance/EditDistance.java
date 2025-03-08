package dynamicProgramming.editdistance;
import java.util.Arrays;
// Leet code problem : https://leetcode.com/problems/edit-distance/
public class EditDistance {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        int mem[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < mem.length; i++) {
            Arrays.fill(mem[i], -1);
        }
        System.out.println(topDownEditDist(word1, word2, word1.length(), word2.length(), mem));
    }

    public static int topDownEditDist(String x, String y, int i, int j, int mem[][]) {
        if (i == 0 && j == 0) {
            return 0;
        }
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        if (mem[i][j] > -1) {
            return mem[i][j];
        }
        if (x.charAt(i - 1) == y.charAt(j - 1)) {
            return topDownEditDist(x, y, i - 1, j - 1, mem);
        }
        int q = topDownEditDist(x, y, i - 1, j, mem) + 1;
        q = Math.min(q, topDownEditDist(x, y, i, j - 1, mem) + 1);
        q = Math.min(q, topDownEditDist(x, y, i - 1, j - 1, mem) + 1);
        mem[i][j] = q;
        return q;
    }
}
