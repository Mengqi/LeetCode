public class Solution {
    public int evalRPN(String[] tokens) {
        if ((tokens == null) || (tokens.length == 0)) {
            return 0;
        }

        Stack<String> stack = new Stack<String>();
        for (String str : tokens) {
            if (isOperator(str)) {
                String rightStr = stack.pop();
                String leftStr = stack.pop();
                int left = Integer.parseInt(leftStr);
                int right = Integer.parseInt(rightStr);
                int num = 0;
                if (str.equals("+")) {
                    num = left+right;
                } else if (str.equals("-")) {
                    num = left - right;
                } else if (str.equals("*")) {
                    num = left*right;
                } else if (str.equals("/")) {
                    num = left/right;
                }
                stack.push(Integer.toString(num));
            } else {
                stack.push(str);
            }
        }
        return Integer.parseInt(stack.pop());
    }
    
    private boolean isOperator(String str) {
        if (str.equals("+")) {
            return true;
        } else if (str.equals("-")) {
            return true;
        } else if (str.equals("*")) {
            return true;
        } else if (str.equals("/")) {
            return true;
        } else {
            return false;
        }
    }
}