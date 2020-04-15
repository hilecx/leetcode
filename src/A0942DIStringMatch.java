import java.util.Arrays;

public class A0942DIStringMatch {
    public int[] diStringMatch(String S) {
        int max = S.length();
        int min =0;
        int[] array = new int[S.length()+1];
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i)=='I'){
                array[i]=min;
                min++;
            }else {
                array[i]=max;
                max--;
            }
        }
        array[S.length()]=min;
        return array;
    }

    public static void main(String[] args) {
        int[] r;
        r= new A0942DIStringMatch().diStringMatch("IDID");
        System.out.println(Arrays.toString(r));
        r= new A0942DIStringMatch().diStringMatch("IDIDDDDD");
        System.out.println(Arrays.toString(r));
        r= new A0942DIStringMatch().diStringMatch("IDIDIIID");
        System.out.println(Arrays.toString(r));
    }
}
