package helpToStudy.Coacher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Coacher {

    //  задания для отработки интересующих навыков должны быть сохранены заранее в файлах txt
    private String[] tasks = {"бинарный поиск.txt", "запись_извлечение_текста.txt","многопоточность.txt",
            "подписка на событие.txt","поиск в ширину.txt","рекурсия.txt","сериализация.txt","создание массива.txt","выбор_задания.txt","сортировка книг.txt","сохранение.txt","подключение к JDBC.txt"};


    public static void main(String[] args) {
        new Coacher().go();
    }
    private void go() {
        int num = (int)(Math.random()*tasks.length);  // получаем псевдослучайное число
                                                      // от 0 до числа = количеству заданий -1
        String doToday = "задания для проектов/"+tasks[num];  // подставляем полученное число вместо индекса массива
        System.out.println("Сегодня создай программу, которая выполняет условие задачи \"" + doToday + "\":");
        File file = new File(doToday);  // файл указывает путь до интересующего нас файла, но не представляет сам файл
        try {  // обрабатывает IOException блоком try/catch
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line=reader.readLine())!=null){  // считываем задание из файла, пока line не примет значение null
                System.out.println(line);  // выводим каждую строку на экран
            }
        }catch(IOException ex){
            System.out.println(ex);
        }
    }

}
