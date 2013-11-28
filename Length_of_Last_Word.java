public class Solution {
    public int lengthOfLastWord(String s) {
        if ((s == null) || s.length() == 0) {
            return 0;
        }

        int preSpace = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                preSpace++;
            } else {
                break;
            }
        }

        if (preSpace == s.length()) {
            return 0;
        }

        int postSpace = 0;
        for (int i = s.length()-1; i>= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                postSpace++;
            } else {
                break;
            }
        }

        String str = s.substring(preSpace, s.length()-postSpace);

        int length = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                length++;
            } else {
                length = 0;
            }
        }
        return length;
    }
}
