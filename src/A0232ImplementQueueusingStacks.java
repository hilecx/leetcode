import java.util.Stack;

public class A0232ImplementQueueusingStacks {
    class MyQueue {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Integer front = null;
        /**
         * Initialize your data structure here.
         */
        public MyQueue() {

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stack1.push(x);
            if(front==null){
                front=x;
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }

            int r = stack2.pop();
            if(stack2.isEmpty()){
                front=null;
            }else {
                front = stack2.peek();
            }
            while(!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return r;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return front;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return front==null;
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
