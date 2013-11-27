public class Solution {
    public boolean isPalindrome(int x) {
        int num = x;
        if (num < 0) {
            return false;
        } else if (num < 10) {
            return true;
        }

        int length = 1;
        long limit = 10;
        while (limit <= num) {
            limit = limit * 10;
            length++;
        }
        int maxBase = 1;
        for (int i = 0; i < length-1; i++) {
            maxBase = maxBase*10;
        }
        while ((num != 0) && (length > 1)) {
            int high = num / maxBase;
            // remove high digit
            num = num - high * maxBase;
            length--;
            int low = num % 10;
            // remove low digit;
            num = num / 10;
            length--;
            maxBase = maxBase/100;
            if (high != low) {
                return false;
            }
        }

        return true;
    }
}