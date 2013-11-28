public class Solution {
    public boolean isValid(String s) {
        if ((s == null) || (s.length() == 0)) {
            return true;
        }

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char left = stack.pop();
                if (!isMatch(left, ch)) {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isMatch(char left, char right) {
        if ((left == '(') && (right == ')')) {
            return true;
        } else if ((left == '[') && (right == ']')) {
            return true;
        } else if ((left == '{') && (right == '}')) {
            return true;
        } else {
            return false;
        }
    }
}
