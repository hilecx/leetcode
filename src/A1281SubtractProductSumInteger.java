public class A1281SubtractProductSumInteger {
    public int subtractProductAndSum(int n) {
        int sum=0;
        int product=1;
        while(n!=0){
            int mod = n%10;
            product = product==0?product:product*mod;
            sum+=mod;
            n=n/10;
        }
        return product-sum;
    }

    public static void main(String[] args) {
        System.out.println(new A1281SubtractProductSumInteger().subtractProductAndSum(1234));
        System.out.println(new A1281SubtractProductSumInteger().subtractProductAndSum(12340));
    }
}
