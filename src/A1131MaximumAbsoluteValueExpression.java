public class A1131MaximumAbsoluteValueExpression {

    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int length = arr1.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length-1; j++) {
                max = Math.max(f(arr1,arr2,i,j),max);
            }
        }
        return max;
    }

    private int f(int[] arr1, int[] arr2, int i, int j){
        return Math.abs(arr1[i]-arr1[j])+ Math.abs(arr2[i]-arr2[j]) + Math.abs(i-j);
    }
}
