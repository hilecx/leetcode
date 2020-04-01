import java.util.Arrays;

public class A1304FindNUniqueIntegersSumuptoZero {
    public int[] sumZero(int n) {
        int[] r = new int[n];
        int end = n-n%2;
        for (int i = 0; i <end ; i=i+2) {
            r[i]=i+1;
            r[i+1]=-r[i];
        }
        if(n!=end){
            r[n-1]=0;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new A1304FindNUniqueIntegersSumuptoZero().sumZero(11)));
    }
}
