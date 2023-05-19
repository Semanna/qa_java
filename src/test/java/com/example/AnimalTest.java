package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void shouldReturnFoodForHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Трава", "Различные растения");

        List<String> actual = animal.getFood("Травоядное");

        assertIterableEquals(expected, actual);
    }

    @Test
    void shouldReturnFoodForPredator() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        List<String> actual = animal.getFood("Хищник");

        assertIterableEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionForInvalidKind() {
        Animal animal = new Animal();

        assertThrows(Exception.class, () ->animal.getFood("Invalid"));
    }

    @Test
    void shouldReturnFamily() {
        Animal animal = new Animal();

        assertEquals(
                "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                animal.getFamily());
    }
}