public class A0557ReverseWordsinaStringIII {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int wordStart = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if ( chars[i] == ' ') {
                reverse(chars,wordStart,i-1);
                wordStart = i + 1;
                continue;
            }
        }
        reverse(chars,wordStart,s.length()-1);
        return new String(chars);
    }

    private void reverse(char[] array, int i, int j) {
        char tmp;
        while (i < j) {
            tmp = array[i];
            array[i++] = array[j];
            array[j--] = tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println(new A0557ReverseWordsinaStringIII().reverseWords("abc defg hijk"));
    }

    private void switchArray(char[] array, char i1, char i2) {
        char tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }

    public String reverseWords2(String s) {
        String[] strings = s.split(" ");
        char[] chars;
        for (int j = 0; j < strings.length; j++) {
            chars = strings[j].toCharArray();
            for (int i = 0; i < chars.length / 2; i++) {
                char tmp = chars[i];
                chars[i] = chars[chars.length - i - 1];
                chars[chars.length - i - 1] = tmp;
            }
            strings[j] = new String(chars);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            stringBuffer.append(strings[i]);
            stringBuffer.append(" ");
        }
        return stringBuffer.toString().trim();
    }

}
