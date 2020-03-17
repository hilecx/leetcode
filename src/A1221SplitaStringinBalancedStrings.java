public class A1221SplitaStringinBalancedStrings {
    public int balancedStringSplit(String s) {
        int count = 0;
        int r=0;
        char[] c = s.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]=='R'){
                count++;
            }else{
                count--;
            }
            if(count==0){
                r++;
            }
        }
        return r;
    }
}
