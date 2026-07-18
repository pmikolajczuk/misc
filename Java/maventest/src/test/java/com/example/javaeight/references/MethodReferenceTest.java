package com.example.javaeight.references;

import org.junit.jupiter.api.Test;

public class MethodReferenceTest {

    @FunctionalInterface
    interface NoiseMaker {
        void noise();
    }

    static void metallicNoise() {
        System.out.println("Kling klang ding");
    }

    @Test
    void testMethodReference() {
        NoiseMaker noiseMaker = MethodReferenceTest::metallicNoise;
        noiseMaker.noise();
    }
}
