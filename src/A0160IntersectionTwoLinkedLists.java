import java.util.HashSet;
import java.util.Set;

public class A0160IntersectionTwoLinkedLists {

//
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            //pa = pa == null ? headA : pa.next;
            //pb = pb == null ? headB : pb.next;
            //这样可以快速在n+m次后找到无交集的用例，而上面注释的方法要n*m次
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;

    }

    //自己写的双指针法，两个不一样长的link，始终会循环出一个相等点，要么是intersection，要么是最后的null。O(nm)
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        boolean paflag = true;
        boolean pbflag = true;
        while (true) {
            if (pa == pb) {
                return pa;
            }
            pa = pa.next;
            pb = pb.next;
            if (pa == null) {
                pa = paflag ? headB : headA;
                paflag = !paflag;
            }
            if (pb == null) {
                pb = pbflag ? headA : headB;
                pbflag = !pbflag;
            }
            if (pa == headA && pb == headB) {
                break;
            }
        }
        return null;

    }

    //headA循环一次，headB循环交点位置的长度，但是用set很慢
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}
