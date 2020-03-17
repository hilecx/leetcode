import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class A0784LetterCasePermutation2 {
//第一版本的stringbuffer
    List<StringBuffer> buffers = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        StringBuffer buffer = new StringBuffer();
        f(S.toCharArray(), 0, buffer);
        List<String> r = new ArrayList<>();
        for (StringBuffer stringBuffer : buffers) {
            r.add(stringBuffer.toString());
        }
        return r;
    }

    private void f(char[] chars, int i, StringBuffer buffer) {
        if (i == chars.length) {
            buffers.add(buffer);
            return;
        }
        if (Character.isLetter(chars[i])) {
            StringBuffer buffercopy = new StringBuffer(buffer);
            buffer.append(Character.toLowerCase(chars[i]));
            buffercopy.append(Character.toUpperCase(chars[i]));
            f(chars, i + 1, buffer);
            f(chars, i + 1, buffercopy);
        } else {
            buffer.append(chars[i]);
            f(chars, i + 1, buffer);
        }
    }
    public static void main(String[] args) {
        List<String> r = new A0784LetterCasePermutation2().letterCasePermutation("a1b2C3FF");
        for (String s : r) {
            System.out.println(s);
        }
    }

}
