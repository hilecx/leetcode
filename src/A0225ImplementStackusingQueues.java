import java.util.LinkedList;
import java.util.Queue;

public class A0225ImplementStackusingQueues {


    class MyStack {

        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue1.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            int t = -1;
            while (true) {
                t = queue1.poll();
                if (queue1.isEmpty()) {
                    break;
                } else {
                    queue2.add(t);
                }
            }
            Queue<Integer> object = queue1;
            queue1 = queue2;
            queue2 = object;
            return t;
        }

        /**
         * Get the top element.
         */
        public int top() {
            int t = -1;
            while (true) {
                t = queue1.poll();
                queue2.add(t);
                if (queue1.isEmpty()) {
                    break;
                }
            }
            Queue<Integer> object = queue1;
            queue1 = queue2;
            queue2 = object;
            return t;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue1.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

}
