import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class A1046LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1){
            return stones[0];
        }
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < stones.length; i++) {
            queue.add(stones[i]);
        }
        while (queue.size()>=2){
            int a =queue.poll();
            int b =queue.poll();
            if(a==b){
                continue;
            }else {
                queue.add(a-b);
            }
        }
        return queue.size()==1?queue.poll():0;
    }
}
