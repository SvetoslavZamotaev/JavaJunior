package ru.geekbrains.lesson2.task3.models;


import ru.geekbrains.lesson2.task3.Column;

import java.util.UUID;

@ru.geekbrains.lesson2.task3.Entity
public class Entity {

    @Column(name = "id", primaryKey = true)
    private UUID id;

}
