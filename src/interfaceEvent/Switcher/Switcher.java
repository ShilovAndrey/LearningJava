package interfaceEvent.Switcher;

import java.util.ArrayList;

public class Switcher {  //создаем класс выключатель
    private ArrayList<Electricity> itemList = new ArrayList<>();  // переменная список для слушателей
                                                                  // событий типа Electricity

    public void addListener(Electricity a){ // добавляет предмет в список слушателей
        itemList.add(a);
        System.out.println(a + " добавлен в список");

    }

    public void removeListeners(Electricity b){ // удаляет предмет из списка слушателей
        itemList.remove(b);
        System.out.println(b + " был удален из списка");
    }

    public void switchOn(){  // включает выключатель
        if(itemList.isEmpty()){
            System.out.println("Список пуст");
        }else{
            for(Electricity a:itemList){ // ток подается всем предметам, подключенным к сети
                a.electricityOn();
                System.out.println(a+" включился");
            }
        }
    }
    public void showListeners() {  // дает возможность просмотреть список слушателей
        System.out.println("В списке слушателей сейчас: ");
        for(Electricity a:itemList){
            System.out.println(a + " ");
        }
    }
}
