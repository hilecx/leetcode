import java.util.HashSet;
import java.util.Set;

public class A0824GoatLatin {

    public String toGoatLatin(String S) {
        StringBuffer buffer = new StringBuffer();
        String[] sarray = S.split(" ");
//        Set<Character> set = new HashSet<>();
//        set.add('a');
//        set.add('e');
//        set.add('i');
//        set.add('o');
//        set.add('u');
//        set.add('A');
//        set.add('E');
//        set.add('I');
//        set.add('O');
//        set.add('U');
        for (int i = 0; i < sarray.length; i++) {
            char[] chars = sarray[i].toCharArray();
//            if (set.contains(chars[0])) {
            if (isVowel(chars[0])) {
                buffer.append(sarray[i]);
            } else {
                for (int j = 1; j < chars.length; j++) {
                    buffer.append(chars[j]);
                }
                buffer.append(chars[0]);
            }
            buffer.append("ma");
            for (int j = 0; j < i + 1; j++) {
                buffer.append('a');
            }
            buffer.append(' ');

        }
        return buffer.deleteCharAt(buffer.length()-1).toString();
    }
// this method is faster than using set
    private boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }
}
