import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class A0146LRUCache {
    class LRUCache {

        int size = 0;
        int capacity;
        Map<Integer, ListNode2> map = new HashMap<>();
        ListNode2 first;
        ListNode2 last;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            ListNode2 node = map.get(key);
            if (node == null) {
                return -1;
            }
            //move node to first
            if (node != first) {
                //if node = last, update last
                if(node==last){
                    last=node.pre;
                }else {
                    node.next.pre = node.pre;
                }
                node.pre.next = node.next;
                node.next = first;
                first.pre = node;
                node.pre = null;
                first=node;
            }

            return first.val;
        }

        public void put(int key, int value) {
            ListNode2 newNode = new ListNode2(key, value);
            if (first == null && last == null) {
                first = newNode;
                last = newNode;
                size++;
                map.put(key, newNode);
            } else {
                //if map already has key
                if(map.containsKey(key)){
                    map.get(key).val=value;
                    this.get(key);
                }else {
                    //add first
                    first.pre = newNode;
                    newNode.next = first;
                    first = newNode;
                    size++;
                    if (size == capacity + 1) {
                        //remove last
                        map.remove(last.key);
                        last = last.pre;
                        last.next = null;
                        size--;
                    }
                    map.put(key, newNode);
                }
            }
        }
    }


    public class ListNode2 {
        int key;
        int val;
        ListNode2 pre;
        ListNode2 next;

        ListNode2(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache;
//        ["LRUCache","get","put","get","put","put","get","get"]
//[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]

        lruCache = new A0146LRUCache().new LRUCache(2);
        lruCache.get(2);
        lruCache.put(2,6);
        lruCache.get(1);
        lruCache.put(1,5);
        lruCache.put(1,2);
        lruCache.get(1);
        lruCache.get(2);

//        ["LRUCache","put","get","put","get","get"]
//[[1],[2,1],[2],[3,2],[2],[3]]
        lruCache = new A0146LRUCache().new LRUCache(1);
        lruCache.put(2,1);
        lruCache.get(2);
        lruCache.put(3,2);
        lruCache.get(2);
        lruCache.get(3);

        //["LRUCache","put","put","get","put","get","put","get","get","get"]
//        [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        lruCache = new A0146LRUCache().new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
