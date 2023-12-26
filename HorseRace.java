/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Comparator;

public class HorseRace {
    private static class Horse {
        private String name;
        private double runningTime;

        public Horse(String horseName) {
            this.name = horseName;
        }

        public String getName() {
            return name;
        }

        public void setRunningTime(double runningTime) {
            this.runningTime = runningTime;
        }

        public void getRunningTime(double runningTimeP) {
            this.runningTime = runningTimeP;
        }
    }

    public static class Horses {
        private Horse[] horses;

        public Horses(String[] horsenames) {
            horses = new Horse[horsenames.length];
            for (int i = 0; i < horsenames.length; i++) {
                horses[i] = new Horse(horsenames[i]);
            }
        }

        private void sortRankings() {
            Arrays.sort(this.horses,
                        Comparator.
                                comparingDouble(horse -> horse.runningTime));
        }

        public void startRace() {
            for (int i = 0; i < horses.length; i++) {
                horses[i].setRunningTime(StdRandom.uniformDouble(50.0, 80.0));
            }
            sortRankings();
        }

        public void showRankings() {
            for (int i = 0; i < horses.length; i++) {
                StdOut.println(horses[i].name + " with ranking " + (i + 1) +
                                       " with running time " + horses[i].runningTime);
            }
        }

    }


    public static void main(String[] args) {
        Horses horses = new Horses(args);
        horses.startRace();
        horses.showRankings();
    }
}
