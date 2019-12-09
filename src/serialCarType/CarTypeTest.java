package serialCarType;

import java.io.*;

public class CarTypeTest {
    private File file;
    private CarType one;
    private CarType two;
    private CarType three;

    public static void main(String[] args) {

        new CarTypeTest().start(); // выходим из статического метода
    }

    private void start(){
        createCars();  // создаем 3 экземпляра класса CarType
        recordCars();  // сериализуем их в файл
        loadCars();  // десериализуем объекты из файла и выполняем условия задания
    }
    private void createCars() {
        one = new CarType(115, "Opel", new String[]{"Bluetooth, premium sound system, usb port"});
        two = new CarType(150, "Ford", new String[]{"Keyless start, remote start, navigation system"});
        three = new CarType(175, "Lexus", new String[]{"HomeLink, adaptive cruise control, leather seats"});
    }
    private void recordCars() {
        file = new File("файл_cars.ser");
        try {  // обрабатываем IOException блоком try/catch
            FileOutputStream fs = new FileOutputStream(file);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void loadCars(){
        try {  // // обрабатываем IOException блоком try/catch
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream(file));
            CarType returnOne = (CarType) oi.readObject();
            CarType returnTwo= (CarType) oi.readObject();
            CarType returnThree = (CarType) oi.readObject();

            System.out.println(returnOne.getPower());
            System.out.println(returnTwo.getBrand());
            System.out.println(returnThree.getOptions());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
