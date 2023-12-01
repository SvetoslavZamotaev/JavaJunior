package org.example;

public class Cat extends Animal {
    private String color;


    public Cat(String name, int age,String color) {
        super(name, age);
        this.color = color;
    }

    public void goingCrazy(){
        System.out.println("InRage mod!!! (*_*)");
    }
}
