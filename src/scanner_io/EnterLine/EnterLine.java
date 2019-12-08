package scanner_io.EnterLine;

import java.io.*; // импортируем пакет java.io.* для использования классов библиотеки(File,FileWriter,FileReader,
                  // BufferedWriter, BufferedReader))
import java.util.Scanner; // импортируем класс Scanner из пакета util для использования консольного ввода

public class EnterLine {

    private String line;  // у класса есть приватная переменная типа String. В нее мы сохраним результат ввода пользователя
    private File file;  // переменная отражает адрес (путь) к текстовому файлу(но не сам файл), в который мы запишем строку


    public void start() {  // метод вывода инструкций и запускает метод getMessage
        System.out.println("Введите текстовое сообщение, которое будет сохранено в файл");
        getMessage(); // обработку ввода выводим в отдельный метод
    }

    private void getMessage() { // обрабатываем пользовательский ввод. Т.к. программа работает только
                                // с 1 конкретной строкой - используем методы без параметров
        Scanner scan = new Scanner(System.in);
        line = scan.nextLine();
        saveLine();  // сохраняем строку в файл в отдельном методе
    }

    private void saveLine(){  // сохраняем строку в файл

        file = new File("сохранение_строки.txt");  // указываем имя файла.Если файла нет, то он будет создан
                                                             // в корне проекта автоматически
        try { // запись в файл может вызвать IOException, поэтому обрабатываем блоком try/catch
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(line);
            writer.close();
        }catch(IOException ex){
            System.out.println(ex);
        }
    }

    public void readFile() {  // метод дает возможность читать сохраненную в файле строку
        try{ // чтение из файла может вызвать IOException, поэтому обрабатываем блоком try/catch
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String poem = null;
            while((poem=reader.readLine())!=null){  // выводим на экран, пока в файле есть строки
                System.out.println(poem);
            }
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
}
