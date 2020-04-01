import java.util.ArrayList;
import java.util.List;

public class A0876MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        while (head.next!=null){
            listNodes.add(head);
            head=head.next;
        }
        return listNodes.get(listNodes.size()/2);
    }
}
