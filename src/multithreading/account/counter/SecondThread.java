package multithreading.account.counter;

public class SecondThread implements Runnable {

    private boolean isActive = true;

    public void disActice() {
        isActive = false;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName());
        int counter = 1;
        while (isActive) {
            System.out.println("counter = " + counter++);
            try {
                Thread.sleep(400);
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }
        System.out.println(Thread.currentThread().getName() + " has been finished");
    }
}
