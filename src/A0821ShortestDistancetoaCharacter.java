import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A0821ShortestDistancetoaCharacter {
    public int[] shortestToChar(String S, char C) {
        char[] c = S.toCharArray();
        List<Integer> cindex = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            if(c[i]==C){
                cindex.add(i);
            }
        }
        int[] r= new int[c.length];
        int cindex0 =cindex.get(0);
        for (int i = 0; i < cindex0; i++) {
            r[i]=cindex0-i;
        }
        int cindexlast=cindex.get(cindex.size()-1);
        for (int i = c.length-1; i > cindexlast; i--) {
            r[i]=i-cindexlast;
        }
        for (int i = 0; i < cindex.size()-1; i++) {
            int j=cindex.get(i);
            int k=cindex.get(i+1);
            int d=0;
            while (k>=j){
                r[j++]=d;
                r[k--]=d;
                d++;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new A0821ShortestDistancetoaCharacter().shortestToChar("loveleetcode",'e')));
        System.out.println(Arrays.toString(new A0821ShortestDistancetoaCharacter().shortestToChar("loveleetcode333",'e')));
        System.out.println(Arrays.toString(new A0821ShortestDistancetoaCharacter().shortestToChar("eeeeee",'e')));
        System.out.println(Arrays.toString(new A0821ShortestDistancetoaCharacter().shortestToChar("eeaaaeee",'e')));
        System.out.println(Arrays.toString(new A0821ShortestDistancetoaCharacter().shortestToChar("aaaaeaaaa",'e')));
        System.out.println(Arrays.toString(new A0821ShortestDistancetoaCharacter().shortestToChar("loveleaaaetcode",'e')));
        System.out.println(Arrays.toString(new A0821ShortestDistancetoaCharacter().shortestToChar("loveledddetcode",'e')));
    }
}
