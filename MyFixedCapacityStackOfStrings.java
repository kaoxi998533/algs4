/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class MyFixedCapacityStackOfStrings {
    private String[] arr;
    private int n;
    private int index = 0;
    public MyFixedCapacityStackOfStrings(int num) {
        n = num;
        arr = new String[n];
    }
    public String pop() {
        String res = arr[n - 1];
        arr[--n] = null;
        return res;
    }
    public void push(String s) {
        arr[index++] = s;
    }
    public boolean isFull
    public static void main(String[] args) {

    }
}
