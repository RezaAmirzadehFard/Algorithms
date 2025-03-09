package disjointset;

/***
 * Lazy Approach
 * This is second approach
 */
public class QuickUnion {

    private int[] id;
    public QuickUnion(int n) {
        id = new int[n];
    }


    public void union(int p, int q) {
        int i=root(p);
        int j=root(q);
        id[i]=j;

    }

    public int root(int p) {
        while (p != id[p]) {
            p=id[p];
        }
        return p;
    }
    public boolean connected(int p, int q) {

       return root(p) == root(q);
    }
}
