public class A0083RemoveDuplicatesfromSortedList {

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
        int c = head.val;
        ListNode preHead = head;
        ListNode cursor = head.next;
        while (cursor != null){
            if(cursor.val == preHead.val){
                preHead.next=cursor.next;
            }else if(cursor.val != preHead.val){
                preHead=cursor;
            }
            cursor=cursor.next;
            System.out.printf("head:%d  subhead:%d  cursor:%d  c:%d \n",head.val,preHead.val,cursor!=null?cursor.val:null,c);
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
        ListNode r = new A0083RemoveDuplicatesfromSortedList().deleteDuplicates(a1);
        while (r != null) {
            System.out.printf("%d ", r.val);
            r = r.next;
        }
        System.out.println();
    }
}
