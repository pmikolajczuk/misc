package pl.mikolaj.old.john.optionals;

import pl.mikolaj.old.john.Cat;

import java.util.Optional;

public class OptionalTutorial {
    public static void main(String[] args) {

        Optional<Cat> optionalCat = findCatByName("fred");

        System.out.println(optionalCat.map(Cat::getAge).orElse(0));
    }

    private static Optional<Cat> findCatByName(String name) {
        Cat cat = new Cat(name, 3);
        return Optional.ofNullable(cat);
    }
}
