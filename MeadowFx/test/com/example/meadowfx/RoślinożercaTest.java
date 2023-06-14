package com.example.meadowfx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RoślinożercaTest {

    private Roślinożerca roślinożerca;
    private List<List<String>> mapa;
    private List<Roślinożerca> listaRoślinożerców;
    private List<Jadalna> listaJadalnych;
    private List<Trująca> listaTrujących;

    @BeforeEach
    public void setUp() {
        roślinożerca = new Roślinożerca();
        mapa = new ArrayList<>();
        listaRoślinożerców = new ArrayList<>();
        listaJadalnych = new ArrayList<>();
        listaTrujących = new ArrayList<>();
    }

    @Test
    public void testZjedzRoślineJadalną() {
        Jadalna jadalna = new Jadalna();
        List<Jadalna> listaJadalnych = new ArrayList<>();
        listaJadalnych.add(jadalna);
        roślinożerca.listaJadalnych = listaJadalnych;
        roślinożerca.życie += jadalna.regeneracja;
        Assertions.assertEquals(280, roślinożerca.życie);
    }
}
