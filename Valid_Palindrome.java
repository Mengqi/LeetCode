public class Solution {
    public boolean isPalindrome(String s) {
        if ((s == null) || (s.length() <= 1)) {
            return true;
        }
        
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char ch0 = s.charAt(start);
            while (!Character.isLetterOrDigit(ch0) && (start < end)) {
                start++;
                ch0 = s.charAt(start);
            }

            char ch1 = s.charAt(end);
            while (!Character.isLetterOrDigit(ch1) && (end > start)) {
                end--;
                ch1 = s.charAt(end);
            }
            
            ch0 = Character.toLowerCase(ch0);
            ch1 = Character.toLowerCase(ch1);            
            if (ch0 != ch1) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
