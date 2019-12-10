package connectJDBC.DBСonnect;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class DBConnect {

    private String url;  // переменная для хранения url
    private String user;  // переменная для хранения user
    private String password;  // переменная для хранения password
    private String driver;  // переменная для хранения driver


    public static void main(String[] args) {
        new DBConnect().go();
    }

    private void go() {
        getData();  // получаем данные из файла Properties, присваиваем их значения нашим переменным
        connectBase();  // подключаемся к БД, использую полученные данные
    }

    private void getData() {
        File file = new File("src/connectJDBC/PropertiesDBData.txt");  // путь к файлу Properties
        Properties prop = new Properties();
        try{  // обрабатываем IOException блоком try/catch
            prop.load(new FileReader(file));
            url=prop.getProperty("dbUrl");
            user=prop.getProperty("dbUser");
            password=prop.getProperty("dbPassword");
            driver=prop.getProperty("dbDriver");
        }catch(IOException ex){
            System.out.println(ex);
        }
    }

    private void connectBase() {
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            Scanner scan = new Scanner(System.in);
            System.out.println("Input product name: ");  // просим пользователя ввести название товара
            String name = scan.nextLine();
            System.out.println("Input product price: ");  // просим пользователя ввести цену товара
            int price = scan.nextInt();
            try (Connection conn = DriverManager.getConnection(url, user, password)) {

                String sqlStatement = "INSERT INTO products (productName,price) VALUES(?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(sqlStatement);
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, price);
                int rows = preparedStatement.executeUpdate();
                System.out.println("updated " + rows + " rows");
                ResultSet resultSet = preparedStatement.executeQuery("Select * from products");
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String product = resultSet.getString(2);
                    int cost = resultSet.getInt(3);
                    System.out.println(id + " " + product + " " + cost);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }



}
