package disjointset;


/***
 * The depth of the tree is always <= log(N)
 */
public class WeightedQuickUnion {
    private int[] id;
    private int[] size;
    public WeightedQuickUnion(int N) {
        id = new int[N];
    }
    public int root(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
    public void union(int p, int q) {
        int i=root(p);
        int j=root(q);
        if (i==j) return;
        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
    }

}
