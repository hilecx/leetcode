import javax.xml.transform.Source;

public class A2000ReversePrefixofWord {
    public static void main(String[] args) {
        String r;
        r = new A2000ReversePrefixofWord().reversePrefix("abcdefd", 'd');
        System.out.println(r);
        r = new A2000ReversePrefixofWord().reversePrefix("xyxzxe", 'z');
        System.out.println(r);
        r = new A2000ReversePrefixofWord().reversePrefix("abdsd", 'w');
        System.out.println(r);
        r = new A2000ReversePrefixofWord().reversePrefix("arzquwnjyn", 'j');
        System.out.println(r);
    }

    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if(index<-0){
            return word;
        }
        char[] chars = word.toCharArray();
        int endIndex = index/2;
        for (int i = 0; i <= endIndex; i++) {
            char tmp = chars[i];
            chars[i] = chars[index];
            chars[index] = tmp;
            index--;
        }
        return String.valueOf(chars);
    }
}
