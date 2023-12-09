package ru.geekbrains.lesson1.task1;


    /*
        Задача 1: Реализовать систему учета книг в библиотеке. У каждой книги есть название,
        автор и год издания. Необходимо создать список книг и выполнить следующие действия:

        1. Обычный способ:
            - Найти все книги, написанные определенным автором (например, "John Doe").
            - Найти все книги, изданные после определенного года (например, 2010).
            - Найти все уникальные названия книг в библиотеке.

        2. Использование лямбда-выражений:
            - Те же самые задачи, но с использованием лямбда-выражений и
              Stream API для более компактного и выразительного кода.
        */

import java.util.ArrayList;
import java.util.List;

public class Library {

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        books.add(new Book("Преступление и наказание", "Фёдор Достоевский", 1866));
        books.add(new Book("Евгений Онегин", "Александр Пушкин", 1833));
        books.add(new Book("Война и мир", "Лев Толстой", 1869));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967));

        // Поиск книг, написанных автором
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books){
            if ("Лев Толстой".equals(book.getAuthor())) {
                authorBooks.add(book);
            }
        }
        System.out.println("Лев Толстой: " + authorBooks);

        // Поиск книг, изданных после 1866
        List<Book> booksAfterYear = new ArrayList<>();
        for (Book book : books){
            if (book.getYear() > 1866) {
                booksAfterYear.add(book);
            }
        }
        System.out.println("Книги после 1866: " + booksAfterYear);

        List<String> uniqueTitles = new ArrayList<>();
        for (Book book: books) {
            if (!uniqueTitles.contains(book.getTitle())){
                uniqueTitles.add(book.getTitle());
            }
        }

        System.out.println("Наименования книг: " + uniqueTitles);

    }

}
