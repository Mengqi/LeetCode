public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> parents = new ArrayList<String>();
        
        if (n == 0) {
            return parents;
        }
        
        getParenthesis(parents, "", n, 0, 0);
        return parents;
    }
    
    public void getParenthesis(ArrayList<String> parents, String prefix, int n, int leftNum, int rightNum) {
        if ((leftNum + rightNum) == n*2) {
            parents.add(prefix);
            return;
        }
        
        if (leftNum < n) {
            String newPrefix = prefix + "(";
            getParenthesis(parents, newPrefix, n, leftNum+1, rightNum);
        }
        
        if (rightNum < leftNum) {
            String newPrefix = prefix + ")";
            getParenthesis(parents, newPrefix, n, leftNum, rightNum+1);
        }
    }
}