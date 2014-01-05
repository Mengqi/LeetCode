public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[260];
        
        for (char ch = 'a'; ch <= 'z'; ch++) {
            index[ch] = -1;
        }
        
        int maxLength = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (index[ch] < start) {
                index[ch] = i;
                if (i - start + 1 > maxLength) {
                    maxLength = i - start + 1;
                }
            } else {
                start = index[ch] + 1;
                index[ch] = i;
            }
        }
        
        return maxLength;
    }
}
