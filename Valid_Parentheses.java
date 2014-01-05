public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        int pos = 0;
        while (pos < s.length()) {
            char ch = s.charAt(pos);
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || !isMatch(stack.pop(), ch)) {
                    return false;
                }
            }
            pos++;
        }
        
        return stack.isEmpty();
    }
    
    private boolean isMatch(char ch1, char ch2) {
        if (ch1 == '(' && ch2 == ')') {
            return true;
        } else if (ch1 == '[' && ch2 == ']') {
            return true;
        } else if (ch1 == '{' && ch2 == '}') {
            return true;
        } else {
            return false;
        }
    }
}
