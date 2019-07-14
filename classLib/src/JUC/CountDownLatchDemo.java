package JUC;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    private void go() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        // 创建三个线程并启动。
        new Thread(new Task(latch), "Thread1").start();
        Thread.sleep(1000);
        new Thread(new Task(latch), "Thread2").start();
        Thread.sleep(1000);
        new Thread(new Task(latch), "Thread3").start();
        latch.await();
        System.out.println("所有线程已到达，主线程开始执行 " + System.currentTimeMillis() + " ms");
    }

    class Task implements Runnable {
        private CountDownLatch latch;
        public Task(CountDownLatch countDownLatch) {
            this.latch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + " 已经到达 " + System.currentTimeMillis() + " ms");
            latch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new CountDownLatchDemo().go();
    }
}
