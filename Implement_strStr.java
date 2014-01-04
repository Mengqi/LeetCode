public class Solution {
    public String strStr(String haystack, String needle) {
        int hLength = haystack.length();
        int nLength = needle.length();

        if (nLength > hLength) {
            return null;
        }

        if (nLength == 0) {
            return haystack;
        }

        for (int i = 0; i <= hLength - nLength; i++) {
            String substr = haystack.substring(i, i+nLength);
            if (substr.equals(needle)) {
                return haystack.substring(i);
            }
        }

        return null;
    }
}
