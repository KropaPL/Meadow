package com.example.meadowfx;

import java.time.chrono.MinguoEra;
import java.util.List;

public class Mięsożerca extends Zwierzę {
    int obrazenia;
    int ofiary;

    public List<Mięsożerca> listaLisow;
    public List<Roślinożerca> listaRoślinożerców;
    public List<Wszystkożerca> listaWszystkożerców;
    public List<List<String>> Mapa;


    public Mięsożerca() {
        this.symbol = "L";
        this.obrazenia = 100;
        this.glod = 0;
        this.życie = 100;
        this.nazwa = "Lis";

    }

    @Override
    public void akcja() {

    }

    public void zadajObrazenia(Zwierzę zwierzę, int obrazenia) {
        if (zwierzę instanceof Roślinożerca) {
            Roślinożerca roślinożerca = (Roślinożerca) zwierzę;
            roślinożerca.życie -= obrazenia;

            if (roślinożerca.życie <= 0) {
                Mapa.get(roślinożerca.x).set(roślinożerca.y, "X");
                listaRoślinożerców.remove(roślinożerca);
            }
        } else if (zwierzę instanceof Wszystkożerca) {
            Wszystkożerca wszystkożerca = (Wszystkożerca) zwierzę;
            wszystkożerca.życie -= obrazenia;

            if (wszystkożerca.życie <= 0) {
                Mapa.get(wszystkożerca.x).set(wszystkożerca.y, "X");
                listaWszystkożerców.remove(wszystkożerca);
            }
        }
    }

    public void atakujZwierzęta() {
        for (Mięsożerca lis : listaLisow) {
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
                            Roślinożerca roślinożerca = znajdźRoślinożerca(sąsiedniX, sąsiedniY);
                            if (roślinożerca != null) {
                                zadajObrazenia(roślinożerca, lis.obrazenia);
                            }
                        }

                        // Sprawdzenie, czy obiekt jest wszystkożercą
                        if (symbolObiektu.equals("J")) {
                            Wszystkożerca wszystkożerca = znajdźWszystkożerca(sąsiedniX, sąsiedniY);
                            if (wszystkożerca != null) {
                                zadajObrazenia(wszystkożerca, lis.obrazenia);
                            }
                        }
                    }
                }
            }
        }
    }

    private Roślinożerca znajdźRoślinożerca(int x, int y) {
        for (Roślinożerca roślinożerca : listaRoślinożerców) {
            if (roślinożerca.x == x && roślinożerca.y == y) {
                return roślinożerca;
            }
        }
        return null;
    }

    private Wszystkożerca znajdźWszystkożerca(int x, int y) {
        for (Wszystkożerca wszystkożerca : listaWszystkożerców) {
            if (wszystkożerca.x == x && wszystkożerca.y == y) {
                return wszystkożerca;
            }
        }
        return null;
    }


}
