package interfaceEvent.Switcher;

public class Recorder implements Electricity { // реализует интерфейс Electricity

    private String name;

    public Recorder(String name){
        this.name = name;
    }

    public void recorderOn() {
        System.out.println("Магнитафон заработал");
    }
    public void electricityOn() {
        recorderOn(); // при подаче электричества вызываем функцию tvOn(), чтобы объект класса включился автоматически
    }
    public String toString(){
        return name;
    }
}
