package com.example.meadowfx;


import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Wszystkozerca extends Zwierze {
    int obrazenia;
    int ofiary;
    int glod;
    int spożytyPokarm;
    private boolean zabity;
    public List<Miesozerca> listaLisow;
    public List<Roslinozerca> listaRoślinożerców;
    public List<Wszystkozerca> listaWszystkożerców;
    public List<Jadalna> listaJadalnych;
    public List<Trujaca> listaTrujących;
    public List<List<String>> Mapa;

    public Wszystkozerca() {
        this.symbol = "J";
        this.obrazenia = 30;
        this.życie = 100;
        this.nazwa = "Jez";
        this.zabity = false;
    }
    public void wzmozGlod(){
        glod+=5;
    }

    public void poruszajSie() {
        int nowyX = x;
        int nowyY = y;
        boolean znalezionoWolneMiejsce = false;

        if (czyZabity()) {
            return;
        }

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
                // Usunięcie obiektu z poprzednich współrzędnych
                Mapa.get(x).set(y, "X");

                // Aktualizacja współrzędnych obiektu
                x = nowyX;
                y = nowyY;

                // Umieszczenie obiektu na nowych współrzędnych
                Mapa.get(x).set(y, symbol);

                znalezionoWolneMiejsce = true;
            } else {
                znalezionoWolneMiejsce = true;
            }
        }
    }


    public void zjedzRośline(Roslina roslina) {
        if (roslina instanceof Jadalna) {
            Jadalna jadalna = (Jadalna) roslina;
            this.życie += jadalna.regeneracja;
            listaJadalnych.remove(jadalna);
            Mapa.get(jadalna.x).set(jadalna.y, "X");
            spożytyPokarm++;
            glod-=jadalna.sytosc;
            if (glod < 0){
                glod = 0;
            }
        }
        if (roslina instanceof Trujaca) {
            Trujaca trująca = (Trujaca) roslina;
            this.życie += trująca.trucizna;
            listaTrujących.remove(trująca);
            Mapa.get(trująca.x).set(trująca.y, "X");
            spożytyPokarm++;
            glod-=trująca.sytosc;
            if (glod < 0){
                glod = 0;
            }
        }
    }
    public List<Jadalna> getlistaJadalnych(){
        return this.listaJadalnych;
    }
    public List<Trujaca> getListaTrujących(){
        return this.listaTrujących;
    }


    public void szukajrosliny() {
        Iterator<Wszystkozerca> iterator = listaWszystkożerców.iterator();
        while (iterator.hasNext()) {
            Wszystkozerca jez = iterator.next();
            int aktualnyX = jez.x;
            int aktualnyY = jez.y;

            // Sprawdzanie pobliskich obiektów wokół jeża
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int sąsiedniX = aktualnyX + i;
                    int sąsiedniY = aktualnyY + j;

                    // Sprawdzenie, czy sąsiednie współrzędne są w obrębie mapy
                    if (sąsiedniX >= 0 && sąsiedniX < Mapa.size() && sąsiedniY >= 0 && sąsiedniY < Mapa.get(0).size()) {
                        String symbolObiektu = Mapa.get(sąsiedniX).get(sąsiedniY);

                        // Sprawdzenie, czy obiekt jest jadalny
                        if (symbolObiektu.equals("G")) {
                            Jadalna jadalna = znajdźGrzyba(sąsiedniX, sąsiedniY);
                            if (jadalna != null) {
                                zjedzRośline(jadalna);
                            }
                        }

                        // Sprawdzenie, czy obiekt jest trujący
                        if (symbolObiektu.equals("M")) {
                            Trujaca trująca = znajdźMuchomora(sąsiedniX, sąsiedniY);
                            if (trująca != null) {
                                zjedzRośline(trująca);
                            }
                        }
                    }
                }
            }
        }
    }


    private Jadalna znajdźGrzyba(int x, int y) {
        for (Jadalna jadalna : listaJadalnych) {
            if (jadalna.x == x && jadalna.y == y) {
                return jadalna;
            }
        }
        return null;
    }

    private Trujaca znajdźMuchomora(int x, int y) {
        for (Trujaca trująca : listaTrujących) {
            if (trująca.x == x && trująca.y == y) {
                return trująca;
            }
        }
        return null;
    }



    public void zadajObrazenia(Zwierze zwierzę, int obrazenia) {
        if (zwierzę instanceof Roslinozerca) {
            Roslinozerca roślinożerca = (Roslinozerca) zwierzę;
            roślinożerca.życie -= obrazenia;

            if (roślinożerca.życie <= 0) {
                Mapa.get(roślinożerca.x).set(roślinożerca.y, "X");
                listaRoślinożerców.remove(roślinożerca);
                ofiary++;
            }
        } else if (zwierzę instanceof Miesozerca) {
            Miesozerca mięsożerca = (Miesozerca) zwierzę;
            mięsożerca.życie -= obrazenia;

            if (mięsożerca.życie <= 0) {
                Mapa.get(mięsożerca.x).set(mięsożerca.y, "X");
                listaWszystkożerców.remove(mięsożerca);
                ofiary++;
                glod = 0;
            }
        }
    }

    public void atakujZwierzęta() {
        for (Wszystkozerca jez : listaWszystkożerców) {
            int aktualnyX = jez.x;
            int aktualnyY = jez.y;

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
                                zadajObrazenia(roślinożerca, jez.obrazenia);
                            }
                        }

                        // Sprawdzenie, czy obiekt jest mięsożercą
                        if (symbolObiektu.equals("L")) {
                            Miesozerca mięsożerca = znajdźMięzożerca(sąsiedniX, sąsiedniY);
                            if (mięsożerca != null) {
                                zadajObrazenia(mięsożerca, jez.obrazenia);
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

    private Miesozerca znajdźMięzożerca(int x, int y) {
        for (Miesozerca mięsożerca : listaLisow) {
            if (mięsożerca.x == x && mięsożerca.y == y) {
                return mięsożerca;
            }
        }
        return null;
    }

    public void unik() {

    }

    public boolean czyZabity() {
        return zabity;
    }

    public void zabiJ() {
        this.zabity = true;
    }
}