public class A0206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode currentNode = head;
        ListNode nextNode = head.next;
        head.next=null;
        ListNode tmp = null;
        while (nextNode!=null){
            tmp = nextNode.next;
            nextNode.next = currentNode;
            currentNode = nextNode;
            nextNode = tmp;

        }
        return currentNode;

    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
