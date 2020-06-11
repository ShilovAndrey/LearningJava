package multithreading.account.account;

public class TimAndKate implements Runnable{
    private Account account = new Account();

    public static void main(String[] args) {
        TimAndKate ram = new TimAndKate();
        Thread one = new Thread(ram);  // создаем 2 потока с одной общей задачей  Runnable.
        Thread two = new Thread(ram);
        one.setName("Tim");  // даем имена потокам
        two.setName("Kate");
        one.start();  // запускаем потоки
        two.start();
    }

    public void run() {  // метод интерфейса Runnable. В него помещается задача, которую должен выполнить поток.
        for(int i =0;i<=10;i++){
            makeWithdrawal(10);  // поток зацикливается и при каждой итерации пытается снять деньги со счета
            if(account.getBalance()<0){  // после снятия поток еще раз проверяет баланс, чтобы убедиться,
                                         // что лимит не превышен
                System.out.println("Внимание, лимит превышен");
            }
        }
    }

    private synchronized void makeWithdrawal(int amount){  // synchronized блокирует начало выполнения метода поток,
                                                           // если метод уже выполняется другим потоком
        if(account.getBalance()>=amount){  // проверяем баланс, если средств хватает...
            System.out.println(Thread.currentThread() + " пытается снять деньги");
            System.out.println(Thread.currentThread() + " засыпает");
            try{
                Thread.sleep(500);  // приостанавливаем поток, чтобы другий поток мог поработал
            }catch(InterruptedException ie){
                System.out.println(ie);
            }
            System.out.println(Thread.currentThread() + "просыпается и продолжает снятие денег");
            account.withdraw(amount);
            System.out.println(Thread.currentThread() + " завершает транзакцию");
        }else{  // если денег недостаточно, то просто выводим сообщение
            System.out.println("Извините, " + Thread.currentThread() + " на Вашем счете недостаточно средств. Сейчас на Вашем счете " + account.getBalance());
        }
    }

}
