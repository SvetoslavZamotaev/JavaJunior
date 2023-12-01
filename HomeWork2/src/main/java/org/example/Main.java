package org.example;

public class Main {
    public static void main(String[] args) {
        Animal[] array = {new Dog("Bob",2,3)
                ,new Cat("kitty",3,"white")
                ,new Cat("Tom",5,"blue")};


        for (Animal animal : array) {
            Class<?> clazz = animal.getClass();
            if(clazz.equals(Dog.class)){
                ((Dog) animal).makeSound();
            }
        }
    }
}