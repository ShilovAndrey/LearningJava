package binarySearch.GameGuess;

import java.util.Random;
import java.util.Scanner;

public class GameGuess {

    private int[] mass;
    private static int countComputer;  // считает количество попыток, которые сделал компьютер
    private Scanner scan;
    private int compGuess;
    private int low=1;  // обозначает минимальное число, при бинарном поиске
    private int high;  // обозначает минимальное число, при бинарном поиске
    private int mid;  // обозначает середину, при бинарном поиске
    private int marker;
    private int check;
    private static int countPlayer;  // // считает количество попыток, которые сделал игрок
    private int userNum;
    private int ranNum;
    private int maxForComp;  // максимальное число, которое может загадать компьютер

    public void startGame() {  // для запуска игры достаточно вызвать метод start(), который поочередно
                               // вызывает остальные методы
        computerTurn();  // по умолчанию первым число отгадывает компьютер
        System.out.println("Теперь Ваша очередь отгадывать. Постарайтесь победить меня");
        playerTurn();
        compareResults();  // сравниваем результаты
    }

    private void computerTurn() {  // поочередно вызывает все методы, относящиеся к части программы,
                                   // когда число отгадывает компьютер
        compInstructions();  // выводит инструкции
        playerMakeANumber();  // игрок загадывает число
        compGuessNumber();  // компьютер отгадывает число

    }
    private void playerTurn() {// поочередно вызывает все методы, относящиеся к части программы,
                               // когда число отгадывает игрок
        playerInstructions();  // выводит инструкции
        compMakeNumber();      // компьютер загадывает число
        playerGuessNumber();   // игрок отгадывает число
    }

    public void compInstructions() {  // оставляем метод публичным, чтобы можно было дополнительно
                                      // выводить инструкции
        System.out.println("Вы загадываете число, я отгадываю. " +
                "Если я называю число меньше загаданного - введите 'мало', если больше - 'много', если угадал, то" +
                " 'угадал'");
        System.out.println("Введите диапазон, в котором я отгадываю число от 0 до...");

    }

    private void playerMakeANumber() {
        scan = new Scanner(System.in);
        int maxNumForPlayer = scan.nextInt();  // максимальное число, которое может загадать игрок
        System.out.println("Вы указали " + maxNumForPlayer + " элементов. Я отгадываю число от 0 до " + (maxNumForPlayer));
        System.out.println("Загадывайте. У Вас 3 секунды...");
        for (int i = 3; i > 0; i--) {  // обратный отсчет даёт игроку время загадать число
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(i + "...");
        }
        System.out.println();
        System.out.println("Игра началась");
        mass = new int[maxNumForPlayer];  // создается упорядоченный массив из указанного пользователем числа элементов
        for (int i = 0; i < mass.length; i++) {
            mass[i] = i;
        }
    }

    private void compGuessNumber() {  // компьютер отгадывает число
        while (!(check == 2)) {
            compGuess = binary_search();
            check = getScan();  // переменная check принимает значение переменной marker
            countComputer++;  // счётчик попыток компьютера
        }
        System.out.println("Я угадал с попытки №" + countComputer);
    }

    private int binary_search(){
        if(check==0) {  // маркер = 0 только при 1 ходе
            high = mass.length;

        }if (check==-1){  // если было названо число меньше загаданного пользователем
            low=mid+1;    // к названному числу прибавляется 1 и оно становится наименьшим числом в оставшем
                          // упорядоченном массиве
        }else if(check==1){  // если было названо число больше загаданного
            high=mid-1;  // от названного отнимаем 1 и оно становится наибольшим из оставшихся вариантов
        }
        mid = (low + high) / 2;  // вычисляется середина
        compGuess = mass[mid - 1];  // всегда называется число по середина упорядоченного массива
        return compGuess;
    }

    private int getScan () {
        int mark=0;  // ограничивает варианты ответа пользователя
        do {  // выполняемое условие из цикла do/while
            System.out.println("Ваше число " + compGuess + "?");
            System.out.println("Введите 'мало', если больше - 'много', если угадал, то 'угадал'");
            scan = new Scanner(System.in);
            String answer = scan.nextLine();
            if (answer.equalsIgnoreCase("мало")) {
                marker = -1;  // маркер, используемый для оценки ответа игрока
                mark=1;
            } else if (answer.equalsIgnoreCase("много")) {
                marker = 1;
                mark=1;
            } else if (answer.equalsIgnoreCase("угадал")) {
                marker = 2;
                mark=1;
            } else {
                System.out.println("Неправильный ввод");
            }
        }while(!(mark==1));  // программа будет запрашивать пользовательский ввод до тех пор,
                             // пока пользователь не выполнит ввод согласно инструкции
        return marker;
    }

    
    private void playerInstructions() { // оставляем метод публичным, чтобы можно было дополнительно выводить инструкции
        System.out.println("Я загадываю число, Вы отгадываете. " +
                "Если Вы назовете число меньше загаданного - я скажу 'мало', если больше - 'много', если угадали, " +
                "то 'угадали'");
        System.out.println("Введите диапазон, в котором я могу загадать число от 0 до...");
    }

    private void compMakeNumber() {  // // компьютер загадывает число
        maxForComp = scan.nextInt();
        System.out.println("Вы указали " + maxForComp + " элементов. Я загадываю число от 0 до " + (maxForComp));
        ranNum = new Random().nextInt(maxForComp);
        System.out.println("Я загадал число от 0 до " + maxForComp + ". Отгадайте его");
    }

    private void playerGuessNumber() {
        do {  // условие цикла do/while
            System.out.println("Введите число от 0 до " + maxForComp + ":" );
            userNum = scan.nextInt();  // присваиваем переменной userNum результат ввода пользователя

            if (userNum > ranNum) {
                System.out.println("много");
                countPlayer++;
            } else if (userNum < ranNum) {
                System.out.println("мало");
                countPlayer++; // счётчик попыток игрока
            }
        } while (ranNum != userNum);  // игра продолжается, пока игрок не угадает загаданное компьютером число
        countPlayer++; // счётчик попыток игрока
        System.out.println("Браво! Я загадал число " + ranNum + ". Вы отгадали с " + countPlayer + " попытки.");
    }

    private void compareResults() {
        System.out.println("Подведем итоги: ");
        if(countPlayer>countComputer){
            int compWin = countPlayer-countComputer;
            System.out.println("Компьютеру понадобилось на " + compWin + " попытки меньше, чтобы отгадать число. " +
                    "Не расстраивайтесь, это сложный уровень, т.к. компьютер исполльзовал алгоритм бинарного поиска." +
                    "Если будет желание, то я дорабатую программу, чтобы было несколько вариантов сложности");
        }else if(countPlayer<countComputer){
            int playerWin = countComputer-countPlayer;
            System.out.println("Поздравляю! Вам понадобилось на " + playerWin + " попытки меньше, чем копьютеру." +
                    "Вы победили компьютер, который использовал бинарный алгоритм поиска. Можете собой гордиться!" +
                    " Если, конечно, условия игры были равны)");
        }else{
            System.out.println("Почти невероятно, но у Вас ничья. Чтобы определить сильнейшего запустите игру еще раз");
        }
    }
}
