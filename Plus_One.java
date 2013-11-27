public class Solution {
    public int[] plusOne(int[] digits) {
        if ((digits == null) || (digits.length == 0)) {
            return digits;
        }

        int length = digits.length;
        boolean increment = true;
        for (int i = 0; i < length; i++) {
            if (digits[i] != 9) {
                increment = false;
                break;
            }
        }
        
        int[] num;
        if (increment) {
            length = length + 1;
            num = new int[length];
            num[0] = 1;
            for (int i = 1; i < length; i++) {
                num[i] = 0;
            }
        } else {
            int pos = length - 1;
            num = new int[length];
            for (int i = 0; i < length; i++) {
                num[i] = digits[i];
            }
            while (pos >= 0) {
                if (digits[pos] != 9) {
                    num[pos] = digits[pos] + 1;
                    break;
                } else {
                    num[pos] = 0;
                    pos--;
                }
            }
        }
        return num;
    }
}