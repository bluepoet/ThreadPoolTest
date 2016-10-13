package net.bluepoet.exercise;

import java.util.concurrent.*;

/**
 * Created by bluepoet on 2016. 10. 3..
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        final int THREAD_POOL_COUNT = 2;
        final BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();

        initQueue(queue);

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_COUNT);
        Worker worker = new Worker();

        for (int i = 0; i < 2; i++) {
            worker.setQueue(queue);
            executor.execute(worker);
        }
//        SumRunnable sumRunnable = new SumRunnable(1, 100);
//        executor.execute(sumRunnable);

        executor.shutdown();

        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        }catch(InterruptedException e) {
            System.out.println("not endede!!!!!");
            e.printStackTrace();
        }

        if(executor.isTerminated()) {
            System.out.println("aaa");
        }else{
            System.out.println("bbb");
        }
    }

    private static void initQueue(BlockingQueue<Integer> queue) throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            queue.put(i);
        }
    }

    private static BlockingQueue<Integer> cloneQueue(BlockingQueue<Integer> queue) throws InterruptedException {
        BlockingQueue<Integer> cloneQueue = new LinkedBlockingQueue<Integer>();
        while (!queue.isEmpty()) {
            cloneQueue.put(queue.poll());
        }

        return cloneQueue;
    }
}

