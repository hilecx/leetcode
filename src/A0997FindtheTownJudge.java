import java.util.HashSet;
import java.util.Set;

public class A0997FindtheTownJudge {

    public static void main(String[] args) {
        System.out.println(new A0997FindtheTownJudge().findJudge(2,new int[][]{{1,2}}));
        System.out.println(new A0997FindtheTownJudge().findJudge(3, new int[][]{{1,3},{2,3}}));
        System.out.println(new A0997FindtheTownJudge().findJudge(3, new int[][]{{1,3},{2,3},{3,1}}));
        System.out.println(new A0997FindtheTownJudge().findJudge(3, new int[][]{{1,2},{2,3}}));
        System.out.println(new A0997FindtheTownJudge().findJudge(4, new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}));
    }

    public int findJudge(int N, int[][] trust) {
        boolean[] peoples = new boolean[N+1];
        int[] count = new int[N+1];
        for (int i = 0; i < trust.length; i++) {
            peoples[trust[i][0]] = true;
            count[trust[i][1]] ++;

        }
        for (int i = 1; i < peoples.length; i++) {
            if(!peoples[i] && count[i]==N-1){
                return i;
            }
        }
        return -1;
    }



//    Runtime: 23 ms, faster than 13.40% of Java online submissions for Find the Town Judge.
    public int findJudge2(int N, int[][] trust) {
        Set[] setslr = new Set[N+1];
        Set[] setsrl = new Set[N+1];
        for (int i = 0; i < setslr.length; i++) {
            setslr[i]=new HashSet();
        }
        for (int i = 0; i < setsrl.length; i++) {
            setsrl[i]=new HashSet();
        }

        int count=0;
        int index=-1;
        for (int i = 0; i < trust.length; i++) {
            setslr[trust[i][0]].add(trust[i][1]);
            setsrl[trust[i][1]].add(trust[i][0]);
        }
        for (int i = 1; i < setsrl.length; i++) {
            if(setsrl[i].size()==N-1 && setslr[i].size()==0){
                count++;
                if(count>1){
                    return -1;
                }
                index=i;
            }
        }
        return index;
    }

}
