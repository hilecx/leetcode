public class A0867TransposeMatrix {
    public int[][] transpose(int[][] A) {
        int[][] r = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                r[j][i]=A[i][j];
            }
        }
        return r;
    }
}
