package inheritance.ZooManager;


public class Dog extends Animal { //расширяем абстрактный класс Animal
    private String name;  //  у класса Dog есть переменная name

    public Dog(String name){  // Обязываем указывать имя экземпляра класса Dog при создании
        this.name = name;
    }

    public void feed() {  // переопределяем метод feed() конкретно под вид животного
        System.out.println("Собаке " + name + " добавлен корм в миску");
    }

    public String toString() { // переопределим метод toString, чтобы возвращался не номер объекта, а переменная name
        return name;
    }
}
