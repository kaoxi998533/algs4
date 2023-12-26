/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private Percolation perc;
    private int noOfTrials;
    private int maxRow;
    private int maxCol;
    private double[] trialThresholds;
    private double cONFIDENCE95 = 1.96;
    // this is an optimized use of memory and time, avoid repetitive calls
    private double mean = 0.0;
    private double stddev = 0.0;


    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n < 0 || trials <= 0)
            throw new IllegalArgumentException("");
        trialThresholds = new double[trials];
        maxCol = n;
        maxRow = n;
        perc = new Percolation(n);
        noOfTrials = trials;
    }

    // sample mean of percolation threshold
    public double mean() {
        if (mean != 0)
            return mean;
        for (int i = 0; i < noOfTrials; i++) {
            int trialIndex = 0;
            while (!perc.percolates()) {
                int randomRow = StdRandom.uniformInt(1, maxRow + 1);
                int randomCol = StdRandom.uniformInt(1, maxCol + 1);
                while (perc.isOpen(randomRow, randomCol)) {
                    randomRow = StdRandom.uniformInt(1, maxRow + 1);
                    randomCol = StdRandom.uniformInt(1, maxCol + 1);
                }
                perc.open(randomRow, randomCol);
                trialIndex++;
            }

            trialThresholds[i] = (trialIndex + 0.0) / (maxRow * maxCol);
            // avoid creating the last redundant Percolation object
            if (i != noOfTrials - 1)
                perc = new Percolation(maxCol);
        }
        mean = StdStats.mean(trialThresholds);
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        if (stddev != 0)
            return stddev;
        stddev = StdStats.stddev(trialThresholds);
        return stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        double meanX = mean();
        double stdDev = stddev();
        return meanX - (cONFIDENCE95 * stdDev) / Math.sqrt(noOfTrials);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        double meanX = mean();
        double stdDev = stddev();
        return meanX + (cONFIDENCE95 * stdDev) / Math.sqrt(noOfTrials);
    }

    // test client (see below)
    public static void main(String[] args) {

        PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]),
                                                   Integer.parseInt(args[1]));

        StdOut.println("mean = " + ps.mean() + "\n"
                               + "stddev = " + ps.stddev()
                               + "\n"
                               + "95% confidence interval = "
                               + "[" + ps.confidenceLo()
                               + ", "
                               + ps.confidenceHi()
                               + "]");

    }


}
