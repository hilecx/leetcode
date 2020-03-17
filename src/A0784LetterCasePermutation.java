import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class A0784LetterCasePermutation {

    List<String> r = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        f(S.toCharArray(), 0);
        return r;
    }

    private void f(char[] chars, int i) {
        if (i == chars.length) {
            r.add(new String(chars));
            return;
        }
        if (Character.isLetter(chars[i])) {
            chars[i]=Character.toLowerCase(chars[i]);
            f(chars, i + 1);
            chars[i]=Character.toUpperCase(chars[i]);
            f(chars, i + 1);
        } else {
            f(chars, i + 1);
        }
    }

    public static void main(String[] args) {
        List<String> r = new A0784LetterCasePermutation().letterCasePermutation("a1b2C3FF");
        for (String s : r) {
            System.out.println(s);
        }
        char[] c = new char[2];
        c[0]='a';
        c[1]='b';
        testArray(c);
        System.out.println(Arrays.toString(c));
    }

    private static void testArray(char[] chars){
        chars[0]='c';
    }


    public static void bitsetTest() {

//        String str="g3wiubn23";
//        BitSet used = new BitSet();
//        for (int i = 0; i < str.length(); i++)
//            used.set(str.charAt(i)); // set bit for char
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//        int size = used.size();
//        System.out.println(size);
//        for (int i = 0; i < size; i++) {
//            if (used.get(i)) {
//                sb.append((char) i);
//            }
//        }
//        sb.append("]");
//        System.out.println(sb.toString());

        BitSet bitSet = new BitSet(16);
        BitSet bitSet2 = new BitSet(10);
        bitSet2.set(10);
        bitSet2.set(1);
        bitSet2.set(2);


        bitSet.set(3);
        bitSet.set(2);
        bitSet2.and(bitSet);
        System.out.println(bitSet2.get(1));//0
        System.out.println(bitSet2.get(2));//1
        System.out.println(bitSet2.get(3));//0

//        bitSet.and(bitSet2);
        System.out.println(bitSet2.nextSetBit(0));
        System.out.println(bitSet2.nextSetBit(4));
        System.out.println(bitSet2.nextSetBit(0));
        System.out.println(bitSet2.nextSetBit(11));
        System.out.println(bitSet.toString());
    }

    /**
     * 求一个字符串包含的char
     */
    public static void containChars(String str) {
        BitSet used = new BitSet();
        for (int i = 0; i < str.length(); i++)
            used.set(str.charAt(i)); // set bit for char

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int size = used.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            if (used.get(i)) {
                sb.append((char) i);
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

}
