/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF uf;
    private boolean[] openStatusOfEntries; // false means closed
    private int maxRow;
    private int maxCol;
    private int noOfOpenSites;
    private int frontEndIndex;
    private int backEndIndex;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("< 0");
        }
        maxCol = n;
        maxRow = n;
        uf = new WeightedQuickUnionUF(n * n + 2);
        openStatusOfEntries = new boolean[n * n + 2];
        for (int i = 0; i < n * n; i++) {
            openStatusOfEntries[i] = false;
        }
        frontEndIndex = n * n;
        backEndIndex = n * n + 1;

    }

    private int findPosition(int row, int col) {
        int position = row * maxCol + col;
        return position;
    }

    // originally with the issue of using maxRow without -1, this is the issue
    // that I ignored
    private boolean outOfBound(int row, int col) {
        return (row > maxRow - 1) || (row < 0) || (col > maxCol - 1) ||
                (col < 0);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        row -= 1;
        col -= 1;
        if (outOfBound(row, col))
            throw new IllegalArgumentException("row or col out of bound");
        int position = findPosition(row, col);
        if (!openStatusOfEntries[position])
            noOfOpenSites++;
        openStatusOfEntries[position] = true;
        // condition: i<n,  n^2-n< i <n^2-1
        // frontend index n^2, backend index n^2 + 1
        if (position < maxRow) {
            uf.union(frontEndIndex, position);
        }
        else if ((position >= Math.pow(maxRow, 2) - maxRow)
                && position < Math.pow(maxRow, 2)) {
            uf.union(backEndIndex, position);
        }
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                int pos = findPosition(i, j);
                if (outOfBound(i, j))
                    continue;
                if (pos == position)
                    continue;
                if ((j == col) || (i == row)) {
                    if (openStatusOfEntries[pos]) {
                        uf.union(position, pos);
                    }
                }
            }

        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        row -= 1;
        col -= 1;
        if (outOfBound(row, col))
            throw new IllegalArgumentException("row or col out of bound");
        int position = findPosition(row, col);
        return openStatusOfEntries[position];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        row -= 1;
        col -= 1;
        if (outOfBound(row, col))
            throw new IllegalArgumentException("row or col out of bound");
        int position = findPosition(row, col);
        return uf.find(position) == uf.find(frontEndIndex);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return noOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(frontEndIndex) == uf.find(backEndIndex);
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation percolation = new Percolation(3);
        percolation.open(3, 2);
        percolation.percolates();
        percolation.open(1, 3);
        percolation.open(2, 2);
        percolation.percolates();
        percolation.percolates();
        percolation.percolates();
        percolation.open(3, 3);
        percolation.open(3, 1);
        StdOut.println(percolation.isFull(3, 1));
        percolation.open(2, 3);
        StdOut.println(percolation.percolates());


    }
}
// 1 to 5 for interface. Find position is 0 to 4
// When 1x1 block, frontend and backend index are unioned without opening
// the only grid


