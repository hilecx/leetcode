import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A0888FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            sumA -= B[i];
            setB.add(B[i]);
        }
        int diff = sumA/2;
        for (int i = 0; i < A.length; i++) {
            int d = A[i]-diff;
            if(d<=0){
                continue;
            }
            if(setB.contains(d)){
                return new int[]{A[i],A[i]-diff};
            }
        }
        return new int[2];
    }

    public int[] fairCandySwap2(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
            setB.add(B[i]);
        }
        int diff = (sumA - sumB)/2;
        for (int i = 0; i < A.length; i++) {
            int d = A[i]-diff;
            if(d<=0){
                continue;
            }
            if(setB.contains(d)){
                return new int[]{A[i],A[i]-diff};
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new A0888FairCandySwap().fairCandySwap(new int[]{1,2,5},new int[]{2,4})));
    }
}
