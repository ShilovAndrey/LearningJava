package multithreading.account.philosopher;

import java.util.concurrent.Semaphore;

public class ProgramTest {

    public static void main(String[] args) {

        Semaphore sem = new Semaphore(2);
        new Thread(new Philosopher(sem),"Парменид").start();
        new Thread(new Philosopher(sem),"Аристотель").start();
        new Thread(new Philosopher(sem),"Марк Аврелий").start();
        new Thread(new Philosopher(sem),"Фридрих Ницше").start();
        new Thread(new Philosopher(sem),"Платон").start();
    }
}
