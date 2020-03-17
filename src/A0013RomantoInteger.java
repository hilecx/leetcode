import java.util.HashMap;
import java.util.Map;

public class A0013RomantoInteger {
    //这个方法以前自己写的，用了字符串操作非常慢
    public int romanToInt2(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);


        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer n = null;
            CharSequence sequence = null;
            if (i <= s.length() - 2) {
                sequence = s.subSequence(i, i + 2);
                n = map.get(sequence.toString());
            }

            if (n != null) {
                r += map.get(sequence.toString());
                i++;
            } else {
                r += map.get(String.valueOf(s.charAt(i)));
            }
        }
        return r;
    }

//char操作就比较快了
    public int romanToInt(String s) {
        char[] ch = s.toCharArray();
        int num = 0;
        for (int i = 0; i < ch.length - 1; i++) {
            if (ch[i] == 'I' && (ch[i + 1] == 'V' || ch[i + 1] == 'X'))
                num -= 2;
            if (ch[i] == 'X' && (ch[i + 1] == 'L' || ch[i + 1] == 'C'))
                num -= 20;
            if (ch[i] == 'C' && (ch[i + 1] == 'D' || ch[i + 1] == 'M'))
                num -= 200;
        }
        for (int i = 0; i < ch.length; i++) {
            switch (ch[i]) {
                case 'M': {
                    num += 1000;
                    continue;
                }
                case 'D': {
                    num += 500;
                    continue;
                }
                case 'C': {
                    num += 100;
                    continue;
                }
                case 'L': {
                    num += 50;
                    continue;
                }
                case 'X': {
                    num += 10;
                    continue;
                }
                case 'V': {
                    num += 5;
                    continue;
                }
                default: {
                    num += 1;
                    continue;
                }
            }
        }
        return num;
    }


    public static void main(String[] args) {
        System.out.println(new A0013RomantoInteger().romanToInt("III"));
        System.out.println(new A0013RomantoInteger().romanToInt("IV"));
        System.out.println(new A0013RomantoInteger().romanToInt("IX"));
        System.out.println(new A0013RomantoInteger().romanToInt("LVIII"));
        System.out.println(new A0013RomantoInteger().romanToInt("MCMXCIV"));
        System.out.println(new A0013RomantoInteger().romanToInt("IXLVIII"));
    }
}
