public class A0070ClimbingStairs {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        int[] meno = new int[n+1];
        meno[0]=1;
        meno[1]=1;
        meno[2]=2;
        return f(n,meno);
    }

    private int f(int n,int[] meno){
        if(meno[n-1] == 0){
            meno[n-1] =f(n-1,meno);
        }
        if(meno[n-2] == 0){
            meno[n-2] =f(n-2,meno);
        }
        return meno[n-1]+meno[n-2];
    }

    public static void main(String[] args) {
        System.out.println(new A0070ClimbingStairs().climbStairs(1));
        System.out.println(new A0070ClimbingStairs().climbStairs(2));
        System.out.println(new A0070ClimbingStairs().climbStairs(3));
        System.out.println(new A0070ClimbingStairs().climbStairs(4));
        System.out.println(new A0070ClimbingStairs().climbStairs(5));
        System.out.println(new A0070ClimbingStairs().climbStairs(6));
    }
}
