public class A0771JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        char[] charj = J.toCharArray();
        char[] charS = S.toCharArray();
        boolean[] map = new boolean[127];
        for (int i = 0; i < charj.length; i++) {
            map[charj[i]]=true;
        }
        int count =0;
        for (int i = 0; i < charS.length; i++) {
            if(map[charS[i]]){
                count++;
            }
        }
        return count;
    }
}
