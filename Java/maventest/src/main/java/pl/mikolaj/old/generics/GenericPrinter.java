package pl.mikolaj.old.generics;

public class GenericPrinter<T extends Number> {
    T value;

    public GenericPrinter(T value) {
        this.value = value;
    }

    public void print() {
        System.out.print(value);
    }
}
