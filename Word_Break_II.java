public class Solution {
    private HashMap<String, ArrayList<String>> breakMap = new HashMap<String, ArrayList<String>>();

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> breakList = new ArrayList<String>();

        if ((s == null) || (s.length() == 0)) {
            return breakList;
        }

        int sLength = s.length();
        boolean [][] match = new boolean [sLength][sLength];
        boolean [][] dictMatch = new boolean [sLength][sLength];
        for (int i = 0; i < sLength; i++) {
            for (int j = i; j < sLength; j++) {
                match[i][j] = false;
                dictMatch[i][j] = false;
            }
        }

        for (String word : dict) {
            int wLength = word.length();
            for (int i = 0; i <= sLength - wLength; i++) {
                int j = i + wLength - 1;
                String substr = s.substring(i, i+wLength);
                if (substr.equals(word)) {
                    match[i][j] = true;
                    dictMatch[i][j] = true;
                }
            }
        }

        for (int length = 2; length <= sLength; length++) {
            for (int i = 0; i <= sLength-length; i++) {
                int j = i + length - 1;
                if (match[i][j]) {
                    continue;
                }
                for (int k = i; k < j; k++) {
                    if (match[i][k] && match[k+1][j]) {
                        match[i][j] = true;
                        break;
                    }
                }
            }
        }

        return breakStr(s, dict, match, dictMatch, 0, sLength-1);
    }

    private ArrayList<String> breakStr(String s, Set<String> dict, boolean[][] match, boolean[][] dictMatch, int
    start, int end) {
        ArrayList<String> breakList = new ArrayList<String>();
        if (match[start][end] == false) {
            return breakList;
        }

        String substr = s.substring(start, end+1);
        if (breakMap.containsKey(substr)) {
            return breakMap.get(substr);
        }

        if (dictMatch[start][end]) {
            breakList.add(substr);
        }

        for (int i = start; i < end; i++) {
            if (match[start][i] && match[i+1][end]) {
                ArrayList<String> prefixes = breakStr(s, dict, match, dictMatch, start, i);
                ArrayList<String> suffixes = breakStr(s, dict, match, dictMatch, i+1, end);
                for (String prefix : prefixes) {
                    for (String suffix : suffixes) {
                        String solution = prefix + " " + suffix;
                        if (!breakList.contains(solution)) {
                            breakList.add(solution);
                        }
                    }
                }
            }
        }

        breakMap.put(substr, breakList);

        return breakList;
    }
}
