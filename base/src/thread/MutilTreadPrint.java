/**
 * @author ning_mx
 * @date 16:51 2022/3/18
 * @desc
 */
package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ning_mx
 * @date 2022/3/18
 */
public class MutilTreadPrint {
    public static void main(String[] args) throws InterruptedException {
        //printABC(3);
        // printABC2(3);
        // printABC3(3);
         //printABC4(10);
        printAN();
    }
    /**
     * 解法一：
     * 三个线程交替打印A、B、C,打印k次
     */
    public static void printABC(int k) {
        AtomicInteger times  = new AtomicInteger(0) ;
        new MyThread("A", 0,times).start();
        new MyThread("B", 1,times).start();
        new MyThread("C", 2,times).start();
    }

    /**
     * 解法二:join
     * 阻塞主线程，等待子线程执行完
     */
    public static void printABC2(int k) throws InterruptedException {

        Thread a = new Thread(() -> {
            System.out.println("A");
        });
        a.start();
        a.join();
        Thread b = new Thread(() -> {
            System.out.println("B");
        });
        b.start();
        b.join();

        Thread c = new Thread(() -> {
            System.out.println("C");
        });
        c.start();
        c.join();

    }

    /**
     * 解法三：单线程线程池
     */
    public static void printABC3(int k) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Thread a = new Thread(() -> {
            System.out.print("A");
        });

        Thread b = new Thread(() -> {
            System.out.print("B");
        });
        Thread c = new Thread(() -> {
            System.out.print("C");
        });
        while (k > 0) {
            k--;
            executorService.submit(a);
            executorService.submit(b);
            executorService.submit(c);
        }

    }
    private static Thread a ,c  , b ;
    /**
     * 解法四：LockSupport  线程通知
     */
    public static void printABC4(final int k) {

        a = new Thread(() -> {
             for (int i = 1; i <= k; i++)  {
                  System.out.print("A");
                  LockSupport.unpark(b);
                  LockSupport.park();
             }
        });

        b = new Thread(() -> {
            for (int i = 1; i <= k; i++)  {
                LockSupport.park();
                System.out.print("B");
                LockSupport.unpark(c);
            }
        });
        c = new Thread(() -> {
            for (int i = 1; i <= k; i++)  {
                LockSupport.park();
                System.out.print("C");
                LockSupport.unpark(a);
            }
        });
        a.start();
        b.start();
        c.start();

    }
    public static class MyThread extends Thread {

        private String word ;
        private int flag ;
        private AtomicInteger times ;

        public MyThread(String word, int flag,AtomicInteger times) {
            this.word = word;
            this.flag = flag;
            this.times = times;
        }

        @Override
        public void run() {
            int k = 10 ;
            while (k>0){
                if (flag % 3 == times.get()){
                    System.out.print(word);
                    times.incrementAndGet();
                    if(times.get()==3){
                        times.set(0);
                    }
                    k--;
                }
            }
        }

    }

    /**
     * 交替输出 1A2B3C4D...26Z
     */
    public static void printAN() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Thread a = new Thread(() -> {
                System.out.print(1);
        });
        Thread b = new Thread(() -> {
                System.out.print((char)'A');
        });
        for (int i = 0; i < 26; i++) {
            executorService.submit(a);
            executorService.submit(b);
        }
    }
}
