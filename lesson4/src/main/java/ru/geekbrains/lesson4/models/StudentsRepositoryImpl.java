package ru.geekbrains.lesson4.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class StudentsRepositoryImpl implements StudentsRepository{
    @Override
    public void add(Student item) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "password";

        // Подключение к базе данных
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            String insertDataSQL = "INSERT INTO students (name, age) VALUES (?, ?);";
            try (PreparedStatement statement = connection.prepareStatement(insertDataSQL)) {
                statement.setString(1, item.getName());
                statement.setInt(2, item.getAge());
                statement.executeUpdate();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student item) {

    }

    @Override
    public void delete(Student item) {

    }

    @Override
    public Student getById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Student> getAll() {
        return null;
    }
}
