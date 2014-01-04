public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }

        HashMap<Character, Integer> indexMap = new HashMap<Character, Integer>();
        int maxLength = 0;
        int start = 0;
        int index = 0;

        while (index < length) {
            char ch = s.charAt(index);
            if (indexMap.containsKey(ch)) {
                maxLength = Math.max(maxLength, index - start);

                char startCh = s.charAt(start);
                indexMap.remove(startCh);
                start++;
            } else {
                indexMap.put(ch, index);
                index++;
            }
        }

        maxLength = Math.max(maxLength, indexMap.size());
        return maxLength;
    }
}
