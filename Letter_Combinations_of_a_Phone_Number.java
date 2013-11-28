public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> combos = new ArrayList<String>();

        if (digits == null) {
            return combos;
        }

        if (digits.length() == 0) {
            combos.add(digits);
            return combos;
        }

        return getCombos(digits, "");
    }

    private ArrayList<String> getCombos(String digits, String prefix) {
        ArrayList<String> combos = new ArrayList<String>();

        if ((digits == null) || (digits.length() == 0)) {
            return combos;
        }

        if (digits.length() == 1) {
            char digit = digits.charAt(0);
            String letterString = getLetterString(digit);
            for (int i = 0; i < letterString.length(); i++) {
                String combo = new String(prefix);
                char ch = letterString.charAt(i);
                combo = combo + ch;
                combos.add(combo);
            }
        } else {
            char digit = digits.charAt(0);
            String newDigits = digits.substring(1);
            String letterString = getLetterString(digit);
            for (int i = 0; i < letterString.length(); i++) {
                String newPrefix = new String(prefix);
                char ch = letterString.charAt(i);
                newPrefix = newPrefix + ch;
                combos.addAll(getCombos(newDigits, newPrefix));
            }
        }
        return combos;
    }

    private String getLetterString(char digit) {
        switch (digit) {
        case '0': return " ";
        case '1': return "";
        case '2': return "abc";
        case '3': return "def";
        case '4': return "ghi";
        case '5': return "jkl";
        case '6': return "mno";
        case '7': return "pqrs";
        case '8': return "tuv";
        case '9': return "wxyz";
        default:  return "";
        }
    }
}
