public class A0141LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
//        if(head.equals(head.next)){
//            return true;
//        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p2!=null && p2.next!=null){
            if(p1==p2){ //这里是地址比较，不用equals
                return true;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return false;
    }
}
