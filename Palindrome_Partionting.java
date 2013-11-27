public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> parts = new ArrayList<ArrayList<String>>();
        
        if ((s == null) || (s.length() == 0)) {
            return parts;
        }
        
        getParts(parts, s, 0, null);
        return parts;
    }
    
    private void getParts(ArrayList<ArrayList<String>> parts, String s, int start, ArrayList<String> prefix) {
        if (start >= s.length()) {
            if (prefix != null) {
                parts.add(prefix);
            }
        }
        
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start,i+1);
            if (isPalindrome(str)) {
                ArrayList<String> newPrefix;
                if (prefix == null) {
                    newPrefix = new ArrayList<String>();
                    newPrefix.add(str);
                } else {
                    newPrefix = new ArrayList<String>(prefix);
                    newPrefix.add(str);
                }
                getParts(parts, s, i+1, newPrefix);
            }
        }
    }
    
    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}