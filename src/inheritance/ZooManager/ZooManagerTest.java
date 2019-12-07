package inheritance.ZooManager;

public class ZooManagerTest {
    public static void main(String[] args) {
        ZooManager boris = new ZooManager("Борис");  // принимаем на работу Бориса на должность менеджер зоопарка
        Dog kimi = new Dog("Кими"); // завозим первую собаку по кличке Кими
        Fish hey = new Fish("Хей"); // завозим первую рыбку Хей
        Fish dor = new Fish("Дор"); // завозим рыбку Дор
        Fish lana = new Fish("Лана"); // завозим рыбку Лана
        Dog mintu = new Dog("Минту"); // завозим собаку Минту
        boris.addAnimalFeedList(kimi); // добавляем животных в список на кормление
        boris.addAnimalFeedList(hey);
        boris.addAnimalFeedList(dor);
        boris.addAnimalFeedList(lana);
        boris.addAnimalFeedList(mintu);
        boris.checkFeedList(); // Борис проверяет всех ли добавил в список
        boris.feedAnimals(); // юорис кормит животных
        boris.removeAnimalFeedList(dor); // рыбку Дор перекормили посетители, поэтому Борис временно удалил ее из списка
    }
}
