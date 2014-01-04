public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> solutions = new ArrayList<ArrayList<String>>();

        ArrayList<ArrayList<String>> levelList = new ArrayList<ArrayList<String>>();

        ArrayList<String> curr = new ArrayList<String>();
        curr.add(start);

        while (!curr.isEmpty()) {
            ArrayList<String> next = new ArrayList<String>();

            boolean found = false;
            for (int i = 0; i < curr.size(); i++) {
                String word = curr.get(i);
                if (transformable(word, end)) {
                    found = true;
                    break;
                }

                for (int j = 0; j < word.length(); j++) {
                    String wordTrans = word;
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == wordTrans.charAt(j)) {
                            continue;
                        }
                        wordTrans = wordTrans.substring(0, j) + ch + wordTrans.substring(j+1);
                        if (dict.contains(wordTrans)) {
                            next.add(wordTrans);
                            dict.remove(wordTrans);
                        }
                    }
                }
            }

            levelList.add(curr);
            curr = next;

            if (found) {
                ArrayList<String> suffix = new ArrayList<String>();
                suffix.add(end);
                solutions = getSolutions(suffix, levelList, levelList.size()-1);
                return solutions;
            }
        }

        return solutions;
    }

    private boolean transformable(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();

        if (length1 != length2) {
            return false;
        }

        int diff = 0;
        for (int i = 0; i < length1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }

    ArrayList<ArrayList<String>> getSolutions(ArrayList<String> suffix, ArrayList<ArrayList<String>> levelList, int
    levelNum) {
        ArrayList<ArrayList<String>> solutions= new ArrayList<ArrayList<String>>();

        if (levelNum <  0) {
            solutions.add(suffix);
            return solutions;
        }

        ArrayList<String> level = levelList.get(levelNum);

        String prev = suffix.get(0);
        for (int i = 0; i < level.size(); i++) {
            String word = level.get(i);
            if (transformable(prev, word)) {
                ArrayList<String> newSuffix = new ArrayList<String>(suffix);
                newSuffix.add(0, word);
                ArrayList<ArrayList<String>> slns = getSolutions(newSuffix, levelList, levelNum-1);
                solutions.addAll(slns);
            }
        }

        return solutions;
    }
}
