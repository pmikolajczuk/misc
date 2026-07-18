package pl.mikolaj.old.john.generics;

import pl.mikolaj.old.john.Animal;
import pl.mikolaj.old.john.Cat;

import java.util.ArrayList;
import java.util.List;

public class GenericsMain {

    public static void main(String[] args) {
        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        printList(catList);
    }

    private static void printList(List<? extends Animal> myList) {
        System.out.println();
    }

    private static <T, V> T shout(T thingToShout, V otherThing) {
        System.out.println(thingToShout + "!!!!!");
        System.out.println(otherThing + "!!!!!");

        return thingToShout;
    }


}
