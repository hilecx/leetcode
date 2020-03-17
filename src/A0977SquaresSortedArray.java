import java.util.Arrays;
import java.util.Comparator;

public class A0977SquaresSortedArray {
    public int[] sortedSquares(int[] A) {
        int[] b = new int[A.length];
        int i = 0;
        int j = A.length - 1;
        int bi = A.length - 1;
        while (i < j) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                b[bi--] = A[i] * A[i];
                i++;
            } else {
                b[bi--] = A[j] * A[j];
                j--;
            }

        }
        return b;
    }
}
