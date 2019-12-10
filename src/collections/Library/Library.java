package collections.Library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Library {

    private ArrayList<Book> booksList = new ArrayList<>();  // список книг будем хранить в ArrayList

    public static void main(String[] args) {
        new Library().start(); // для удоства работы с переменными и методами выходми из static метода
    }

    private void start() {

        getBook();  // сначала получим книгу из списка книг
        System.out.println(booksList);
        Collections.sort(booksList); // Сортировка по алфавиту, при помощи Comparable
        System.out.println("Сортировка по алфавиту, при помощи Comparable - " + booksList);
        System.out.println();

        RatingBook rb = new RatingBook();
        Collections.sort(booksList, rb); // Сортировка по рейтингу, при помощи Comparator
        System.out.println("Сортировка по рейтингу, при помощи Comparator - " + booksList);
        System.out.println();

        HashSet<Book> set = new HashSet<>();
        set.addAll(booksList); // Сортировка без дубликатов, при помощи HashSet
        System.out.println("Сортировка без дубликатов, при помощи HashSet - "+set);
        System.out.println();

        TreeSet<Book> treeList = new TreeSet<>();
        treeList.addAll(booksList); // Сортировка по алфавиту при помощи TreeSet
        System.out.println("Сортировка по алфавиту при помощи TreeSet - "+treeList);
        System.out.println();

        AuthorBook ab = new AuthorBook();
        TreeSet<Book> treeAuthor = new TreeSet<>(ab);
        treeAuthor.addAll(booksList); // Сортировка по авторам при помощи TreeSet
        System.out.println("Сортировка по авторам при помощи TreeSet - "+treeAuthor);
    }

    public class AuthorBook implements Comparator<Book> {  // вложенный класс, реализующий Comparator
        public int compare(Book a,Book b){
            return a.getAuthor().compareTo(b.getAuthor());  // сравнение производим по автору
        }
    }

    public class RatingBook implements Comparator<Book> {
        public int compare(Book a, Book b){
            return a.getRating().compareTo(b.getRating());
        }
    }


    private void getBook() {
        File file = new File("src/collections/Список_книг.txt"); // указываем путь к файлу со списком книг
        try{  // т.к. по указанному адресу файла может не оказаться, обрабатываем возможное IOException блоком try/catch
            BufferedReader reader = new BufferedReader (new FileReader(file)); //
            String line = null;
            while((line=reader.readLine())!=null){ // до тех пор, пока файл не останется пустым
                addBook(line); // передаем считанную строку в метод addBook
            }
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
    private void addBook(String lineOfBook){
        String[] token = lineOfBook.split("/");  // разделяем строку по указанному символу, записываем
                                                       // в отдельные элемента массива
        Book myBook = new Book(token[0],token[1],token[2]); // передаем элементы массива в конструктора класса Book
        booksList.add(myBook); // добавляем новую книгу в booksList
    }
}
