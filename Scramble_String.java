public class Solution {
    private HashMap<String, HashMap<String, Boolean>> scrambleMap = new HashMap<String, HashMap<String,
    Boolean>>();

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        return checkScramble(s1, s2);
    }

    private boolean checkScramble(String s1, String s2) {
        int length = s1.length();
        if (scrambleMap.containsKey(s1)) {
            HashMap<String, Boolean> statusMap = scrambleMap.get(s1);
            if (statusMap.containsKey(s2)) {
                return statusMap.get(s2);
            }
        } else {
            HashMap<String, Boolean> statusMap = new HashMap<String, Boolean>();
            scrambleMap.put(s1, statusMap);
        }

        HashMap<String, Boolean> statusMap = scrambleMap.get(s1);

        if (s1.equals(s2)) {
            statusMap.put(s2, true);
            return true;
        }

        if (!containsSameCharacters(s1, s2)) {
            statusMap.put(s2, false);
            return false;
        }

        for (int i = 1; i < length; i++) {
            String str11 = s1.substring(0,i);
            String str12 = s1.substring(i,length);

            String str21 = s2.substring(0,i);
            String str22 = s2.substring(i,length);
            if (checkScramble(str11, str21) && isScramble(str12, str22)) {
                statusMap.put(s2, true);
                return true;
            }

            str21 = s2.substring(0, length-i);
            str22 = s2.substring(length-i, length);
            if (checkScramble(str11, str22) && isScramble(str12, str21)) {
                statusMap.put(s2, true);
                return true;
            }
        }
        statusMap.put(s2, false);
        return false;
    }

    private boolean containsSameCharacters(String s1, String s2) {
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }
}
