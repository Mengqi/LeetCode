public class Solution {
    public String minWindow(String S, String T) {
        int sLength = S.length();
        int tLength = T.length();

        int[] count = new int[260];
        int[] now = new int[260];
        for (int i = 0; i < 260; i++) {
            count[i] = 0;
            now[i] = 0;
        }

        for (int i = 0; i < tLength; i++) {
            char ch = T.charAt(i);
            count[ch]++;
        }

        int minLength = sLength + 1;
        int minLeft = -1;
        int minRight = -1;
        int matchNum = 0;

        int start = 0;
        for (int i = 0; i < sLength; i++) {
            if (matchNum < tLength) {
                char ch = S.charAt(i);
                if (now[ch] < count[ch]) {
                    matchNum++;
                }
                now[ch]++;
            }

            if (matchNum == tLength) {
                while (start <= i) {
                    char ch = S.charAt(start);
                    if (now[ch] > count[ch]) {
                        start++;
                        now[ch]--;
                    } else {
                        break;
                    }
                }
                if (minLength > i - start + 1) {
                    minLeft = start;
                    minRight = i;
                    minLength = i - start + 1;
                }

                while (matchNum == tLength) {
                    char ch = S.charAt(start);
                    now[ch]--;
                    if (now[ch] < count[ch]) {
                        matchNum--;
                    }
                    start++;
                }
            }
        }

        if (minLength == sLength + 1) {
            return "";
        } else {
            return S.substring(minLeft, minRight+1);
        }
    }
}
