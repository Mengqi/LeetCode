public class Solution {
    public String countAndSay(int n) {
        String prev;
        String curr;

        prev = "1";
        while (--n > 0) {
            curr = "";
            char ch = prev.charAt(0);
            int count = 1;
            for (int i = 1; i < prev.length(); i++) {
                char currChar = prev.charAt(i);
                if (currChar != ch) {
                    curr = curr + count + ch;
                    ch = currChar;
                    count = 1;
                } else {
                    count++;
                }
            }
            curr = curr + count + ch;

            prev = curr;
        }
        return prev;
    }
}
