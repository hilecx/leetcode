import java.util.Arrays;
import java.util.Comparator;

public class A0253MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        boolean[] flags= new boolean[intervals.length];
        int count=0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for (int i = 0; i < flags.length; i++) {

            if(!flags[i]){
                flags[i]=true;
                int end = intervals[i][1];
                for (int j = i+1; j <flags.length ; j++) {
                    if(!flags[j] && intervals[j][0]>=end){
                        end=intervals[j][1];
                        flags[j]=true;
                    }
                }
                count++;
            }
        }
        return count;
    }
}
