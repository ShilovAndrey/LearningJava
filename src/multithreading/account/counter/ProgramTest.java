package multithreading.account.counter;

public class ProgramTest {

    public static void main(String[] args) {

        SecondThread second = new SecondThread();
        new Thread(second, "Second Thread").start();
        try {
            Thread.sleep(2000);
            second.disActice();
            Thread.sleep(1500);
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
        System.out.println("Main thread finished...");
    }
}
