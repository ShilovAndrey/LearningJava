package multithreading.account.account;

public class Account {

    private int balance = 150;  // баланс  счета

    public int getBalance() {
        return balance;
    }

    public void withdraw(int x){
        balance = balance - x;
    }
}
