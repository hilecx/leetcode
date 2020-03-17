/*
* 自顶向下的备忘录法
*
*/

public class Z0001DynamicProgramming {
    public static int Fibonacci(int n) {
        if (n <= 0)
            return n;
        int[] Memo = new int[n + 1];
        for (int i = 0; i <= n; i++)
            Memo[i] = -1;
        return fib(n, Memo);
    }

    public static int fib(int n, int[] Memo) {

        if (Memo[n] != -1)
            return Memo[n];
        //如果已经求出了fib（n）的值直接返回，否则将求出的值保存在Memo备忘录中。
        if (n <= 2)
            Memo[n] = 1;

        else Memo[n] = fib(n - 1, Memo) + fib(n - 2, Memo);

        return Memo[n];
    }

    public static void main(String[] args) {
        System.out.println(Z0001DynamicProgramming.Fibonacci(10));
    }
}
