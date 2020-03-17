import java.util.Deque;
import java.util.LinkedList;

public class A0346MovingAveragefromDataStream {

//    deque version Runtime: 21 ms, faster than 75.82% of Java online submissions for Moving Average from Data Stream.
    class MovingAverage {

        int size;
        double sum = 0;
        Deque<Double> deque = new LinkedList<>();

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            double valdouble = Double.valueOf(val);
            deque.addFirst(valdouble);
            sum += valdouble;
            if (deque.size() > size) {
                sum -= deque.removeLast();
            }
            return sum/deque.size();
        }
    }

    /**
     * Your MovingAverage object will be instantiated and called as such:
     * MovingAverage obj = new MovingAverage(size);
     * double param_1 = obj.next(val);
     */

    public static void main(String[] args) {
        double d = 3.5;
        int i = 2;
        System.out.println(d/i);
        MovingAverage movingAverage = new A0346MovingAveragefromDataStream().new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }
}
