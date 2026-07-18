package pl.mikolaj.old.javafunctional.functionalinterface;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _Predicate {

    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("123"));
        System.out.println(phoneNumberPredicate.test("1234567890"));
        System.out.println(containsNumber3.test("12abc1245"));
        System.out.println(
                phoneNumberPredicate.and(containsNumber3).test("1234567890")
        );
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.matches("^\\d{10}$");
    }

    static Predicate<String> phoneNumberPredicate = phoneNumber -> phoneNumber.matches("^\\d{10}$");

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.matches("^.*3.*$");
}
