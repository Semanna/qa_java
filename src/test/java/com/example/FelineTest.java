package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class FelineTest {
    @Test
    void shouldEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        List<String> actual = feline.eatMeat();

        assertIterableEquals(expected, actual);
    }

    @Test
    void shoulReturnFamily() {
        Feline feline = new Feline();

        String actual = feline.getFamily();

        assertEquals("Кошачьи", actual);
    }

    @Test
    void shouldReturnKittens() {
        Feline feline = new Feline();

        int actual = feline.getKittens();

        assertEquals(1, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    void shouldReturnKittensCount(int count) {
        Feline feline = new Feline();

        int actual = feline.getKittens(count);

        assertEquals(count, actual);
    }
}