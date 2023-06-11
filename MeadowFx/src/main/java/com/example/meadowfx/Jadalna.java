package com.example.meadowfx;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jadalna extends Roślina {

    int regeneracja;
    public List<List<String>> Mapa;
    public static List<Jadalna> listaGrzybków;

    public Jadalna() {
        this.symbol = "G";
        this.nazwa = "Grzyb";
        this.regeneracja = 50;
        this.wzrost = 1;
        this.listaGrzybków = new ArrayList<>();
    }

    @Override
    public void akcja() {

    }

    public void leczenie() {

    }

    public void setListaGrzybow(List<Jadalna> listaGrzybka){
        this.listaGrzybków = listaGrzybka;
    }
    public List<Jadalna> getListaGrzybow(){
        return this.listaGrzybków;
    }

    public static List<Jadalna> generujNoweGrzybki(List<List<String>> mapa) {
        List<Jadalna> noweGrzybki = new ArrayList<>();

        for (Jadalna grzyb : listaGrzybków) {
            int nowyX = grzyb.x;
            int nowyY = grzyb.y;
            boolean validMove = false;

            while (!validMove) {
                Random generator = new Random();
                int kierunek = generator.nextInt(4); // 0 - góra, 1 - prawo, 2 - dół, 3 - lewo

                Jadalna grzybek = new Jadalna();
                grzybek.symbol = "G"; // Ustaw symbol nowego grzyba

                if (kierunek == 0 && grzyb.x > 0) { // Poruszanie się w górę
                    nowyX = grzyb.x - 1;
                    nowyY = grzyb.y;
                } else if (kierunek == 1 && grzyb.y < mapa.get(0).size() - 1) { // Poruszanie się w prawo
                    nowyX = grzyb.x;
                    nowyY = grzyb.y + 1;
                } else if (kierunek == 2 && grzyb.x < mapa.size() - 1) { // Poruszanie się w dół
                    nowyX = grzyb.x + 1;
                    nowyY = grzyb.y;
                } else if (kierunek == 3 && grzyb.y > 0) { // Poruszanie się w lewo
                    nowyX = grzyb.x;
                    nowyY = grzyb.y - 1;
                }

                // Sprawdzenie, czy nowe współrzędne są już zajęte przez inny obiekt
                if (mapa.get(nowyX).get(nowyY).equals("X")) {
                    grzybek.x = nowyX;
                    grzybek.y = nowyY;
                    mapa.get(nowyX).set(nowyY, grzybek.symbol);

                    noweGrzybki.add(grzybek);
                    validMove = true;
                } else {
                    validMove = true; // Nie twórz nowego grzyba, jeśli nie ma miejsca
                }
            }
        }

        return noweGrzybki;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getRegeneracja() {
        return regeneracja;
    }

    public void setX(int wartosc) {
        this.x += wartosc;
    }

    public void setY(int wartosc) {
        this.y += wartosc;
    }
}
