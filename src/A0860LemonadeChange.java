public class A0860LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int m5=0;
        int m10=0;
        for (int i = 0; i < bills.length; i++) {
            if(bills[i]==5){
                m5++;
                continue;
            }else if(bills[i]==10){
                m10++;
                m5--;
            }else {
                if(m10>=1){
                    m10--;
                    m5--;
                }else {
                    m5-=3;
                }
            }
            if(m5<0||m10<0){
                return false;
            }
        }
        return true;
    }

//    其实20不用纳入计算的!
    public boolean lemonadeChange2(int[] bills) {
        int[] m = new int[3];//5,10,20
        for (int i = 0; i < bills.length; i++) {
            if(bills[i]==5){
                m[0]++;
                continue;
            }else if(bills[i]==10){
                m[1]++;
                m[0]--;
            }else {
                m[2]++;
                if(m[1]>=1){
                    m[1]--;
                    m[0]--;
                }else {
                    m[0]-=3;
                }
            }
            if(m[0]<0||m[1]<0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new A0860LemonadeChange().lemonadeChange(new int[]{5,5,10,20}));
        System.out.println(new A0860LemonadeChange().lemonadeChange(new int[]{5,5,10,10,20}));
        System.out.println(new A0860LemonadeChange().lemonadeChange(new int[]{5,5,5,10,20}));
        System.out.println(new A0860LemonadeChange().lemonadeChange(new int[]{20,5,5,10,20}));
    }
}
