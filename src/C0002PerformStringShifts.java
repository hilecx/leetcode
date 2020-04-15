public class C0002PerformStringShifts {
//    https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/

    public String stringShift(String s, int[][] shift) {
        int x=0;
        for (int i = 0; i < shift.length; i++) {
            if(shift[i][0]==1){
                x-=shift[i][1];
            }else {
                x+=shift[i][1];
            }
        }
        x=x%s.length();
        if(x<0){
            x+=s.length();
        }
        return s.substring(x+1)+s.substring(0,x+1);
    }


}
