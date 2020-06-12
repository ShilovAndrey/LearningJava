package multithreading.account.philosopher;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {

    private Semaphore sem;
    private int num = 0;

    public Philosopher(Semaphore sem) {
        this.sem = sem;
    }

    public void run() {
        try {
            while (num < 3) {
                sem.acquire();
                System.out.println("Философ "+Thread.currentThread().getName()+" сел за стол");
                Thread.sleep(500);
                num++;
                System.out.println("Философ "+Thread.currentThread().getName()+" встал из-за стола");
                sem.release();
                Thread.sleep(1000);
            }
        }catch(InterruptedException ie){
            System.out.println(ie);
        }

    }
}
