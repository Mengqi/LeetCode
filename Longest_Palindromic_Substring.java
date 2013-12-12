public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }

        int newLength = 2*length + 1;

        String str = "";
        for (int i = 0; i < newLength; i++) {
            if (i % 2 == 0) {
                str = str + "#";
            } else {
                str = str + s.charAt(i/2);
            }
        }

        int[] palindrome = new int[newLength];
        palindrome[0] = 1;
        int mx = 0;
        int id = 0;
        for (int i = 1; i < newLength; i++) {
            palindrome[i] = (mx > i) ? Math.min(mx-i, palindrome[2*id-i]) : 1;
            while ((i + palindrome[i] < newLength)
                && ( i - palindrome[i] >= 0)
                && (str.charAt(i + palindrome[i]) == str.charAt(i - palindrome[i]))) {
                palindrome[i]++;
            }
            if (i + palindrome[i]> mx) {
                mx = i + palindrome[i];
                id = i;
            }
        }

        int max = palindrome[0];
        int maxId = 0;
        for (int i = 1; i < newLength; i++) {
            if (palindrome[i] > max) {
                max = palindrome[i];
                maxId = i;
            }
        }

        if (maxId % 2 == 0) {
            int highMedianId = maxId / 2;
            int pLength = palindrome[maxId] - 1;
            return s.substring(highMedianId - (pLength/2), highMedianId + (pLength/2));
        } else {
            int medianId = (maxId - 1) / 2;
            int pLength = palindrome[maxId] - 1;
            return s.substring(medianId - pLength/2, medianId + pLength/2 + 1);
        }
    }
}
