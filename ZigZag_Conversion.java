public class Solution {
    public String convert(String s, int nRows) {
        if (nRows == 1) {
            return s;
        }

        int length = s.length();
        String str = "";

        // row 1
        int pos = 0;
        while (pos < length) {
            char ch = s.charAt(pos);
            str = str + ch;
            pos = pos + 2*nRows-2;
        }

        // mid rows
        for (int i = 2; i <= nRows-1; i++) {

            int pos1 = i-1;
            int pos2 = 2*nRows-i-1;
            while (pos1 < length) {
                char ch1 = s.charAt(pos1);
                str = str + ch1;

                if (pos2 < length) {
                    char ch2 = s.charAt(pos2);
                    str = str + ch2;
                }
                pos1 = pos1 + 2*nRows-2;
                pos2 = pos2 + 2*nRows-2;
            }
        }

        // row nRows
        pos = nRows-1;
        while (pos < length) {
            char ch = s.charAt(pos);
            str = str + ch;
            pos = pos + 2*nRows-2;
        }

        return str;
    }
}
