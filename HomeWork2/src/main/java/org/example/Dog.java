package org.example;

public class Dog extends Animal{
    private int weight;


    public Dog(String name, int age,int weight) {
        super(name, age);
        this.weight = weight;
    }

    public void letsPlay(){
        System.out.println("Lets play with me!");
    }

    public void makeSound(){
        System.out.println("Bark!");
    }
}
