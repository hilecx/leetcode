public class A0083RemoveDuplicatesfromSortedList2 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode p = head;
        while(p.next!=null){
            if(p.val == p.next.val){
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(2);
        a1.next = new ListNode(2);
        a1.next.next = new ListNode(2);
//        a1.next.next = new ListNode(2);
//        a1.next.next.next = new ListNode(6);
//        a1.next.next.next.next = new ListNode(6);

//        while(a1 !=null){
//            System.out.printf("%d ",a1.val);
//            System.out.println();
//            a1 = a1.next;
//        }
//        while(b1 !=null){
//            System.out.printf("%d ",b1.val);
//            System.out.println();
//            b1 = b1.next;
//        }
        ListNode r = new A0083RemoveDuplicatesfromSortedList2().deleteDuplicates(a1);
        while (r != null) {
            System.out.printf("%d ", r.val);
            r = r.next;
        }
        System.out.println();
    }
}
