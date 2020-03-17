import java.awt.font.NumericShaper;
import java.util.Arrays;

public class A1099TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int j = A.length - 1;
        int maxsum = -1;
        for (int i = 0; i < A.length; i++) {
            while (j >= 0) {
                if ( K - A[i] > A[j] && j != i ) {
                    maxsum = Math.max(maxsum, A[j] + A[i]);
                    break;
                }else {
                    j--;
                }
            }
        }
        return maxsum;
    }

    public static void main(String[] args) {
        System.out.println(new A1099TwoSumLessThanK().twoSumLessThanK(new int[]{34,23,1,24,75,33,54,8},60));
        System.out.println(new A1099TwoSumLessThanK().twoSumLessThanK(new int[]{0,20,30},15));
    }
}
