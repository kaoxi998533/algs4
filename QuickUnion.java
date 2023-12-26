import edu.princeton.cs.algs4.StdOut;

public class QuickUnion {
    private int[] p;
    private int[] sz;

    public QuickUnion(int num) {
        p = new int[num];
        sz = new int[num];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
            sz[i] = 1;
        }
    }

    public int root(int node) {
        int res = node;
        while (p[res] != res) {
            p[res] = p[p[res]];
            res = p[res];
        }
        return res;
    }

    public boolean connected(int node1, int node2) {
        return root(node1) == root(node2);
    }

    public void union(int node1, int node2) {
        int r1 = root(node1);
        int r2 = root(node2);
        if (sz[r1] > sz[r2]) {
            p[r2] = r1;
            sz[r1] += r2;
        }
        else {
            p[r1] = r2;
            sz[r2] += r1;
        }
    }

    public static void main(String[] args) {
        QuickUnion UF = new QuickUnion(Integer.parseInt(args[0]));
        UF.union(3, 6);
        UF.union(5, 3);

        StdOut.println(UF.connected(3, 5));
    }
}
