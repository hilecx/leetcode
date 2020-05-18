import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class A0023MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==1){
            return lists[0];
        }
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null) {
                queue.add(lists[i]);
            }
        }
        ListNode pre = new ListNode(0);
        ListNode cur =pre;
        while (queue.size()!=0){
            cur.next=queue.poll();
            cur=cur.next;
            if(cur.next!=null) {
                queue.add(cur.next);
            }
        }
//        while (queue.size()!=0){
//            ListNode node = queue.poll();
//            cur.next=node;
//            if(node.next!=null) {
//                queue.add(node.next);
//            }
//            cur=node;
//        }
        return pre.next;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        queue.add(1);
        queue.add(2);
        queue.add(-2);
        queue.add(-5);
        queue.add(5);
        while (queue.size()!=0){
            System.out.println(queue.poll());
        }
    }
}
