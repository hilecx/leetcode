public class A0021MergeTwoSortedLists {

    //    not passed
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode o = l1;
        ListNode l1n = null;
        ListNode l2n = null;
        while (l1 != null || l2 != null) {
            if (l1.next != null && l2.next != null) {
                l1n = l1.next;
                l2n = l2.next;
                l1.next = l2;
                l2.next = l1n;
                l1.next = l2n;
                l1 = l1n;
                l2 = l2n;
            }
            if (l1.next == null) {
                break;
            }
            if (l1.next != null && l2.next == null) {
                l1n = l1.next;
                l1.next = l2;
                l2.next = l1n;
                break;
            }
        }
        return o;
    }

    //卧槽，返回结果要排序，不是拉链式合并！！ 不过这个方法也锻炼了递归技能
//Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode o = l1;
        ListNode l1n = null;
        ListNode l2n = null;
        if (l1 != null && l2 != null) {
            l1n = l1.next;
            l2n = l2.next;
            l1.next = l2;
            if (l1n != null) {
                l2.next = l1n;
            }
            mergeTwoLists2(l1n, l2n);
        }
        return o;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode o = new ListNode(0);
        ListNode c = o;
        while (null != l1 || null != l2) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    c.next = l1;
                    l1 = l1.next;
                } else {
                    c.next = l2;
                    l2 = l2.next;
                }
                c = c.next;
            } else if (l1 != null) {
                c.next = l1;
                break;
            } else if (l2 != null) {
                c.next = l2;
                break;
            } else {
                break;
            }
        }
        return o.next;
    }

    //    Input: 1->2->4, 1->3->4
//    Output: 1->1->2->3->4->4
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        a1.next = new ListNode(2);
        a1.next.next = new ListNode(4);
        a1.next.next.next = new ListNode(6);
        ListNode b1 = new ListNode(1);
        b1.next = new ListNode(3);
        b1.next.next = new ListNode(7);
        b1.next.next.next = new ListNode(10);
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
        ListNode r = new A0021MergeTwoSortedLists().mergeTwoLists(a1, b1);
        while (r != null) {
            System.out.printf("%d ", r.val);
            System.out.println();
            r = r.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}