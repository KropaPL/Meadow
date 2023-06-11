package com.example.meadowfx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MięsożercaTest {
    private Mięsożerca mięsożerca;
    private List<Roślinożerca> listaRoślinożerców;
    private List<Wszystkożerca> listaWszystkożerców;
    private List<Mięsożerca> listaLisow;
    private List<List<String>> mapa;

    @BeforeEach
    public void setUp() {
        mięsożerca = new Mięsożerca();
        listaRoślinożerców = new ArrayList<>();
        listaWszystkożerców = new ArrayList<>();
        listaLisow = new ArrayList<>();
        mapa = new ArrayList<>();

        // Inicjalizacja mapy (przykładowe wymiary 3x3)
        List<String> row1 = new ArrayList<>();
        row1.add("X");
        row1.add("X");
        row1.add("X");

        List<String> row2 = new ArrayList<>();
        row2.add("X");
        row2.add("X");
        row2.add("X");

        List<String> row3 = new ArrayList<>();
        row3.add("X");
        row3.add("X");
        row3.add("X");

        mapa.add(row1);
        mapa.add(row2);
        mapa.add(row3);

        mięsożerca.listaRoślinożerców = listaRoślinożerców;
        mięsożerca.listaWszystkożerców = listaWszystkożerców;
        mięsożerca.listaLisow = listaLisow;
        mięsożerca.Mapa = mapa;
    }

    @Test
    public void testZadajObrazenia_Roslinozerca() {
        Roślinożerca roślinożerca = new Roślinożerca();
        roślinożerca.x = 1;
        roślinożerca.y = 1;
        roślinożerca.życie = 100;

        listaRoślinożerców.add(roślinożerca);

        mięsożerca.zadajObrazenia(roślinożerca, 50);

        Assertions.assertEquals(50, roślinożerca.życie);
    }

    @Test
    public void testZadajObrazenia_Wszystkożerca() {
        Wszystkożerca wszystkożerca = new Wszystkożerca();
        wszystkożerca.x = 1;
        wszystkożerca.y = 1;
        wszystkożerca.życie = 100;

        listaWszystkożerców.add(wszystkożerca);

        mięsożerca.zadajObrazenia(wszystkożerca, 50);

        Assertions.assertEquals(50, wszystkożerca.życie);
    }

    @Test
    public void testKonstruktor() {
        Assertions.assertEquals("L", mięsożerca.symbol);
        Assertions.assertEquals(50, mięsożerca.obrazenia);
        Assertions.assertEquals(100, mięsożerca.życie);
        Assertions.assertEquals("Lis", mięsożerca.nazwa);
        Assertions.assertFalse(mięsożerca.czyZabity());
    }

    @Test
    public void testCzyZabity() {
        Assertions.assertFalse(mięsożerca.czyZabity());

        mięsożerca.zabiJ();

        Assertions.assertTrue(mięsożerca.czyZabity());
    }
}
