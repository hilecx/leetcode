import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/531/week-4/3313/
public class C004FirstUniqueNumber {
    class FirstUnique {
        Map<Integer, DeListNode> map = new HashMap<>();
        DeListNode head = new DeListNode(0);
        DeListNode tail = new DeListNode(0);
        public FirstUnique(int[] nums) {
            head.next=tail;
            tail.pre=head;
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }

        }

        public int showFirstUnique() {
            return tail.pre.val==0?-1:tail.pre.val;
        }

        public void add(int value) {
            DeListNode c = map.get(value);
            if(c!=null){
                remove(c);
            }else {
                DeListNode newNode = new DeListNode(value);
                newNode.pre = head;
                newNode.next = head.next;
//                if (newNode.next != null) {
                    newNode.next.pre = newNode;
//                }
                head.next = newNode;
                map.put(newNode.val,newNode);
            }
        }

        private void remove(DeListNode deListNode){
            deListNode.pre.next=deListNode.next;
//            if(deListNode.next!=null){
                deListNode.next.pre=deListNode.pre;
//            }
            deListNode.pre=null;
            deListNode.next=null;
        }
    }

    class DeListNode {
        int val;
        DeListNode pre;
        DeListNode next;

        DeListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        FirstUnique firstUnique = new C004FirstUniqueNumber().new FirstUnique(new int[]{2,3,5});
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        System.out.println(firstUnique.showFirstUnique()); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        System.out.println(firstUnique.showFirstUnique()); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique()); // return -1
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique()); // return -1
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique()); // return -1
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique()); // return -1
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique()); // return -1
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        System.out.println(firstUnique.showFirstUnique()); // return -1
    }
}
