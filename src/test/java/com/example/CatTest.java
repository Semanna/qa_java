package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @InjectMocks
    private Cat cat;

    @Mock
    Feline feline;

    @Test
    void shouldReturnSound() {
        String actual = cat.getSound();

        assertEquals("Мяу", actual);
    }

    @Test
    void shouldReturnFood() throws Exception {
        List<String> food = List.of("Еда");
        when(feline.eatMeat()).thenReturn(food);

        List<String> actual = cat.getFood();

        assertSame(food, actual);
    }
}