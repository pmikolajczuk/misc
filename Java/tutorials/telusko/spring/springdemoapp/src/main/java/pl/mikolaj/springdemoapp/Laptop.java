package pl.mikolaj.springdemoapp;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {

    @Override
    public void compile() {
        System.out.println("Compiling code on Laptop");
    }
}
