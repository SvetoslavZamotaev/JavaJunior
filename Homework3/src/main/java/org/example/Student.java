package org.example;

import java.io.Serializable;

public class Student implements Serializable {

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    String name;

    int age;

    transient double GPA;

    @Override
    public String toString() {
        return "Student have these fields: " +
                "name='" + name + '\'' +
                ", age=" + age +
                ", GPA=" + GPA;
    }
}
