package collections.Library;

public class Book implements Comparable{ // реализуем интерфейс Comparable для переопределения метода compareTo

    private String title;
    private String author;
    private String rating;

    public int compareTo(Object o){  // переопределяем метод интерфейса Comparable
        Book b = (Book)o;
        return getTitle().compareTo(b.getTitle());  // указываем методу Collections.sort(), что сортируем
                                                    // по переменной title
    }

    public Book(String title,String author, String rating){ // переопределяем конструктор, исходя из количества
                                                            // приватных переменных класса
        this.title=title;
        this.author=author;
        this.rating=rating;
    }

    public String getTitle(){
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getRating() {
        return rating;
    }

    public String toString(){
        return title;  // переопределяем метод toString, чтобы при выводе на экран указывалось значение переменной title
    }

    public boolean equals(Object o){  // переопределяем, книги сраванивались по значению переменной title

        Book a = (Book)o;
        return getTitle().equals(a.getTitle());
    }
    public int hashCode(){
        return title.hashCode();  // также при переопределении используем одну с equals() переменную
    }
}
