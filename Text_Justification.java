public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> text = new ArrayList<String>();

        int num = words.length;
        int remainLength = L;
        int start = 0;
        int pos = 0;
        while (pos < num) {
            String word = words[pos];
            if (pos == start) {
                remainLength = remainLength - word.length();
                pos++;
            } else {
                if (word.length() + 1 <= remainLength) {
                    remainLength = remainLength - word.length() - 1;
                    pos++;
                } else {
                    String line = getLine(words, L, start, pos-1);
                    text.add(line);

                    start = pos;
                    remainLength = L;
                }
            }
        }

        String line = getLine(words, L, start, pos-1);
        text.add(line);

        return text;
    }

    private String getLine(String[] words, int L, int start, int end) {
        String line = "";

        int count = end - start + 1;
        if (count == 1) {
            int totalSpaceNum = L - words[start].length();
            line = words[start] + fillNSpaces(totalSpaceNum);
        } else if (end == ((words.length)-1)) {
            int wordsLength = 0;
            for (int i = start; i <= end; i++) {
                wordsLength = wordsLength + words[i].length();
            }

            int totalSpaceNum = L - wordsLength;
            for (int i = start; i < end; i++) {
                line = line + words[i] + ' ';
                totalSpaceNum--;
            }
            line = line + words[end] + fillNSpaces(totalSpaceNum);
        } else {
            int wordsLength = 0;
            for (int i = start; i <= end; i++) {
                wordsLength = wordsLength + words[i].length();
            }

            int totalSpaceNum = L - wordsLength;
            int baseSpaceNum = totalSpaceNum / (count - 1);
            String baseSpaces = fillNSpaces(baseSpaceNum);

            int extraSpaceCount = totalSpaceNum - baseSpaceNum * (count-1);
            for (int i = start; i < end; i++) {
                line = line + words[i] + baseSpaces;
                if (extraSpaceCount > 0) {
                    extraSpaceCount--;
                    line = line + ' ';
                }
            }
            line = line + words[end];
        }

        return line;
    }

    private String fillNSpaces(int n) {
        String line = "";
        for (int i = 0; i < n; i++) {
            line = line + ' ';
        }
        return line;
    }
}
