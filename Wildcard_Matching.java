public class Solution {
    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();

        int sPos = 0;
        int pPos = 0;
        int starPos = -1;
        int starStart = -1;
        while (sPos < sLength) {
            char pCh = '\0';
            if (pPos < pLength) {
                pCh = p.charAt(pPos);
            }

            if ((pCh == s.charAt(sPos))|| (pCh == '?')) {
                sPos++;
                pPos++;
                continue;
            }

            if (pCh == '*') {
                starPos = pPos;
                pPos++;
                starStart = sPos;
                continue;
            }

            if (starPos != -1) {
                pPos = starPos + 1;
                starStart++;
                sPos = starStart;
                continue;
            }
            return false;
        }

        while ((pPos < pLength) && (p.charAt(pPos) == '*')) {
            pPos++;
        }

        return pPos == pLength;
    }
}
