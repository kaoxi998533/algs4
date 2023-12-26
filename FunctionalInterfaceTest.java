/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class FunctionalInterfaceTest {
    private interface IntFun {
        int fun(int val);
    }

    public int fun(int val) {
        return 1;
    }

    private static class HOF {
        public static int twice(IntFun func, int val) {
            return func.fun(func.fun(val));
        }
    }

    public static void main(String[] args) {
        IntFun f = (i) -> i + 1;
        System.out.println(f.fun(1));
        System.out.println(HOF.twice(f, 1));
    }
}
