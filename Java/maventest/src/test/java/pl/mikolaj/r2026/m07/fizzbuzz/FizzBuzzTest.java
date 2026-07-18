package pl.mikolaj.r2026.m07.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    void usingIntStream1() {
        fizzBuzz.usingIntStream1();
    }

    @Test
    void usingCustomMap3() {
        fizzBuzz.usingCustomMap3();
    }

    @Test
    void usingCustomMap2() {
        fizzBuzz.usingCustomMap2();
    }

    @Test
    void usingCustomMap1() {
        fizzBuzz.usingCustomMap1();
    }


    @Test
    void simpleForLoop3() {
        fizzBuzz.simpleForLoop3();
    }

    @Test
    void simpleForLoop2() {
        fizzBuzz.simpleForLoop2();
    }

    @Test
    void simpleForLoop1() {
        fizzBuzz.simpleForLoop1();
    }
}