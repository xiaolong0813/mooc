import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUnSafeExam {

    private int cnt = 0;

    public void add() {
        cnt ++;
    }

    public int getCnt() {
        return cnt;
    }


    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        ThreadUnSafeExam exam = new ThreadUnSafeExam();
        final CountDownLatch latch = new CountDownLatch(threadSize);

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            service.execute(() -> {
                exam.add();
                latch.countDown();});
        }
        latch.await();
        service.shutdown();
        System.out.println(exam.getCnt());
    }
}
