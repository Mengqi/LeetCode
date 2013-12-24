public class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        if (length1 == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length1;
        }

        int [][] dist = new int[length1+1][length2+1];
        for (int i = 0; i <= length1; i++) {
            dist[i][0] = i;
        }

        for (int i = 0; i <= length2; i++) {
            dist[0][i] = i;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                char ch1 = word1.charAt(i-1);
                char ch2 = word2.charAt(j-1);
                if (ch1 == ch2) {
                    dist[i][j] = dist[i-1][j-1];
                } else {
                    int insertDist = dist[i][j-1] + 1;
                    int deleteDist = dist[i-1][j] + 1;
                    int replaceDist = dist[i-1][j-1] + 1;

                    int min = insertDist;
                    if (deleteDist < min) {
                        min = deleteDist;
                    }
                    if (replaceDist < min) {
                        min = replaceDist;
                    }
                    dist[i][j] = min;
                }
            }
        }

        return dist[length1][length2];
    }
}
