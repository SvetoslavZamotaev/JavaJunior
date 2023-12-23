package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")

public class Course {

    Course(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

    @Column(name = "title")
    private String title;
    @Column(name = "duration")
    private int duration;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Course(String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
