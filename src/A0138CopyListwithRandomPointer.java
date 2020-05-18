import java.util.HashMap;
import java.util.Map;

public class A0138CopyListwithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node preHead = new Node(0);
        Node cur = preHead;
        while (head!=null){
            cur.next = new Node(head.val);
            cur = cur.next;
            cur.random=head.random;
            map.put(head,cur);
            head=head.next;
        }
        // for (Node value : map.values()) {
        //     System.out.println("map value:"+value.val);
        // }
        cur = preHead.next;
        while (cur!=null){
            // System.out.printf("cur: %d \n",cur.val);
            cur.random=map.get(cur.random);
            // System.out.printf("cur random: %d \n",cur.random.val);
            cur=cur.next;
        }
        return preHead.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

