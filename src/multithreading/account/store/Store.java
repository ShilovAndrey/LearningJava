package multithreading.account.store;

public class Store {

    private int product = 0;

    public synchronized void get(){
        while(product<1){
            try {
                wait();
            }catch(InterruptedException ie){
                System.out.println(ie);
            }
        }
        product--;
        System.out.println("Покупатель забрал 1 товар. На складе осталось "+product);
        notify();
    }

    public synchronized  void put(){
        while(product>2){
            try{
                wait();
            }catch(InterruptedException ie){
                System.out.println(ie);
            }
        }
        product++;
        System.out.println("Поставщик добавил 1 единицу товара на склад. На складе "+product);
        notify();
    }
}
