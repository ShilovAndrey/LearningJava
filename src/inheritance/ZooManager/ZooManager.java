package inheritance.ZooManager;

import java.util.ArrayList;

public class ZooManager {
    private ArrayList<Animal> feedList = new ArrayList<>(); // у менеджера есть список животных, которых необходимо покормить
    private String name;

    public ZooManager(String name){ // у каждого менеджера зоопарка есть имя
        this.name = name;
    }

    public void addAnimalFeedList(Animal a){ // менеджер может добавлять в список разных животных
        feedList.add(a);
        System.out.println("Менеджер " + name + " добавил " + a + " в список на кормление");
    }

    public void removeAnimalFeedList(Animal b){
        if(feedList.isEmpty()){
            System.out.println("Невозможно удалить указанное животное, т.к. список уже пуст");
        }else{
            feedList.remove(b);
            System.out.println("Менеджер "+name + " удалил " + b + " из списка на кормление");
        }
    }
    // дадим возможность менеджеру проверять наполненность текущего списка
    public void checkFeedList() { // можно в метод передавать лист и использовать заполнитель, но мы минимизируем
        if(feedList.isEmpty()){  //впешательство клиента в код
            System.out.println("Список на кормление животных пуст");
        }else{
            System.out.println("Сейчас в списке на кормление: ");
            for(Animal z: feedList){
                System.out.println(z + " ");
            }
        }
    }
    // добавляем сам метод кормления животных
    public void feedAnimals(){
        if(feedList.isEmpty()){
            System.out.println("Список пуст");
        }else{
            for (Animal v: feedList) { // в списке итерационно вызывается метод feed() для каждого животного индивидуально
                v.feed();
            }
        }
    }
}
