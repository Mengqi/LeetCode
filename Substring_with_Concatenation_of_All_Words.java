public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> indices = new ArrayList<Integer>();

        int sLength = S.length();
        int lLength = L.length;
        if (sLength == 0 || lLength == 0) {
            return indices;
        }
        int wLength = L[0].length();

        HashMap<String, Integer> countMap = new HashMap<String, Integer>();
        for (String word : L) {
            if (!countMap.containsKey(word)) {
                countMap.put(word, 1);
            } else {
                int count = countMap.get(word);
                countMap.put(word, count+1);
            }
        }

        for (int i = 0; i <= sLength - wLength*lLength; i++) {
            HashMap<String, Integer> currCountMap = new HashMap<String, Integer>();

            int num = 0;
            boolean match = true;
            while ((match == true) && (num < lLength)) {
                int start = i + num*wLength;
                String substr = S.substring(start, start+wLength);
                if (countMap.containsKey(substr)) {
                    int count;
                    if (currCountMap.containsKey(substr)) {
                        count = currCountMap.get(substr);
                        count = count + 1;
                        currCountMap.put(substr, count);
                    } else {
                        count = 1;
                        currCountMap.put(substr,count);
                    }

                    if (count > countMap.get(substr)) {
                        match = false;
                    }
                } else {
                    match = false;
                }
                num++;
            }

            if (match) {
                indices.add(i);
            }
        }

        return indices;
    }
}
