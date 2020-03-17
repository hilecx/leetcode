import java.util.Arrays;

public class A1170CompareStringsCharacter {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] qc = new int[queries.length];
        int[] wc = new int[words.length];
        int[] r = new int[queries.length];


        for (int i = 0; i < queries.length; i++) {
            qc[i] = fmc(queries[i]);
        }
        for (int i = 0; i < words.length; i++) {
            wc[i] = fmc(words[i]);
        }
        System.out.println(Arrays.toString(qc));
        System.out.println(Arrays.toString(wc));
//        Arrays.sort(qc);
        Arrays.sort(wc);
        System.out.println(Arrays.toString(wc));
//        for (int i = 0; i < qc.length; i++) {
//            for (int j = 0; j < wc.length; j++) {
//                if (qc[i] < wc[j]) {
//                    r[i] = wc.length - j;
//                    break;
//                }
//            }
//        }

//        for (int i = 0; i < qc.length; i++) {
//            int j=0;
//            int k=wc.length-1;
//            while (i<k){
//                int mid = j/2+k/2;
//                if(wc[mid]<=qc[i]&&qc[i]<wc[mid+1]){
//                    r[i] = wc.length-mid+1;
//                    break;
//                }else if(wc[mid]>=qc[i])
//            }
//
//        }

        for (int i = 0; i < qc.length; i++) {
            int l = 0, rt = wc.length - 1;
            while (l <= rt) {
                int mid = (l + rt) / 2;
                if (wc[mid] <= qc[i]) {
                    l = mid + 1;
                }
                else {
                    rt = mid - 1;
                }
            }
            r[i] = wc.length - l;
        }
        return r;
    }


    private int fmc2(String s) {

        char[] chars = s.toCharArray();
        char smallest = chars[0];
        int smallestCount = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == smallest) {
                smallestCount++;
            } else if (chars[i] < smallest) {
                smallest = chars[i];
                smallestCount = 1;
            }
        }
        return smallestCount;
    }

    private int fmc(String s) {
        char[] chars = s.toCharArray();
        int[] sm = new int[123];
        for (int i = 0; i < chars.length; i++) {
            sm[chars[i]]++;
        }
        for (int i = 97; i < 123; i++) {
            if (sm[i] != 0) {
                return sm[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] r = new A1170CompareStringsCharacter().numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"aaaaaa", "aa", "aaa", "aaaa"});
        int[] r2 = new A1170CompareStringsCharacter().numSmallerByFrequency(
                new String[]{"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"},
                new String[]{"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"});
        System.out.println(Arrays.toString(r2));
    }
}
