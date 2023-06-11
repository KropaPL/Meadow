package com.example.meadowfx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TrującaTest {

    private Trująca trująca;
    private List<List<String>> mapa;

    @BeforeEach
    public void setUp() {
        trująca = new Trująca();
        mapa = new ArrayList<>();
    }

    @Test
    public void testSetListaMuchomorkow() {
        List<Trująca> listaMuchomora = new ArrayList<>();
        Trująca muchomor1 = new Trująca();
        Trująca muchomor2 = new Trująca();
        listaMuchomora.add(muchomor1);
        listaMuchomora.add(muchomor2);

        trująca.setListaMuchomorkow(listaMuchomora);

        Assertions.assertEquals(listaMuchomora, Trująca.listaMuchomorow);
    }

}
