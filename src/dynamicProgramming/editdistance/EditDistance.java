package dynamicProgramming.editdistance;

public class EditDistance {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(recursiveEditDistance(word1, word2, word1.length(), word2.length()));
    }

    public static int recursiveEditDistance(String x, String y, int i, int j) {
        if (i == 0 && j == 0) {
            return 0;
        }
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }

        if (x.charAt(i - 1) == y.charAt(j - 1)) {
            return recursiveEditDistance(x, y, i - 1, j - 1);
        }
        int q = recursiveEditDistance(x, y, i - 1, j) + 1;
        q = Math.min(q, recursiveEditDistance(x, y, i, j - 1) + 1);
        q = Math.min(q, recursiveEditDistance(x, y, i - 1, j - 1) + 1);
        return q;
    }
}
