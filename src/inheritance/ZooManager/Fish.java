package inheritance.ZooManager;

public class Fish extends Animal {  // расширяем абстрактный класс Animal
    private String name;  //  у класса Dog есть переменная name

    public Fish(String name){  // обязываем указывать имя экземпляра класса Fish при создании
        this.name = name;
    }

    public void feed() { // переопределяем метод feed() конкретно под вид животного
        System.out.println("В аквариум рыбы " + name + " насыпали корм для рыб");
    }

    public String toString() { // переопределим метод toString, чтобы возвращался не номер объекта, а переменная name
        return name;
    }
}
