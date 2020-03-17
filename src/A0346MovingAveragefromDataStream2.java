import java.util.Deque;
import java.util.LinkedList;

public class A0346MovingAveragefromDataStream2 {

    //    array version
    class MovingAverage {

        int size;
        double sum = 0;
        int[] array;
        int point = 0;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;
            array = new int[size];
        }

        public double next(int val) {
            int mod = ++point % size;
            sum -= array[mod];
            array[mod] = val;
            sum += val;
            return sum / (point >= size ? size : point);
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
        System.out.println(d / i);
        MovingAverage movingAverage = new A0346MovingAveragefromDataStream2().new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }
}
