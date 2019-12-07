package inheritance.ZooManager;

public abstract class Animal { // класс должен быть абстрактным, чтобы нельзя было создать экзепляров Animal
    public void feed(){ // создаем метод, общий для наследников класса
        System.out.println("Животное покормлено");
    }
}

