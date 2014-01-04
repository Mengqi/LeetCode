public class Solution {
    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();

        int pPos = 0;
        int sPos = 0;
        while (sPos < sLength && pPos < pLength) {
            if (pPos < pLength - 1 && p.charAt(pPos+1) == '*') {
                String pSub = p.substring(pPos+2);
                String sSub = s.substring(sPos);
                int count = 0;
                while (count <= sLength - sPos) {
                    if (isMatch(sSub, pSub)) {
                        return true;
                    }
                    pSub = p.charAt(pPos) + pSub;
                    count++;
                }
                return false;
            } else {
                if (p.charAt(pPos) == '.') {
                    pPos++;
                    sPos++;
                } else if (s.charAt(sPos) == p.charAt(pPos)) {
                    sPos++;
                    pPos++;
                } else {
                    return false;
                }
            }
        }

        if (sPos != sLength) {
            return false;
        }

        while (pPos < pLength) {
            if ((pPos < pLength - 1) && p.charAt(pPos+1) == '*') {
                pPos = pPos + 2;
            } else {
                return false;
            }
        }

        return true;
    }
}
