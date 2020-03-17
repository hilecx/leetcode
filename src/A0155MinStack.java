
import java.util.*;

public class A0155MinStack {
    //这题做法非常巧妙，需要找到规律
    class MinStack2 {

        private Stack<int[]> stack = new Stack<>();

        public MinStack2() { }


        public void push(int x) {

            /* If the stack is empty, then the min value
             * must just be the first value we add. */
            if (stack.isEmpty()) {
                stack.push(new int[]{x, x});
                return;
            }

            int currentMin = stack.peek()[1];
            stack.push(new int[]{x, Math.min(x, currentMin)});
        }


        public void pop() {
            stack.pop();
        }


        public int top() {
            return stack.peek()[0];
        }


        public int getMin() {
            return stack.peek()[1];
        }
    }


    class MyInt{
        public Integer i;

        public MyInt(Integer i) {
            this.i = i;
        }
    }

    class MinStack {

        List<MyInt> list = new ArrayList<>();
        PriorityQueue<MyInt> queue = new PriorityQueue<>((MyInt o1, MyInt o2)->(o1.i>o2.i?1:-1));

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            MyInt myInt = new MyInt(x);
            list.add(myInt);
            queue.add(myInt);
        }

        public void pop() {
            MyInt myInt = list.remove(list.size()-1);
            queue.remove(myInt);
        }

        public int top() {
            return list.get(list.size()-1).i;
        }

        public int getMin() {
            return queue.peek().i;
        }
    }
}
