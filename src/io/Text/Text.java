package io.Text;
import java.io.*;

public class Text {


    public static void main(String[] args) {
        File file = new File("Файл_для_текста.txt");  // файл указывает путь к файлу, но не представляет
        // сам файл
        try{  // обрабатываем исключение IOException блоком try/catch
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("Какой цвет получится, если красный и синий?/фиолетовый");
            bw.close();
        }catch(IOException ex){
            System.out.println(ex);
        }

        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line=reader.readLine())!=null){  // считываем построчно пока файл не вернет null
                System.out.println(line);
                String[] lineArr = line.split("/");  // разделяем лексему на 2 предложение. Разделитель символ "/"
                for (String arr:lineArr) {
                    System.out.println(arr);  // выводим на экран кажждый элемент массива

                }
            }
        }catch(IOException ex){
            System.out.println(ex);
        }

    }
}
