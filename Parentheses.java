/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.Stack;

public class Parentheses {
    public static void main(String[] args) {
        Stack<String> parentheses = new Stack<>();
        boolean flag = true;
        String ops = args[0];
        for (int i = 0; i < ops.length(); i++) {
            String op = ops.substring(i, i + 1);
            if (op.equals(")")) {
                if (parentheses.isEmpty() || !parentheses.pop().equals("(")) {
                    flag = false;
                    break;
                }
            }
            else if (op.equals("}")) {
                if (parentheses.isEmpty() || !parentheses.pop().equals("{")) {
                    flag = false;
                    break;
                }

            }
            else if (op.equals("]")) {
                if (parentheses.isEmpty() || !parentheses.pop().equals("[")) {
                    flag = false;
                    break;
                }
            }
            if (op.equals("[") || op.equals("{") || op.equals("("))
                parentheses.push(op);
        }
        if (!parentheses.isEmpty()) {
            flag = false;
        }
        System.out.println(flag);

    }
}
