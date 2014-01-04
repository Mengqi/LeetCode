public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> prefix = new ArrayList<String>();

        return restore(s, 1, prefix);
    }

    private ArrayList<String> restore(String s, int pos, ArrayList<String> prefix) {
        ArrayList<String> addrList = new ArrayList<String>();

        int length = s.length();

        if (pos == 4) {
            if (isSectionValid(s)) {
                String solution = "";
                for (String section : prefix) {
                    solution = solution + section + ".";
                }
                solution = solution + s;
                addrList.add(solution);
            }
            return addrList;
        }

        int secLength = Math.min(3, length);
        for (int i = 1; i <= secLength; i++) {
            String section = s.substring(0, i);
            if (isSectionValid(section) && (length - i > 0)) {
                String remainStr = s.substring(i);
                ArrayList<String> newPrefix = new ArrayList<String>(prefix);
                newPrefix.add(section);
                ArrayList<String> addrs = restore(remainStr, pos+1, newPrefix);
                addrList.addAll(addrs);
            }
        }

        return addrList;
    }

    private boolean isSectionValid(String section) {
        int secLength = section.length();
        if (secLength > 3) {
            return false;
        }

        if (secLength > 1 && section.charAt(0) == '0') {
            return false;
        }

        int num = Integer.parseInt(section);
        if (num >= 0 && num <= 255) {
            return true;
        } else {
            return false;
        }
    }
}
