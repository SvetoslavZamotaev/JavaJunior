package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Course course = new Course("testing",4);

        add(course);
        System.out.println(read(1));
        course.setTitle("updating");
        update(course);
        delete(course);

    }
    public static void delete(Course course){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure()
                .build();
        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(course);
        session.getTransaction().commit();
        session.close();
    }

    public static void add(Course course){
        Course result = course;

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure()
                .build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(result);
        session.getTransaction().commit();
        session.close();
    }

    public static String read( int id){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure()
                .build();
        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Course course = session.get(Course.class, id);
        session.getTransaction().commit();
        session.close();
        return course.toString();
    }

    public static void update(Course course){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure()
                .build();
        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(course);
        session.getTransaction().commit();
        session.close();
    }
}