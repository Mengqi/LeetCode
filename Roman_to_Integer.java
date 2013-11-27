public class Solution {
    public int romanToInt(String s) {
        if ((s == null) || s.isEmpty()) {
            return 0;
        }
        
        char[] rom = s.toCharArray();
        int length = rom.length;
        
        int num = 0;
        int pos = 0;
        while ((pos < length) && (rom[pos] == 'M')) {
            num = num + 1000;
            pos = pos + 1;
        }
        
        while ((pos + 1 < length) && (rom[pos] == 'C') && (rom[pos+1] == 'M')) {
            num = num + 900;
            pos = pos + 2;
        }
        
        while ((pos < length) && (rom[pos] == 'D')) {
            num = num + 500;
            pos = pos + 1;
        }

        while ((pos + 1 < length) && (rom[pos] == 'C') && (rom[pos+1] == 'D')) {
            num = num + 400;
            pos = pos + 2;
        }
        
        while ((pos < length) && (rom[pos] == 'C')) {
            num = num + 100;
            pos = pos + 1;
        }

        while ((pos + 1 < length) && (rom[pos] == 'X') && (rom[pos+1] == 'C')) {
            num = num + 90;
            pos = pos + 2;
        }
        
         while ((pos < length) && (rom[pos] == 'L')) {
            num = num + 50;
            pos = pos + 1;
        }

        while ((pos + 1 < length) && (rom[pos] == 'X') && (rom[pos+1] == 'L')) {
            num = num + 40;
            pos = pos + 2;
        }
        
        while ((pos < length) && (rom[pos] == 'X')) {
            num = num + 10;
            pos = pos + 1;
        }
        
        if (pos < length) {
            String str = new String(rom, pos, length-pos);
            if (str.equals("I")) {
                num = num + 1;
            } else if (str.equals("II")) {
                num = num + 2;
            } else if (str.equals("III")) {
                num = num + 3;
            } else if (str.equals("IV")) {
                num = num + 4;
            } else if (str.equals("V")) {
                num = num + 5;
            } else if (str.equals("VI")) {
                num = num + 6;
            } else if (str.equals("VII")) {
                num = num + 7;
            } else if (str.equals("VIII")) {
                num = num + 8;
            } else if (str.equals("IX")) {
                num = num + 9;
            }
        }
        
        return num;
    }
}