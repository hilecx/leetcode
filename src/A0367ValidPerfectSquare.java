public class A0367ValidPerfectSquare {
    public boolean isPerfectSquare2(int num) {
        if(num == 1){
            return true;
        }
        long left=2;
        long right=(num+1)/2;
        long mid = left +(right-left)/2;
        while(left<=right){
            if(mid*mid==num){
                return true;
            }else if(mid*mid<num){
                left = mid+1;
            }else if(mid*mid>num){
                right = mid-1;
            }
            mid = left +(right-left)/2;
        }
        return false;
    }

    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        int i = 1;
        while (num > 0) {
            num =num- i;
            i =i+ 2;
        }
        return num == 0;
    }

    public static void main(String[] args) {
        System.out.println(new A0367ValidPerfectSquare().isPerfectSquare(808201));
        System.out.println(new A0367ValidPerfectSquare().isPerfectSquare(2));
        System.out.println(new A0367ValidPerfectSquare().isPerfectSquare(3));
        System.out.println(new A0367ValidPerfectSquare().isPerfectSquare(4));
        System.out.println(new A0367ValidPerfectSquare().isPerfectSquare(5));
        System.out.println(new A0367ValidPerfectSquare().isPerfectSquare(6));
        System.out.println(new A0367ValidPerfectSquare().isPerfectSquare(9));
    }
}
