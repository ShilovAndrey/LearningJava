package multithreading.account.store;

public class Customer implements Runnable {
    private Store store;

    public Customer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            store.get();
        }
    }
}
