package recursive.SomeMath;

import java.util.ArrayList;


public class SomeMath {

    public long factor(long i){ // метод принимает число и возвращает факторил этого числа
        if(i==1){  // базовый вариант исхода событий
            return 1;
        }else{
            return i*factor(i-1);  // рекурсия
        }
    }
    public void countDown(int count){
        if(count<1){  // базовый вариант исхода событий
            System.out.println("Отсчёт завершен");
        }else{
            System.out.println(count);
            int rest = count -1;
            try{  // обрабатываем InterruptedException блоком try/catch
                Thread.sleep(1000);  // останавливаем поток выполнения на 1 сек
            }catch(InterruptedException ex){
                System.out.println(ex);
            }
            countDown(rest);  // рекурсия
        }
    }
    public int sumList(ArrayList<Integer> sumList){
        if(sumList.isEmpty()){  // если список пуст, то возвращаем 0. Это базовое условие
            return 0;
        }else{
            int x=sumList.get(0);
            sumList.remove(0);
            return x+sumList(sumList);  // рекурсия
        }
    }
    public ArrayList fillInList(ArrayList<Integer> list){
        int a = (int)(Math.random()*50);  // формируем случайное число от 0 до 49
        int b = (int)(Math.random()*50);
        int c = (int)(Math.random()*50);
        int d = (int)(Math.random()*50);
        int e = (int)(Math.random()*50);
        int f = (int)(Math.random()*50);
        int g = (int)(Math.random()*50);
        list.add(a);  // добавляем сформированное число в список
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        list.add(g);
        return list;
    }
    public int maxNum(ArrayList<Integer> figuresList){
        if(figuresList.size()==2){  // базовое условие
            if(figuresList.get(0)>figuresList.get(1)){
                int x=figuresList.get(0);
                return x;  // возвращаем наибольший элемент из 2
            }else{
                int y = figuresList.get(1);
                return y;  // возвращаем наибольший элемент из 2
            }
        }
        if(figuresList.get(0)<figuresList.get(1)){  // если в списке элементов больше, чем в базовом условии
            figuresList.remove(0);  // удаляем меньший элемент из списка
            int i = maxNum(figuresList);  // рекурсия без меньшего элемента
            return i;
        }else{
            figuresList.remove(1);
            int j = maxNum(figuresList);
            return j;
        }
    }

}
