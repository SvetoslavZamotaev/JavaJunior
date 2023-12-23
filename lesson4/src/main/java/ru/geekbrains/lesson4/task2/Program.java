package ru.geekbrains.lesson4.task2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.lesson4.models.Student;

public class Program
{
    /**
     * Задача 2
     * ========
     * <p>
     * Настройте Hibernate, связав его с вашей базой данных.
     * Создайте класс Student в Java, аннотируя его как сущность Hibernate.
     * Используя Hibernate, реализуйте вставку, чтение, обновление и
     * удаление данных в таблице students.
     * Обратите внимание на использование сессий и транзакций в Hibernate.
     */

    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()){

            // Создание сессии
            Session session = sessionFactory.getCurrentSession();

            // Начало транзакции
            session.beginTransaction();

            // Создание объекта
            Student student = Student.create();
            session.save(student);
            System.out.println("Object student save successfully");

            // Чтение объекта из базы данных
            Student retrievedStudent = session.get(Student.class, student.getId());
            System.out.println("Object student retrieved successfully");
            System.out.println("Retrieved student object: " + retrievedStudent);

            // Обновление объекта
            retrievedStudent.updateName();
            retrievedStudent.updateAge();
            session.update(retrievedStudent);
            System.out.println("Object student update successfully");


            session.delete(retrievedStudent);
            System.out.println("Object student delete successfully");


            session.getTransaction().commit();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
