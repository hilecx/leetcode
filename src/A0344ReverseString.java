public class A0344ReverseString {
//常规解法
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
//    用位异或来调换char
//    如果 a^b=c 那么必然知道 a^c=b  c^b=a
    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            word[i] = (char) (word[i] ^ word[j]);
            word[j] = (char) (word[i] ^ word[j]);
            word[i] = (char) (word[i] ^ word[j]);
            i++;
            j--;
        }
        return new String(word);


    }

    public static void main(String[] args) {
        System.out.println(new A0344ReverseString().reverseString("ABcdefg"));
    }
}
