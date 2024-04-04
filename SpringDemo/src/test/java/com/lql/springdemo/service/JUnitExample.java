package com.lql.springdemo.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class JUnitExample {

    @BeforeAll
    static void setup() {
        System.out.println("Before All");

    }
    @BeforeEach
    void beforeEach() {
        System.out.println("Before Each");
    }

    @AfterEach
     void clean() {
        System.out.println("After Each");
    }
    @AfterAll
    static void tearDown() {
        System.out.println("After All");

    }

    @Test
    void assertions() {
        int[] numbers = {0, 1, 2, 3, 4};


        assertTrue(numbers[0] % 2 == 0);
        assertEquals(numbers[0], numbers[2]);
        assertNotEquals(numbers[0], numbers[2]);
        assertSame(numbers[0], numbers[2]);

        assertAll(
                () -> assertEquals(numbers[0], 1),
                () -> assertEquals(numbers[3], 3),
                () -> assertEquals(numbers[4], 1)
        );
        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            throw new UnsupportedOperationException("Not supported");
        });
        assertEquals("Not supported", exception.getMessage());
    }
    @ParameterizedTest(name = "{0} is an odd number")
    @ValueSource(ints = {1, 3, 5, 6, 15})
    void oddNumberCheck(int number) {
        assertTrue(Numbers.isOdd(number));
    }

    @ParameterizedTest(name = "{0} is an odd number")
    @MethodSource(value = "randomNumbers")
    void oddNumberChecker2(int number) {
        assertTrue(Numbers.isOdd(number));
    }


    // array, list, stream, iterator
    static int[] randomNumbers() {
        return IntStream.range(1, 10)
                .map(i ->(int)(Math.random() * 100))
                .toArray();
    }

}
class Numbers {
    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}