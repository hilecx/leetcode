public class A0657RobotReturntoOrigin {
    public boolean judgeCircle(String moves) {
        int[] count = new int[91];
        char[] chars = moves.toCharArray();
        for (int i = 0; i < moves.length(); i++) {
            count[chars[i]]++;
        }
        return count[68]==count[85]&&count[76]==count[82];
//        return count['U']==count['D']&&count['L']==count['R'];
    }
}
