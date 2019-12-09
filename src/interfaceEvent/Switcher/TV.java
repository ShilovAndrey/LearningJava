package interfaceEvent.Switcher;

public class TV implements Electricity{  // реализует интерфейс Electricity

    private String name;
    public TV(String name){
        this.name = name;
    }

    public void tvOn() {
        System.out.println("Телефизор включился");
    }
    public void electricityOn() {
        tvOn(); // при подаче электричества вызываем функцию tvOn(), чтобы объект класса включился автоматически
    }

    public String toString() {
        return name;
    }
}

