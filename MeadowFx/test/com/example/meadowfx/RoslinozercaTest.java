package com.example.meadowfx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RoslinozercaTest {

    private Roslinozerca roślinożerca;
    private List<List<String>> mapa;
    private List<Roslinozerca> listaRoślinożerców;
    private List<Jadalna> listaJadalnych;
    private List<Trujaca> listaTrujących;

    @BeforeEach
    public void setUp() {
        roślinożerca = new Roslinozerca();
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
