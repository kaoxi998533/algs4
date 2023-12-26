/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class UFQuickFind {
    public static class UF {
        private int[] con;

        public UF(int n) {
            con = new int[n];
            for (int i = 0; i < n; i++) {
                con[i] = i;
            }
        }

        public void union(int a, int b) {
            if (this.isConnnected(a, b))
                return;
            else {
                for (int i = 0; i < con.length; i++) {
                    int conB = con[b];
                    int conA = con[a];
                    if (con[i] == conB)
                        con[i] = conA;
                }
            }
        }

        public boolean isConnnected(int x, int y) {
            return con[x] == con[y];
        }
    }

    public static void main(String[] args) {
        UF uf = new UF(8);
        uf.union(1, 2);
        uf.isConnnected(1, 2);

    }
}
