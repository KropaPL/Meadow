package com.example.meadowfx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TrujacaTest {

    private Trujaca trująca;
    private List<List<String>> mapa;

    @BeforeEach
    public void setUp() {
        trująca = new Trujaca();
        mapa = new ArrayList<>();
    }

    @Test
    public void testSetListaMuchomorkow() {
        List<Trujaca> listaMuchomora = new ArrayList<>();
        Trujaca muchomor1 = new Trujaca();
        Trujaca muchomor2 = new Trujaca();
        listaMuchomora.add(muchomor1);
        listaMuchomora.add(muchomor2);

        trująca.setListaMuchomorkow(listaMuchomora);

        Assertions.assertEquals(listaMuchomora, Trujaca.listaMuchomorow);
    }

}
