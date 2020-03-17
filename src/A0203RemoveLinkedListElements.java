public class A0203RemoveLinkedListElements {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode cur = head;

        while(cur!=null){
            if(cur.val==val){
                pre.next = cur.next;
                cur = pre.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }

        return preHead.next;
    }
}
