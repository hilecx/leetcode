import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class A1114PrintinOrder {
//这个是错误解法
//    正确解法是用设置一个 int，然后用while true控制，太简单懒得写了
    class Foo {
        ReentrantLock lock = new ReentrantLock();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            lock.lock();
            printFirst.run();
            condition2.signal();
            lock.unlock();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            try {
                condition2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.unlock();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            lock.lock();
            condition3.signal();
            lock.unlock();

        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            try {
                condition3.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            lock.unlock();

        }
    }
}
