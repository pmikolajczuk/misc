package pl.mikolaj.old.john.generics;

import pl.mikolaj.old.john.Animal;

import java.io.Serializable;

public class GenericPrinter <T extends Animal & Serializable>{

    private T thingToPrint;

    public GenericPrinter(T thingToPrint) {
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        thingToPrint.eat();
        System.out.println(thingToPrint);
    }
}
