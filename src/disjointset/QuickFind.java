package disjointset;

/***
 * Eager Approach
 * This is first approach
 */

public class QuickFind {
    private int[] id;
    public QuickFind(int N) {
        this.id = new int[N];
    }

    /***
     * Union function
     * Order : O(n)
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pid=id[p];
        int qid=id[q];
        for (int i = 0; i < id.length; i++) {
            if(id[i]==pid) {
                id[i] = qid;
            }
        }

    }

    /***
     * Check connection of two component
     * Order : O(1)
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p,int q) {
        return id[p] == id[q];
    }
}
