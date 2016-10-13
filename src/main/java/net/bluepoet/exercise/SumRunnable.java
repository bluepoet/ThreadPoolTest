package net.bluepoet.exercise;

/**
 * Created by bluepoet on 2016. 10. 4..
 */
class SumRunnable implements Runnable {
    private int from;
    private int to;

    public SumRunnable(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        int sum = 0;
        for(int i=from; i<=to; i++) {
            sum += i;

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("sum : " + sum);
    }
}
