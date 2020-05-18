import java.util.ArrayList;
import java.util.List;

public class A0002AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = l1;
        boolean up=false;
        int sum=0;
        List<Integer> r = new ArrayList<>();
        while (l1!=null||l2!=null){
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            if(up){
                sum++;
            }
            System.out.println(sum);
            up=sum>=10;
            r.add(sum%10);
            sum=0;

        }
        if(up){
            r.add(1);
        }
        ListNode rnode = new ListNode(r.get(0));
        ListNode cnode = rnode;
        for (int j = 1; j < r.size(); j++) {
            cnode.next=new ListNode(r.get(j));
            cnode=cnode.next;
        }
        return rnode;
    }


}
