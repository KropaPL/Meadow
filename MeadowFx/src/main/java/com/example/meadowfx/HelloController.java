package com.example.meadowfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    int wymiarx, wymiary;
    int iloscEtapow = 0;
    Random generator = new Random();
    List<Jadalna> listaGrzybków = new ArrayList<>();
    List<Trująca> listaMuchomorow = new ArrayList<>();
    List<Roślinożerca> listaSaren = new ArrayList<>();
    List<Mięsożerca> listaLisow = new ArrayList<>();
    List<Wszystkożerca> listaJeży = new ArrayList<>();
    List<List<String>> Mapa = new ArrayList<>();
    @FXML
    private TextFlow mapka;
    @FXML
    private TextField xwprowadzone, ywprowadzone, iloscJadalne, iloscTrujace, iloscWszystkozercy, iloscMiesozercy, iloscRoslinozercy;
    @FXML
    private Button generuj, dalej;
    @FXML
    private Text iksy, igreki, mapa1, populacjaMiesozercow, populacjaRoslinozercow, populacjaWszystkozercow, wystepowanieJadalne, wystepowanieTrujace, etap, liczba;

    @FXML
    private void generujMape() {
        if (xwprowadzone.getText().equals("") || ywprowadzone.getText().equals("") || iloscJadalne.getText().equals("") || iloscTrujace.getText().equals("") || iloscWszystkozercy.getText().equals("") || iloscMiesozercy.getText().equals("") || iloscRoslinozercy.getText().equals("")) {
            Text komunikat = new Text("BŁĄD!!!\nBRAK WPROWADZONYCH DANYCH! \nUSTAW WARTOŚCI MAPY i OBIEKTÓW.");
            komunikat.setFill(Color.RED); // Set text color to red
            mapka.getChildren().clear();
            mapka.getChildren().add(komunikat);
        } else {
            int x = Integer.parseInt(xwprowadzone.getText());
            int y = Integer.parseInt(ywprowadzone.getText());
            int iloscGrzybow = Integer.parseInt(iloscJadalne.getText());
            int iloscMuchomorow = Integer.parseInt(iloscTrujace.getText());
            int iloscLisow = Integer.parseInt(iloscMiesozercy.getText());
            int iloscSaren = Integer.parseInt(iloscRoslinozercy.getText());
            int iloscJezy = Integer.parseInt(iloscWszystkozercy.getText());
            if (x * y < iloscGrzybow + iloscMuchomorow + iloscLisow + iloscSaren + iloscJezy) {
                Text komunikat = new Text("BŁĄD!!!\nŹLE WPROWADZONE DANE! \nZMNIEJSZ ILOŚĆ OBIEKTÓW.");
                komunikat.setFill(Color.RED); // Set text color to red
                mapka.getChildren().clear();
                mapka.getChildren().add(komunikat);
            } else {
                int wyświetlanaIlośćGrzybów = iloscGrzybow;
                int wyświetlanaIlośćMuchomorów = iloscMuchomorow;
                int wyświetlanaIlośćLisow = iloscLisow;
                int wyświetlanaIlośćSaren = iloscSaren;
                int wyświetlanaIlośćJeży = iloscJezy;

                for (int i = 0; i < iloscGrzybow; i++) {
                    Jadalna grzyb = new Jadalna();
                    listaGrzybków.add(grzyb);
                }
                for (int i = 0; i < iloscMuchomorow; i++) {
                    Trująca muchomor = new Trująca();
                    listaMuchomorow.add(muchomor);
                }
                for (int i = 0; i < iloscLisow; i++) {
                    Mięsożerca Lis = new Mięsożerca();
                    listaLisow.add(Lis);
                }
                for (int i = 0; i < iloscSaren; i++) {
                    Roślinożerca Sarna = new Roślinożerca();
                    listaSaren.add(Sarna);
                }
                for (int i = 0; i < iloscJezy; i++) {
                    Wszystkożerca Jez = new Wszystkożerca();
                    listaJeży.add(Jez);
                }

                mapka.getChildren().clear();
                generuj.setVisible(!generuj.isVisible());
                xwprowadzone.setVisible(!xwprowadzone.isVisible());
                ywprowadzone.setVisible(!ywprowadzone.isVisible());
                igreki.setVisible(!igreki.isVisible());
                iksy.setVisible(!iksy.isVisible());
                mapa1.setVisible(!mapa1.isVisible());
                etap.setVisible(!etap.isVisible());
                dalej.setVisible(!dalej.isVisible());
                iloscJadalne.setVisible(!iloscJadalne.isVisible());
                iloscTrujace.setVisible(!iloscTrujace.isVisible());
                iloscMiesozercy.setVisible(!iloscMiesozercy.isVisible());
                iloscRoslinozercy.setVisible(!iloscRoslinozercy.isVisible());
                iloscWszystkozercy.setVisible(!iloscWszystkozercy.isVisible());

                wystepowanieJadalne.setText(String.valueOf(wyświetlanaIlośćGrzybów));
                wystepowanieTrujace.setText(String.valueOf(wyświetlanaIlośćMuchomorów));
                populacjaMiesozercow.setText(String.valueOf(wyświetlanaIlośćLisow));
                populacjaRoslinozercow.setText(String.valueOf(wyświetlanaIlośćSaren));
                populacjaWszystkozercow.setText(String.valueOf(wyświetlanaIlośćJeży));


                for (int i = 0; i < y; i++) {
                    List<String> row = new ArrayList<>();
                    for (int j = 0; j < x; j++) {
                        row.add("X"); // Add "X" to each element in the row
                    }
                    Mapa.add(row); // Add the row to the two-dimensional list
                }

                int index = listaGrzybków.size();

                while (iloscGrzybow > 0) {
                    for (int j = 0; j < y; j++) {
                        for (int k = 0; k < x; k++) {
                            int i = generator.nextInt(100);
                            if (Mapa.get(j).get(k).equals("X") && i < 2) {
                                index--;
                                Mapa.get(j).set(k, listaGrzybków.get(index).symbol);
                                listaGrzybków.get(index).x = j;
                                listaGrzybków.get(index).y = k;
                                iloscGrzybow--;
                                if (iloscGrzybow == 0) {
                                    break;
                                }
                            }
                        }
                        if (iloscGrzybow == 0) {
                            break;
                        }
                    }
                }

                index = listaMuchomorow.size();

                while (iloscMuchomorow > 0) {
                    for (int j = 0; j < y; j++) {
                        for (int k = 0; k < x; k++) {
                            int i = generator.nextInt(100);
                            if (Mapa.get(j).get(k).equals("X") && i < 2) {
                                index--;
                                Mapa.get(j).set(k, listaMuchomorow.get(index).symbol);
                                listaMuchomorow.get(index).x = j;
                                listaMuchomorow.get(index).y = k;
                                iloscMuchomorow--;
                                if (iloscMuchomorow == 0) {
                                    break;
                                }
                            }
                        }
                        if (iloscMuchomorow == 0) {
                            break;
                        }
                    }
                }


                index = listaLisow.size();

                while (iloscLisow > 0) {
                    for (int j = 0; j < y; j++) {
                        for (int k = 0; k < x; k++) {
                            int i = generator.nextInt(100);
                            if (Mapa.get(j).get(k).equals("X") && i < 2) {
                                index--;
                                Mapa.get(j).set(k, listaLisow.get(index).symbol);
                                listaLisow.get(index).x = j;
                                listaLisow.get(index).y = k;
                                iloscLisow--;
                                if (iloscLisow == 0) {
                                    break;
                                }
                            }
                        }
                        if (iloscLisow == 0) {
                            break;
                        }
                    }
                }


                index = listaSaren.size();

                while (iloscSaren > 0) {
                    for (int j = 0; j < y; j++) {
                        for (int k = 0; k < x; k++) {
                            int i = generator.nextInt(100);
                            if (Mapa.get(j).get(k).equals("X") && i < 2) {
                                index--;
                                Mapa.get(j).set(k, listaSaren.get(index).symbol);
                                listaSaren.get(index).x = j;
                                listaSaren.get(index).y = k;
                                iloscSaren--;
                                if (iloscSaren == 0) {
                                    break;
                                }
                            }
                        }
                        if (iloscSaren == 0) {
                            break;
                        }
                    }
                }

                index = listaJeży.size();

                while (iloscJezy > 0) {
                    for (int j = 0; j < y; j++) {
                        for (int k = 0; k < x; k++) {
                            int i = generator.nextInt(100);
                            if (Mapa.get(j).get(k).equals("X") && i < 2) {
                                index--;
                                Mapa.get(j).set(k, listaJeży.get(index).symbol);
                                listaJeży.get(index).x = j;
                                listaJeży.get(index).y = k;
                                iloscJezy--;
                                if (iloscJezy == 0) {
                                    break;
                                }
                            }
                        }
                        if (iloscJezy == 0) {
                            break;
                        }
                    }
                }


                for (List<String> row : Mapa) {
                    StringBuilder sb = new StringBuilder();
                    for (String element : row) {
                        Text text = new Text(element + " ");
                        if (element.equals("X")) {
                            text.setFill(Color.GREEN); // Set text color to green for "X"
                        } else if (element.equals("G")) {
                            text.setFill(Color.DEEPSKYBLUE);
                        } else if (element.equals("O")) {
                            text.setFill(Color.DARKRED);
                        } else if (element.equals("L")) {
                            text.setFill(Color.ORANGE);
                        } else if (element.equals("S")) {
                            text.setFill(Color.BROWN);
                        } else if (element.equals("J")) {
                            text.setFill(Color.DARKBLUE);
                        }
                        mapka.getChildren().add(text);
                    }
                    Text newline = new Text("\n");
                    mapka.getChildren().add(newline);

                }
            }
        }
    }

    @FXML
    private void dalej() {
        iloscEtapow++;
        liczba.setText(String.valueOf(iloscEtapow));

        for (Mięsożerca lis : listaLisow) {
            int nowyX = lis.x;
            int nowyY = lis.y;
            boolean znalezionoWolneMiejsce = false;

            while (!znalezionoWolneMiejsce) {
                int kierunek = generator.nextInt(4); // 0 - góra, 1 - prawo, 2 - dół, 3 - lewo

                if (kierunek == 0 && lis.x > 0) { // Poruszanie się w górę
                    nowyX = lis.x - 1;
                    nowyY = lis.y;
                } else if (kierunek == 1 && lis.y < Mapa.get(0).size() - 1) { // Poruszanie się w prawo
                    nowyX = lis.x;
                    nowyY = lis.y + 1;
                } else if (kierunek == 2 && lis.x < Mapa.size() - 1) { // Poruszanie się w dół
                    nowyX = lis.x + 1;
                    nowyY = lis.y;
                } else if (kierunek == 3 && lis.y > 0) { // Poruszanie się w lewo
                    nowyX = lis.x;
                    nowyY = lis.y - 1;
                }

                // Sprawdzenie, czy nowe współrzędne są już zajęte przez inny obiekt
                if (Mapa.get(nowyX).get(nowyY).equals("X")) {
                    // Usunięcie lisów z poprzednich współrzędnych
                    Mapa.get(lis.x).set(lis.y, "X");

                    // Aktualizacja współrzędnych lisów
                    lis.x = nowyX;
                    lis.y = nowyY;

                    // Umieszczenie lisów na nowych współrzędnych
                    Mapa.get(lis.x).set(lis.y, lis.symbol);

                    znalezionoWolneMiejsce = true;
                } else {
                    znalezionoWolneMiejsce = true;
                }
            }
            lis.listaLisow = listaLisow;
            lis.listaRoślinożerców = listaSaren;
            lis.listaWszystkożerców = listaJeży;
            lis.Mapa = Mapa;
            lis.atakujZwierzęta();
        }

        for (Wszystkożerca jez : listaJeży) {
            int nowyX = jez.x;
            int nowyY = jez.y;
            boolean znalezionoWolneMiejsce = false;
            if (jez.czyZabity()) {
                break;
            }
            while (!znalezionoWolneMiejsce) {
                int kierunek = generator.nextInt(4); // 0 - góra, 1 - prawo, 2 - dół, 3 - lewo

                if (kierunek == 0 && jez.x > 0) { // Poruszanie się w górę
                    nowyX = jez.x - 1;
                    nowyY = jez.y;
                } else if (kierunek == 1 && jez.y < Mapa.get(0).size() - 1) { // Poruszanie się w prawo
                    nowyX = jez.x;
                    nowyY = jez.y + 1;
                } else if (kierunek == 2 && jez.x < Mapa.size() - 1) { // Poruszanie się w dół
                    nowyX = jez.x + 1;
                    nowyY = jez.y;
                } else if (kierunek == 3 && jez.y > 0) { // Poruszanie się w lewo
                    nowyX = jez.x;
                    nowyY = jez.y - 1;
                }

                // Sprawdzenie, czy nowe współrzędne są już zajęte przez inny obiekt
                if (Mapa.get(nowyX).get(nowyY).equals("X")) {
                    // Usunięcie lisów z poprzednich współrzędnych
                    Mapa.get(jez.x).set(jez.y, "X");

                    // Aktualizacja współrzędnych lisów
                    jez.x = nowyX;
                    jez.y = nowyY;

                    // Umieszczenie lisów na nowych współrzędnych
                    Mapa.get(jez.x).set(jez.y, jez.symbol);

                    znalezionoWolneMiejsce = true;
                } else {
                    znalezionoWolneMiejsce = true;
                }
            }
        }


        for (Roślinożerca sarna : listaSaren) {
            int nowyX = sarna.x;
            int nowyY = sarna.y;
            boolean znalezionoWolneMiejsce = false;

            while (!znalezionoWolneMiejsce) {
                int kierunek = generator.nextInt(4); // 0 - góra, 1 - prawo, 2 - dół, 3 - lewo

                if (kierunek == 0 && sarna.x > 0) { // Poruszanie się w górę
                    nowyX = sarna.x - 1;
                    nowyY = sarna.y;
                } else if (kierunek == 1 && sarna.y < Mapa.get(0).size() - 1) { // Poruszanie się w prawo
                    nowyX = sarna.x;
                    nowyY = sarna.y + 1;
                } else if (kierunek == 2 && sarna.x < Mapa.size() - 1) { // Poruszanie się w dół
                    nowyX = sarna.x + 1;
                    nowyY = sarna.y;
                } else if (kierunek == 3 && sarna.y > 0) { // Poruszanie się w lewo
                    nowyX = sarna.x;
                    nowyY = sarna.y - 1;
                }

                // Sprawdzenie, czy nowe współrzędne są już zajęte przez inny obiekt
                if (Mapa.get(nowyX).get(nowyY).equals("X")) {
                    // Usunięcie lisów z poprzednich współrzędnych
                    Mapa.get(sarna.x).set(sarna.y, "X");

                    // Aktualizacja współrzędnych lisów
                    sarna.x = nowyX;
                    sarna.y = nowyY;

                    // Umieszczenie lisów na nowych współrzędnych
                    Mapa.get(sarna.x).set(sarna.y, sarna.symbol);

                    znalezionoWolneMiejsce = true;
                } else {
                    znalezionoWolneMiejsce = true;
                }
            }
        }

        if (iloscEtapow % 5 == 0) {
            List<Jadalna> noweGrzybki = new ArrayList<>();

            for (Jadalna grzyb : listaGrzybków) {
                int nowyX = grzyb.x;
                int nowyY = grzyb.y;

                boolean validMove = false;

                while (!validMove) {
                    int kierunek = generator.nextInt(4); // 0 - góra, 1 - prawo, 2 - dół, 3 - lewo

                    Jadalna grzybek = new Jadalna();
                    grzybek.symbol = "G"; // Ustaw symbol nowego grzyba

                    if (kierunek == 0 && grzyb.x > 0) { // Poruszanie się w górę
                        nowyX = grzyb.x - 1;
                        nowyY = grzyb.y;
                    } else if (kierunek == 1 && grzyb.y < Mapa.get(0).size() - 1) { // Poruszanie się w prawo
                        nowyX = grzyb.x;
                        nowyY = grzyb.y + 1;
                    } else if (kierunek == 2 && grzyb.x < Mapa.size() - 1) { // Poruszanie się w dół
                        nowyX = grzyb.x + 1;
                        nowyY = grzyb.y;
                    } else if (kierunek == 3 && grzyb.y > 0) { // Poruszanie się w lewo
                        nowyX = grzyb.x;
                        nowyY = grzyb.y - 1;
                    }

                    // Sprawdzenie, czy nowe współrzędne są już zajęte przez inny obiekt
                    if (Mapa.get(nowyX).get(nowyY).equals("X")) {
                        grzybek.x = nowyX;
                        grzybek.y = nowyY;
                        Mapa.get(nowyX).set(nowyY, grzybek.symbol);

                        noweGrzybki.add(grzybek);
                        validMove = true;
                    } else {
                        validMove = true; // Nie twórz nowego grzyba, jeśli nie ma miejsca
                    }
                }
            }

            listaGrzybków.addAll(noweGrzybki);
        }

        if (iloscEtapow % 5 == 0) {
            List<Trująca> noweMuchomory = new ArrayList<>();

            for (Trująca muchomor : listaMuchomorow) {
                int nowyX = muchomor.x;
                int nowyY = muchomor.y;

                boolean validMove = false;

                while (!validMove) {
                    int kierunek = generator.nextInt(4); // 0 - góra, 1 - prawo, 2 - dół, 3 - lewo

                    Trująca muchomorek = new Trująca();
                    muchomorek.symbol = "M"; // Ustaw symbol nowego grzyba

                    if (kierunek == 0 && muchomor.x > 0) { // Poruszanie się w górę
                        nowyX = muchomor.x - 1;
                        nowyY = muchomor.y;
                    } else if (kierunek == 1 && muchomor.y < Mapa.get(0).size() - 1) { // Poruszanie się w prawo
                        nowyX = muchomor.x;
                        nowyY = muchomor.y + 1;
                    } else if (kierunek == 2 && muchomor.x < Mapa.size() - 1) { // Poruszanie się w dół
                        nowyX = muchomor.x + 1;
                        nowyY = muchomor.y;
                    } else if (kierunek == 3 && muchomor.y > 0) { // Poruszanie się w lewo
                        nowyX = muchomor.x;
                        nowyY = muchomor.y - 1;
                    }

                    // Sprawdzenie, czy nowe współrzędne są już zajęte przez inny obiekt
                    if (Mapa.get(nowyX).get(nowyY).equals("X")) {
                        muchomorek.x = nowyX;
                        muchomorek.y = nowyY;
                        Mapa.get(nowyX).set(nowyY, muchomorek.symbol);

                        noweMuchomory.add(muchomorek);
                        validMove = true;
                    } else {
                        validMove = true; // Nie twórz nowego grzyba, jeśli nie ma miejsca
                    }
                }
            }

            listaMuchomorow.addAll(noweMuchomory);
        }


        // Aktualizacja wyświetlanej mapy po poruszeniu się lisów
        mapka.getChildren().clear();
        for (List<String> row : Mapa) {
            StringBuilder sb = new StringBuilder();
            for (String element : row) {
                Text text = new Text(element + " ");
                if (element.equals("X")) {
                    text.setFill(Color.GREEN); // Set text color to green for "X"
                } else if (element.equals("G")) {
                    text.setFill(Color.DEEPSKYBLUE);
                } else if (element.equals("O")) {
                    text.setFill(Color.DARKRED);
                } else if (element.equals("L")) {
                    text.setFill(Color.ORANGE);
                } else if (element.equals("S")) {
                    text.setFill(Color.BROWN);
                } else if (element.equals("J")) {
                    text.setFill(Color.DARKBLUE);
                }
                mapka.getChildren().add(text);
            }
            Text newline = new Text("\n");
            mapka.getChildren().add(newline);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Text t1 = new Text("Mapka łąki się tutaj wygeneruje!\nProszę podać wartości x, y i kliknąć przycisk 'Generuj Mape'.");
        mapka.getChildren().add(t1);
        etap.setVisible(false);
        dalej.setVisible(false);
    }
}
