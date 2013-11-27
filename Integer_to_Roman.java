public class Solution {
    public String intToRoman(int num) {
        String rom = "";

        int mNum = num / 1000;
        for (int i = 0; i < mNum; i++) {
            rom = rom + "M";
        }
        num = num - mNum*1000;
        
        if (num >= 900) {
            num = num - 900;
            rom = rom + "CM";
        }

        int dNum = num / 500;
        for (int i = 0; i < dNum; i++) {
            rom = rom + "D";
        }
        num = num - dNum*500;
        
        if (num >= 400) {
            num = num - 400;
            rom = rom + "CD";
        }
        
        int cNum = num / 100;
        for (int i = 0; i < cNum; i++) {
            rom = rom + "C";
        }
        num = num - cNum*100;
        
        if (num >= 90) {
            num = num - 90;
            rom = rom + "XC";
        }
        
        int lNum = num / 50;
        for (int i = 0; i < lNum; i++) {
            rom = rom + "L";
        }
        num = num - lNum*50;
        
        if (num >= 40) {
            num = num - 40;
            rom = rom + "XL";
        }
        
        int xNum = num / 10;
        for (int i = 0; i < xNum; i++) {
            rom = rom + "X";
        }
        num = num - xNum*10;
        
        switch(num) {
            case 1: rom = rom + "I"; break;
            case 2: rom = rom + "II"; break;
            case 3: rom = rom + "III"; break;
            case 4: rom = rom + "IV"; break;
            case 5: rom = rom + "V"; break;
            case 6: rom = rom + "VI"; break;
            case 7: rom = rom + "VII"; break;
            case 8: rom = rom + "VIII"; break;
            case 9: rom = rom + "IX"; break;
            default: break;
        }
        return rom;
    }
}