package example0;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class LatchesDemo {
    public static void main(String[] args) throws InterruptedException {
        final int SPORTSMAN_AMOUNT = 3;
        CyclicBarrier barrier = new CyclicBarrier(SPORTSMAN_AMOUNT);
        CountDownLatch count = new CountDownLatch(SPORTSMAN_AMOUNT);
        Random r = new Random(37);

        System.out.println("Sportsman! Please, go to start position!");
        for (int i = 0; i != SPORTSMAN_AMOUNT; i++) {
            new Sportsman(barrier, r, count);
        }
        count.await();
        System.out.println("All sportsman running!");
    }
    static class Sportsman extends Thread {
        CyclicBarrier barrier;
        int sleep;
        CountDownLatch c;

        public Sportsman(CyclicBarrier barrier, Random r, CountDownLatch count) {
            this.c = count;
            sleep = r.nextInt(5000);
            this.barrier = barrier;
            start();
        }

        @Override
        public void run() {
            try {
                System.out.printf("%s : I will sleep: %d%n", getName(), sleep);
                sleep(sleep);
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.printf("%s  ==> RUN!%n", getName());
            c.countDown();
        }
    }
}
