package com.example.meadowfx;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Trujaca extends Roslina {
    int trucizna;
    int sytosc = 80;
    int wiek;
    int Maxwiek;
    public List<List<String>> Mapa;
    public static List<Trujaca> listaMuchomorow;

    public Trujaca() {
        this.symbol = "M";
        this.nazwa = "Muchomor";
        this.trucizna = -5;
        this.wzrost = 1;
        this.Maxwiek = 6;
    }

    public void zwiekszWiek(){
        wiek+=1;
    }

    public void setListaMuchomorkow(List<Trujaca> listaMuchomora){
        this.listaMuchomorow = listaMuchomora;
    }
    public static List<Trujaca> generujNoweMuchomory(List<List<String>> mapa) {
        List<Trujaca> noweMuchomory = new ArrayList<>();

        for (Trujaca muchomor : listaMuchomorow) {
            int nowyX = muchomor.x;
            int nowyY = muchomor.y;
            boolean validMove = false;

            while (!validMove) {
                Random generator = new Random();
                int kierunek = generator.nextInt(4); // 0 - góra, 1 - prawo, 2 - dół, 3 - lewo

                Trujaca muchomorek = new Trujaca();
                muchomorek.symbol = "M"; // Ustaw symbol nowego muchomora

                if (kierunek == 0 && muchomor.x > 0) { // Poruszanie się w górę
                    nowyX = muchomor.x - 1;
                    nowyY = muchomor.y;
                } else if (kierunek == 1 && muchomor.y < mapa.get(0).size() - 1) { // Poruszanie się w prawo
                    nowyX = muchomor.x;
                    nowyY = muchomor.y + 1;
                } else if (kierunek == 2 && muchomor.x < mapa.size() - 1) { // Poruszanie się w dół
                    nowyX = muchomor.x + 1;
                    nowyY = muchomor.y;
                } else if (kierunek == 3 && muchomor.y > 0) { // Poruszanie się w lewo
                    nowyX = muchomor.x;
                    nowyY = muchomor.y - 1;
                }

                // Sprawdzenie, czy nowe współrzędne są już zajęte przez inny obiekt
                if (mapa.get(nowyX).get(nowyY).equals("X")) {
                    muchomorek.x = nowyX;
                    muchomorek.y = nowyY;
                    mapa.get(nowyX).set(nowyY, muchomorek.symbol);

                    noweMuchomory.add(muchomorek);
                    validMove = true;
                } else {
                    validMove = true; // Nie twórz nowego muchomora, jeśli nie ma miejsca
                }
            }
        }

        return noweMuchomory;
    }

}
