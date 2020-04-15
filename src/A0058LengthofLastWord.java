import java.sql.SQLOutput;

public class A0058LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && count != 0) {
                break;
            } else if (s.charAt(i) == ' ' && count == 0) {
                continue;
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new A0058LengthofLastWord().lengthOfLastWord("asdf asdf"));
        System.out.println(new A0058LengthofLastWord().lengthOfLastWord("asdf asdf "));
        System.out.println(new A0058LengthofLastWord().lengthOfLastWord("asdf asdfsdf"));
    }
}
