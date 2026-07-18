package pl.mikolaj.old.john;

import pl.mikolaj.old.john.lambdas.Printable;

import java.io.Serializable;

public class Cat extends Animal implements Printable, Serializable {

    private String name;
    private int age;

    public Cat() {

    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void makeNoise() {
        System.out.println("Meow");
    }

    @Override
    public String print(String prefix, String suffix) {
        System.out.println("Meow");
        return "";
    }

}
