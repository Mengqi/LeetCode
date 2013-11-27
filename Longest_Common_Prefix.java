public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";

        if ((strs == null) || (strs.length == 0)) {
            return prefix;
        }

        int pos = 0;
        while (true) {
            boolean same = true;
            char preChar = 'a';
            boolean first = true;
            for (String str : strs) {
                int strLength = str.length();
                if (pos >= strLength) {
                    same = false;
                    break;
                }
                char ch = str.charAt(pos);
                if (first) {
                    preChar = ch;
                    first = false;
                } else if (preChar != ch) {
                    same = false;
                    break;
                }
            }
            if (same == true) {
                prefix = prefix + preChar;
            } else {
                break;
            }
            pos++;
        }
        return prefix;
    }
}