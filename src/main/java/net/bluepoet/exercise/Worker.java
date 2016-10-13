package net.bluepoet.exercise;

import java.util.concurrent.BlockingQueue;

/**
 * Created by bluepoet on 2016. 10. 4..
 */
class Worker implements Runnable {
    private BlockingQueue<Integer> queue;
    private int totalCount = 0;

    @Override
    public void run() {
        while (this.queue.isEmpty() == false) {
            int number = queue.poll();

            System.out.println(Thread.currentThread().getName() + "]startNumber :: " + number);
            if (number % 3 == 0) {
                System.out.println(Thread.currentThread().getName() + "]Divided Number ::" + number);
                totalCount++;
            }

            System.out.println(Thread.currentThread().getName() + "]totalCount :: " + totalCount);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
}
