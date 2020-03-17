public class A0509FibonacciNumber {
    public int fib(int N) {
        if(N<=1){
            return N;
        }
        int f0 = 0;
        int f1 = 1;
        int r = 1;
        for (int i = 2; i < N; i++) {
            r = f0+f1;
            f0=f1;
            f1=r;
        }
        return r;
    }
}
