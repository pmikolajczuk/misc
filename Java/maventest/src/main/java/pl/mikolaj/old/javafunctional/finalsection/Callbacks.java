package pl.mikolaj.old.javafunctional.finalsection;

import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {
        hello("John", null, s -> System.out.println("No last name for " + s));
        hello2("Tom", null, () -> System.out.println("No last name"));
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if(lastName != null) {
            System.out.println(lastName);
        }else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if(lastName != null) {
            System.out.println(lastName);
        }else {
            callback.run();
        }
    }
}
