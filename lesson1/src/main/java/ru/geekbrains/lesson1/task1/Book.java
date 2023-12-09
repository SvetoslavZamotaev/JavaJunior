package ru.geekbrains.lesson1.task1;

public class Book {

    //region Конструкторы

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    //endregion

    //region Методы

    @Override
    public String toString() {
        return "Book{" +
                "Наименование: '" + title + '\'' +
                ", Автор: '" + author + '\'' +
                ", Год издания: " + year +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    //endregion

    //region Поля

    /**
     * Наименование
     */
    private final String title;

    /**
     * Автор
     */
    private final String author;

    /**
     * Год издания
     */
    private final int year;

    //endregion

}
