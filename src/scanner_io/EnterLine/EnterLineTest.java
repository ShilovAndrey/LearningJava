package scanner_io.EnterLine;

public class EnterLineTest {  // тестируем работу программы EnterLine

    public static void main(String[] args) {
        EnterLine saver = new EnterLine(); // создаем экземпляр класса EnterLine
        saver.start(); // запускаем программу. Получаем инструкцию и вводим сообщение в консоль
        saver.readFile(); // проверяем содержание файла
    }
}
