public class A0276PaintFence {
//    这题花费了4个小时左右，没找到规律，对条件分析的不够科学，光顾着找数字规律了，也许是太困了
    public int numWays(int n, int k) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return k;
        }
        int d=k*(k-1);
        int s=k;
        for (int i = 2; i <n; i++) {
            int t = d;
            d=(d+s)*(k-1);
            s=t;
        }
        return d+s;
    }

    public static void main(String[] args) {
        System.out.println(new A0276PaintFence().numWays(3,2));
    }
}
