import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class A0703KthLargestElementStream {

    class KthLargest {

        int[] nums;
        int k;
        List<Integer> list = new LinkedList<>();

        public KthLargest(int k, int[] nums) {
            this.nums = nums;
            this.k = k;
            Arrays.sort(nums);
            int i = nums.length - k >= 0 ? nums.length - k : 0;
            for (; i < nums.length; i++) {
                list.add(nums[i]);
            }


        }

        public int add(int val) {
            Iterator<Integer> iterator = list.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                int v = iterator.next();
                if (val <= v) {
                    break;
                }
                i++;
            }
            list.add(i, val);
            if (list.size() > k) {
                list.remove(0);
                return list.get(0);
            } else {
                return list.get(0);
            }
        }


    }


    public static void main(String[] args) {
        KthLargest k3 = new A0703KthLargestElementStream().new KthLargest(2, new int[]{0});
        System.out.println(k3.add(-1));
        KthLargest k2 = new A0703KthLargestElementStream().new KthLargest(1, new int[]{});
        System.out.println(k2.add(3));

        KthLargest k = new A0703KthLargestElementStream().new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(10));
        System.out.println(k.add(9));
        System.out.println(k.add(4));
    }


    class KthLargest2 {

        int[] nums;
        int k;
        ListNode head;

        public KthLargest2(int k, int[] nums) {
            this.nums = nums;
            this.k = k;
            Arrays.sort(nums);
            head = new ListNode(null);
            ListNode l = head;
            int i = nums.length - k >= 0 ? nums.length - k : 0;
            for (; i < nums.length; i++) {
                l.next = new ListNode(nums[i]);
                l = l.next;
            }
            head = head.next;
        }

        public int add(int val) {
            if (head == null) {
                head = new ListNode(val);
                return val;
            }
            if (val < head.val) {
                return head.val;
            } else {
                ListNode p = head;
                while (p != null) {
                    if (p.next == null || p.next.val >= val) {
                        ListNode tmp = p.next;
                        p.next = new ListNode(val);
                        p.next.next = tmp;
                        break;
                    } else {
                        p = p.next;
                    }
                }
                head = head.next;
                return head.val;
            }

        }


        class ListNode {
            Integer val;
            ListNode next;

            ListNode(Integer x) {
                val = x;
            }
        }
    }
}
