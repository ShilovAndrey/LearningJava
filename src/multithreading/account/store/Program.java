package multithreading.account.store;

public class Program {

    public static void main(String[] args) {

        Store store = new Store();

        new Thread(new Customer(store)).start();
        new Thread(new Producer(store)).start();
    }
}
