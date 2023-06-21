package com.example.meadowfx;

import java.util.List;
import java.util.Random;

public class Miesozerca extends Zwierze {
    int obrazenia;
    int glod = 0;
    int ofiary = 0;
    private boolean zabity;

    public List<Miesozerca> listaLisow;
    public List<Roslinozerca> listaRoślinożerców;
    public List<Wszystkozerca> listaWszystkożerców;
    public List<List<String>> Mapa;


    public void wzmozGlod(){
        glod+=3;
    }
    public Miesozerca() {
        this.symbol = "L";
        this.obrazenia = 50;
        this.życie = 100;
        this.nazwa = "Lis";
        this.zabity = false;

    }

    public void poruszajSie() {
        int nowyX = x;
        int nowyY = y;
        boolean znalezionoWolneMiejsce = false;

        while (!znalezionoWolneMiejsce) {
            Random generator = new Random();
            int kierunek = generator.nextInt(4); // 0 - góra, 1 - prawo, 2 - dół, 3 - lewo

            if (kierunek == 0 && x > 0) { // Poruszanie się w górę
                nowyX = x - 1;
                nowyY = y;
            } else if (kierunek == 1 && y < Mapa.get(0).size() - 1) { // Poruszanie się w prawo
                nowyX = x;
                nowyY = y + 1;
            } else if (kierunek == 2 && x < Mapa.size() - 1) { // Poruszanie się w dół
                nowyX = x + 1;
                nowyY = y;
            } else if (kierunek == 3 && y > 0) { // Poruszanie się w lewo
                nowyX = x;
                nowyY = y - 1;
            }

            // Sprawdzenie, czy nowe współrzędne są już zajęte przez inny obiekt
            if (Mapa.get(nowyX).get(nowyY).equals("X")) {
                // Usunięcie lisów z poprzednich współrzędnych
                Mapa.get(x).set(y, "X");

                // Aktualizacja współrzędnych lisów
                x = nowyX;
                y = nowyY;

                // Umieszczenie lisów na nowych współrzędnych
                Mapa.get(x).set(y, symbol);

                znalezionoWolneMiejsce = true;
            } else {
                znalezionoWolneMiejsce = true;
            }
        }
    }


    public void zadajObrazenia(Zwierze zwierzę, int obrazenia) {
        if (zwierzę instanceof Roslinozerca) {
            Roslinozerca roślinożerca = (Roslinozerca) zwierzę;
            roślinożerca.życie -= obrazenia;

            if (roślinożerca.życie <= 0) {
                Mapa.get(roślinożerca.x).set(roślinożerca.y, "X");
                listaRoślinożerców.remove(roślinożerca);
                ofiary++;
                glod = 0;
            }
        } else if (zwierzę instanceof Wszystkozerca) {
            Wszystkozerca wszystkożerca = (Wszystkozerca) zwierzę;
            wszystkożerca.życie -= obrazenia;

            if (wszystkożerca.życie <= 0) {
                Mapa.get(wszystkożerca.x).set(wszystkożerca.y, "X");
                listaWszystkożerców.remove(wszystkożerca);
                ofiary++;
                glod = 0;
            }
        }
    }

    public void atakujZwierzęta() {
        for (Miesozerca lis : listaLisow) {
            int aktualnyX = lis.x;
            int aktualnyY = lis.y;

            // Sprawdzanie pobliskich obiektów wokół lisa
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int sąsiedniX = aktualnyX + i;
                    int sąsiedniY = aktualnyY + j;

                    // Sprawdzenie, czy sąsiednie współrzędne są w obrębie mapy
                    if (sąsiedniX >= 0 && sąsiedniX < Mapa.size() && sąsiedniY >= 0 && sąsiedniY < Mapa.get(0).size()) {
                        String symbolObiektu = Mapa.get(sąsiedniX).get(sąsiedniY);

                        // Sprawdzenie, czy obiekt jest roślinożercą
                        if (symbolObiektu.equals("S")) {
                            Roslinozerca roślinożerca = znajdźRoślinożerca(sąsiedniX, sąsiedniY);
                            if (roślinożerca != null) {
                                zadajObrazenia(roślinożerca, lis.obrazenia);
                            }
                        }

                        // Sprawdzenie, czy obiekt jest wszystkożercą
                        if (symbolObiektu.equals("J")) {
                            Wszystkozerca wszystkożerca = znajdźWszystkożerca(sąsiedniX, sąsiedniY);
                            if (wszystkożerca != null) {
                                zadajObrazenia(wszystkożerca, lis.obrazenia);
                            }
                        }
                    }
                }
            }
        }
    }

    private Roslinozerca znajdźRoślinożerca(int x, int y) {
        for (Roslinozerca roślinożerca : listaRoślinożerców) {
            if (roślinożerca.x == x && roślinożerca.y == y) {
                return roślinożerca;
            }
        }
        return null;
    }

    private Wszystkozerca znajdźWszystkożerca(int x, int y) {
        for (Wszystkozerca wszystkożerca : listaWszystkożerców) {
            if (wszystkożerca.x == x && wszystkożerca.y == y) {
                return wszystkożerca;
            }
        }
        return null;
    }

    public boolean czyZabity() {
        return zabity;
    }

    public void zabiJ() {
        this.zabity = true;
    }


}
