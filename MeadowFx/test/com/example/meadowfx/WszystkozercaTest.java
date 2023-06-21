package com.example.meadowfx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WszystkozercaTest {

    private Wszystkozerca wszystkożerca;
    private List<Roslinozerca> listaRoślinożerców;
    private List<Wszystkozerca> listaWszystkożerców;
    private List<Jadalna> listaJadalnych;
    private List<Trujaca> listaTrujących;
    private List<List<String>> mapa;

    @BeforeEach
    public void setUp() {
        wszystkożerca = new Wszystkozerca();
        listaRoślinożerców = new ArrayList<>();
        listaWszystkożerców = new ArrayList<>();
        listaJadalnych = new ArrayList<>();
        listaTrujących = new ArrayList<>();
        mapa = new ArrayList<>();

        // Ustawienie mapy (przykładowe wymiary 5x5)
        for (int i = 0; i < 5; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                row.add("X");
            }
            mapa.add(row);
        }
    }


    @Test
    public void testCzyZabity() {
        // Sprawdzenie początkowego stanu zabity
        Assertions.assertFalse(wszystkożerca.czyZabity());

        // Zabij wszystkożercę
        wszystkożerca.zabiJ();

        // Sprawdzenie, czy stan zabity został zmieniony
        Assertions.assertTrue(wszystkożerca.czyZabity());
    }
    @Test
    public void testKonstruktor() {
        Assertions.assertEquals("J", wszystkożerca.symbol);
        Assertions.assertEquals(30, wszystkożerca.obrazenia);
        Assertions.assertEquals(100, wszystkożerca.życie);
        Assertions.assertEquals("Jez", wszystkożerca.nazwa);
        Assertions.assertFalse(wszystkożerca.czyZabity());
    }

    @Test
    public void testZadajObrazeniaRoślinożercy() {
        Roslinozerca roślinożerca = new Roslinozerca();
        roślinożerca.życie = 50;
        wszystkożerca.listaRoślinożerców = new ArrayList<>();
        wszystkożerca.listaRoślinożerców.add(roślinożerca);

        wszystkożerca.zadajObrazenia(roślinożerca, 30);

        Assertions.assertEquals(20, roślinożerca.życie);
        Assertions.assertEquals(1, wszystkożerca.listaRoślinożerców.size());
    }
    @Test
    public void testZadajObrazeniaMięsożercy() {
        Miesozerca mięsożerca = new Miesozerca();
        mięsożerca.życie = 50;
        wszystkożerca.listaWszystkożerców = new ArrayList<>();
        wszystkożerca.zadajObrazenia(mięsożerca, 30);
        Assertions.assertEquals(20, mięsożerca.życie);
    }
}
