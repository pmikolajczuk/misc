package pl.mikolaj.old.javafunctional.combinatorpattern;

import java.time.LocalDate;

import static pl.mikolaj.old.javafunctional.combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+03333333",
                LocalDate.parse("2004-03-06")
        );

        //System.out.println(new CustomerValidatorService().isValid(customer));

        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);
    }
}

