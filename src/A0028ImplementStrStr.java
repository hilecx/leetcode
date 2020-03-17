import java.util.regex.Matcher;
import java.util.regex.Pattern;
//需要学习一下KMP算法
public class A0028ImplementStrStr {
    public int strStrbt(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

//    用正则测试一下
    public int strStr1(String haystack, String needle) {
        String input = needle;

        Pattern p = Pattern.compile(input);
        Matcher m = p.matcher(haystack);

        while(m.find()) {
            return m.start();
        }
        return -1;
    }
//双指针法
    public int strStr2(String haystack, String needle) {
        if(needle==null || needle.length()==0){
            return 0;
        }
        int j = 0;
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        for (int i = 0; i < haystack.length(); i++) {
            if(h[i] == n[j]){
                if(++j == needle.length()){
                    return i-j+1;
                }
            }else {
                i = i-j;
                if(i>haystack.length()-needle.length()){
                    return -1;
                }
                j=0;
            }
        }
        return -1;
    }
//jdk自带代码
    public int strStr(String haystack, String needle) {
        if(needle==null || needle.length()==0){
            return 0;
        }
        char[] target = needle.toCharArray();
        char[] source = haystack.toCharArray();
        char first = target[0];
        int max = source.length - target.length;

        for (int i = 0; i <= max; i++) {
            /* Look for first character. */
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }
            /* Found first character, now look at the rest of v2 */
            if (i <= max) {
                int j = i + 1;
                int end = j + target.length - 1;
                for (int k = 1; j < end && source[j]
                        == target[k]; j++, k++);

                if (j == end) {
                    /* Found whole string. */
                    return i;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(new A0028ImplementStrStr().strStr("aabaaabaaac","aabaaac"));
        System.out.println("hello".indexOf("e"));
        System.out.println(new A0028ImplementStrStr().strStr("mississippi","issip"));
        System.out.println(new A0028ImplementStrStr().strStr("hello","ll"));
        System.out.println(new A0028ImplementStrStr().strStr("hello","llo"));
        System.out.println(new A0028ImplementStrStr().strStr("hello","lls"));
        System.out.println(new A0028ImplementStrStr().strStr("hello","he"));

    }
}
