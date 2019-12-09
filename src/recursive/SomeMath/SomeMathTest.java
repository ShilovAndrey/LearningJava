package recursive.SomeMath;

import java.util.ArrayList;

public class SomeMathTest {

    public static void main(String[] args) {
        SomeMath calc = new SomeMath();
        long factorial = calc.factor(5);  // вызываем функцию для определения факториала переданного аргумента
        System.out.println("факториал = "+factorial);  // выводем полученный результат
        calc.countDown(3);  // вызываем функцию обратного отсчёта от переданного в качестве аргумента числа
        ArrayList<Integer> numList = new ArrayList<>();  // создаем список чисел
        calc.fillInList(numList);  // наполняем список псевдослучайными числами
        System.out.println(numList);  // выводим получившийся список на экран
        int sum = calc.sumList(numList);  // вызываем метод для подсчета суммы элементов списка
        System.out.println(sum);
        ArrayList<Integer> figures = new ArrayList<>();
        calc.fillInList(figures);  // наполняем список псевдослучайными числами
        System.out.println(figures);
        int max = calc.maxNum(figures);  // вызываем метод для оределения наибольшего элемента в списке
        System.out.println(max); 
    }
}
