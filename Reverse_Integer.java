public class Solution {
    public int reverse(int x) {
        boolean negative = false;
        int num = x;
        if (x < 0) {
            num = -num;
            negative = true;
        }

        int revNum = 0;
        while (num != 0) {
            int digit = num % 10;
            revNum = revNum * 10 + digit;
            num = num / 10;
        }
        
        if (negative) {
            revNum = -revNum;
        }

        return revNum;
    }
}