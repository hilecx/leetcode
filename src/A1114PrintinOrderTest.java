import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class A1114PrintinOrderTest {

    ReentrantLock lock = new ReentrantLock();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    {
        lock.lock();
    }
    public void first(Runnable printFirst) throws InterruptedException {
        System.out.println(lock.getHoldCount());
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
        printSecond.run();
    }

    public static void main(String[] args) throws InterruptedException {
        A1114PrintinOrderTest a1114PrintinOrderTest = new A1114PrintinOrderTest();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,5,1000L,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));

        Runnable a = new Runnable(){
            @Override
            public void run() {
                try {
                    a1114PrintinOrderTest.second(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("2rd");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable b = new Runnable(){
            @Override
            public void run() {
                try {
                    a1114PrintinOrderTest.first(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("1st");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        executor.execute(b);
        executor.execute(a);
    }
}

