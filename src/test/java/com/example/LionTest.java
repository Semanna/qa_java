package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    Feline feline;

    private final static int KITTENS = 20;
    private final static String FOOD = "Food";

    @Test
    void shouldReturnKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);

        lion.feline = feline;
        when(feline.getKittens()).thenReturn(KITTENS);

        int actual = lion.getKittens();

        assertEquals(KITTENS, actual);
    }

    @Test
    void shouldHaveManeWhenMale() throws Exception {
        Lion lion = new Lion("Самец", feline);

        assertTrue(lion.doesHaveMane());
    }

    @Test
    void shouldNotHaveManeWhenFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);

        assertFalse(lion.doesHaveMane());
    }

    @Test
    void shouldThrowExceptionWhenInvalidSex() {
        assertThrows(Exception.class, () -> new Lion("invalid", feline));
    }

    @Test
    void shouldReturnFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> food = List.of(FOOD);

        when(feline.getFood("Хищник")).thenReturn(food);

        List<String> actual = lion.getFood();

        assertSame(food, actual);
    }
}