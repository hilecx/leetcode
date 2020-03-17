/*
* 自底向上的动态规划
*
*/

public class Z0001DynamicProgramming2 {
    public static int fib(int n)
    {
        if(n<=0)
            return n;
        int []Memo=new int[n+1];
        Memo[0]=0;
        Memo[1]=1;
        for(int i=2;i<=n;i++)
        {
            Memo[i]=Memo[i-1]+Memo[i-2];
        }
        return Memo[n];
    }

    public static void main(String[] args) {
        System.out.println(Z0001DynamicProgramming2.fib(10));
    }
}
