public class Solution {
    public int romanToInt(String s) {
        int num = 0;
        int pos = 0;
        while (pos < s.length()) {
            if (s.charAt(pos) == 'M') {
                num = num + 1000;
            } else if (s.charAt(pos) == 'C') {
                if (pos < s.length()-1 && s.charAt(pos+1) == 'M') {
                    num = num + 900;
                    pos++;
                } else if (pos < s.length()-1 && s.charAt(pos+1) == 'D') {
                    num = num + 400;
                    pos++;
                } else {
                    num = num + 100;
                }
            } else if (s.charAt(pos) == 'D') {
                num = num + 500;
            } else if (s.charAt(pos) == 'X') {
                if (pos < s.length()-1 && s.charAt(pos+1) == 'C') {
                    num = num + 90;
                    pos++;
                } else if (pos < s.length()-1 && s.charAt(pos+1) == 'L') {
                    num = num + 40;
                    pos++;
                } else {
                    num = num + 10;
                }
            } else if (s.charAt(pos) == 'L') {
                num = num + 50;
            } else if (s.charAt(pos) == 'I') {
                if (pos < s.length()-1 && s.charAt(pos+1) == 'X') {
                    num = num + 9;
                    pos++;
                } else if (pos < s.length()-1 && s.charAt(pos+1) == 'V') {
                    num = num + 4;
                    pos++;
                } else {
                    num++;
                }
            } else if (s.charAt(pos) == 'V') {
                num = num + 5;
            }

            pos++;
        }

        return num;
    }
}
