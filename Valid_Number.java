public class Solution {
    public boolean isNumber(String s) {
        int length = s.length();

        int pos = 0;
        while (pos < length && s.charAt(pos) == ' ') {
            pos++;
        }

        if (pos == length) {
            return false;
        }

        int numStart = pos;
        int numCount = 0;
        int flagPos = -1;
        int dotPos = -1;
        int ePos = -1;
        int eFlagPos = -1;
        int eNumCount = 0;
        while (pos < length) {
            char ch = s.charAt(pos);
            if (!Character.isDigit(ch)) {
                if (ch == '.') {
                    if (dotPos == -1 && ePos == -1) {
                        dotPos = pos;
                    } else {
                        return false;
                    }
                } else if (ch == 'e') {
                    if (pos == numStart) {
                        return false;
                    }

                    if (ePos == -1 && numCount > 0) {
                        ePos = pos;
                    } else {
                        return false;
                    }
                } else if (ch == ' ') {
                    break;
                } else if (ch == '+' || ch == '-') {
                    if (flagPos == -1 && numCount == 0 && dotPos == -1 && ePos == -1) {
                        flagPos = pos;
                    } else if (ePos != -1 && eFlagPos == -1 && eNumCount == 0) {
                        eFlagPos = pos;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                numCount++;
                if (ePos != -1) {
                    eNumCount++;
                }
            }
            pos++;
        }

        while (pos < length) {
            char ch = s.charAt(pos);
            if (ch != ' ') {
                return false;
            }
            pos++;
        }

        if (numCount == 0) {
            return false;
        }

        if (ePos != -1 && eNumCount == 0) {
            return false;
        }

        return true;
    }
}
