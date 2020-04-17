public class A0896MonotonicArray {
    public boolean isMonotonic(int[] A) {
        int upordown=0;
        for (int i = 1; i < A.length; i++) {
            if(A[i]>A[i-1] && upordown!=-1){
                upordown=1;
            }else if(A[i]<A[i-1] && upordown!=1){
                upordown=-1;
            }else if(A[i]==A[i-1]){
                upordown=0;
            }else {
                return false;
            }
        }
        return true;
    }
}
