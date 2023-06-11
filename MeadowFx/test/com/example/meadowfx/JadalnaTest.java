package com.example.meadowfx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JadalnaTest {

    private Jadalna jadalna;
    private List<List<String>> mapa;

    @BeforeEach
    public void setUp() {
        jadalna = new Jadalna();
        mapa = new ArrayList<>();
    }

    @Test
    public void testGetX() {
        jadalna.x = 5;

        Assertions.assertEquals(5, jadalna.getX());
    }

    @Test
    public void testGetY() {
        jadalna.y = 3;

        Assertions.assertEquals(3, jadalna.getY());
    }

    @Test
    public void testGetRegeneracja() {
        jadalna.regeneracja = 50;

        Assertions.assertEquals(50, jadalna.getRegeneracja());
    }

    @Test
    public void testSetX() {
        jadalna.setX(2);

        Assertions.assertEquals(2, jadalna.x);
    }

    @Test
    public void testSetY() {
        jadalna.setY(-1);

        Assertions.assertEquals(-1, jadalna.y);
    }
}
