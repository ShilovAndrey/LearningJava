package interfaceEvent.Switcher;

public class Main {

    public static void main(String[] args) {
        Switcher sw = new Switcher();
        TV tv = new TV("tv");
        TV tv2 = new TV("tv2");
        Recorder recorder = new Recorder("recorder");
        sw.addListener(tv); // добавляем объект класс TV в список слушателей
        sw.addListener(recorder); // добавляем объект класс Recorder в список слушателей
        sw.addListener(new Electricity() {
            @Override
            public void electricityOn() {
                System.out.println("анонимный класс");
            }
        });
        sw.addListener(()-> System.out.println("лямбда"));
        sw.switchOn();
        sw.removeListeners(tv2);
        sw.showListeners();

    }
}
