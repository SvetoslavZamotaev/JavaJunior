package ru.geekbrains.lesson1.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryV2 {

    public static void main(String[] args) {

        Book book1 = new Book("Война и мир", "Лев Толстой", 1869);
        List<Book> books = new ArrayList<>();
        books.add(new Book("Преступление и наказание", "Фёдор Достоевский", 1866));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(book1);
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));

        // Поиск книг, написанных автором
        List<Book> authorBooks  = books.stream()
                        .filter(book -> "Лев Толстой".equals(book.getAuthor())).toList();
        System.out.println("Лев Толстой: " + authorBooks);

        Book book2 = authorBooks.get(0);
        System.out.println(book1.equals(book2));

        // Поиск книг, изданных после 1866
        List<Book> booksAfterYear = books.stream()
                .filter(book -> book.getYear() > 1866).toList();

        System.out.println("Книги после 1866: " + booksAfterYear);


        List<String> uniqueTitles = books.stream()
                        .map(Book::getTitle).distinct().toList();
        System.out.println("Наименования книг: " + uniqueTitles);

    }

}
