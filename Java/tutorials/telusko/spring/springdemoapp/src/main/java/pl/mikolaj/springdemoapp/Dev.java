package pl.mikolaj.springdemoapp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Dev {

    private final Computer computer;

    public Dev(@Qualifier("laptop") Computer computer) {
        this.computer = computer;
    }

    public void build(){

        computer.compile();

        System.out.println("Working on Awesome Project");
    }
}
