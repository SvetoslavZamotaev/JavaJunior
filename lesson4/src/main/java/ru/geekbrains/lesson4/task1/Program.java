package ru.geekbrains.lesson4.task1;

import ru.geekbrains.lesson4.models.Student;

import java.beans.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Program {

    private final static Random random = new Random();

    /**
     * Задача 1
     * ========
     * <p>
     * Используя SQL, создайте таблицу students с полями id (ключ), name, и age.
     * Реализация подключения к базе данных через JDBC:
     * Напишите Java-код для подключения к базе данных (например, MySQL или PostgreSQL).
     * Реализуйте вставку, чтение, обновление и удаление данных в таблице Students
     * с использованием провайдера JDBC.
     */

    public static void main(String[] args) {

        String url = "jdbc:mysql://students.db:3306/";
        String user = "root";
        String password = "password";

        // Подключение к базе данных
        try(Connection connection = DriverManager.getConnection(url, user, password)){


            // Создание базы данных
            createDatabase(connection);
            System.out.println("Database created successfully");

            // Использование базы данных
            useDatabase(connection);
            System.out.println("Use database successfully");

            // Создание таблицы
            createTable(connection);
            System.out.println("Create table successfully");

            // Добавление данных
            int count = random.nextInt(5, 11);
            for (int i = 0; i < count; i++)
                insertData(connection, Student.create());
            System.out.println("Insert data successfully");

            // Чтение данных
            Collection<Student> students = readData(connection);
            for (var student: students)
                System.out.println(student);
            System.out.println("Read data successfully");

            // Обновление данных
            for (var student: students) {
                student.updateName();
                student.updateAge();
                updateData(connection, student);
            }
            System.out.println("Update data successfully");

            // Чтение данных
            students = readData(connection);
            for (var student: students)
                System.out.println(student);
            System.out.println("Read data successfully");


            // Удаление данных
            for (var student: students)
                deleteData(connection, student.getId());
            System.out.println("Delete data successfully");

            // Закрытие соединения
            //connection.close();
            //System.out.println("Database connection close successfully");
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    //region Вспомогательные методы

    private static void createDatabase(Connection connection) throws SQLException {
        String createDatabaseSQL =  "CREATE DATABASE IF NOT EXISTS studentsDB;";
        try (PreparedStatement statement = connection.prepareStatement(createDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void useDatabase(Connection connection) throws SQLException {
        String useDatabaseSQL =  "USE studentsDB;";
        try (PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS students (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), age INT);";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        }
    }

    /**
     * Добавление данных в таблицу students
     * @param connection Соединение с БД
     * @param student Студент
     * @throws SQLException Исключение при выполнении запроса
     */
    private static void insertData(Connection connection, Student student) throws SQLException {
        String insertDataSQL = "INSERT INTO students (name, age) VALUES (?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(insertDataSQL)) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.executeUpdate();
        }
    }

    /**
     * Чтение данных из таблицы students
     * @param connection Соединение с БД
     * @return Коллекция студентов
     * @throws SQLException Исключение при выполнении запроса
     */
    private static Collection<Student> readData(Connection connection) throws SQLException {
        ArrayList<Student> studentsList = new ArrayList<>();
        String readDataSQL = "SELECT * FROM students;";
        try (PreparedStatement statement = connection.prepareStatement(readDataSQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                studentsList.add(new Student(id, name, age));
            }
            return studentsList;
        }
    }

    /**
     * Обновление данных в таблице students по идентификатору
     * @param connection Соединение с БД
     * @param student Студент
     * @throws SQLException Исключение при выполнении запроса
     */
    private static void updateData(Connection connection, Student student) throws SQLException {
        String updateDataSQL = "UPDATE students SET name=?, age=? WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(updateDataSQL)) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setInt(3, student.getId());
            statement.executeUpdate();
        }
    }

    /**
     * Удаление записи из таблицы students по идентификатору
     * @param connection Соединение с БД
     * @param id Идентификатор записи
     * @throws SQLException Исключение при выполнении запроса
     */
    private static void deleteData(Connection connection, int id) throws SQLException {
        String deleteDataSQL = "DELETE FROM students WHERE id=?;";
        try (PreparedStatement statement = connection.prepareStatement(deleteDataSQL)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }


    //endregion

}
