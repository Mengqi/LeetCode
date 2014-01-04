public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> curr = new LinkedList<String>();
        curr.add(start);
        Queue<String> next = new LinkedList<String>();

        int distance = 1;
        while (!curr.isEmpty()) {
            String word = curr.remove();

            if (transformable(word, end)) {
                return distance + 1;
            }

            for (int i = 0; i < word.length(); i++) {
                String wordTrans = word;
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == wordTrans.charAt(i)) {
                        continue;
                    }
                    wordTrans = wordTrans.substring(0, i) + ch + wordTrans.substring(i+1);
                    if (dict.contains(wordTrans)) {
                        next.add(wordTrans);
                        dict.remove(wordTrans);
                    }
                }
            }

            if (curr.isEmpty()) {
                Queue<String> temp = curr;
                curr = next;
                next = temp;
                distance++;
            }
        }

        return 0;
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
}
