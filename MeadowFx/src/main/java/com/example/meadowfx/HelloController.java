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

            int wyświetlanaIlośćGrzybów = iloscGrzybow;
            int wyświetlanaIlośćMuchomorów = iloscMuchomorow;
            int wyświetlanaIlośćLisow = iloscLisow;
            int wyświetlanaIlośćSaren = iloscSaren;
            int wyświetlanaIlośćJeży = iloscJezy;

            for (int i = 0; i < iloscGrzybow; i++) {
                Jadalna grzyb = new Jadalna();
                listaGrzybków.add(grzyb);
            }
            for (int i = 0; i < iloscGrzybow; i++) {
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

            int index = listaGrzybków.size() - 1;

            while (iloscGrzybow > 0) {
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < x; k++) {
                        int i = generator.nextInt(100);
                        if (Mapa.get(j).get(k).equals("X") && i < 2) {
                            Mapa.get(j).set(k, listaGrzybków.get(index).symbol);
                            listaGrzybków.get(index).x = j;
                            listaGrzybków.get(index).y = k;
                            index--;
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

            index = listaMuchomorow.size() - 1;

            while (iloscMuchomorow > 0) {
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < x; k++) {
                        int i = generator.nextInt(100);
                        if (Mapa.get(j).get(k).equals("X") && i < 2) {
                            Mapa.get(j).set(k, listaMuchomorow.get(index).symbol);
                            listaMuchomorow.get(index).x = j;
                            listaMuchomorow.get(index).y = k;
                            index--;
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


            index = listaLisow.size() - 1;

            while (iloscLisow > 0) {
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < x; k++) {
                        int i = generator.nextInt(100);
                        if (Mapa.get(j).get(k).equals("X") && i < 2) {
                            Mapa.get(j).set(k, listaLisow.get(index).symbol);
                            listaLisow.get(index).x = j;
                            listaLisow.get(index).y = k;
                            index--;
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


            index = listaSaren.size() - 1;

            while (iloscSaren > 0) {
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < x; k++) {
                        int i = generator.nextInt(100);
                        if (Mapa.get(j).get(k).equals("X") && i < 2) {
                            Mapa.get(j).set(k, listaSaren.get(index).symbol);
                            listaSaren.get(index).x = j;
                            listaSaren.get(index).y = k;
                            index--;
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

            index = listaJeży.size() - 1;

            while (iloscJezy > 0) {
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < x; k++) {
                        int i = generator.nextInt(100);
                        if (Mapa.get(j).get(k).equals("X") && i < 2) {
                            Mapa.get(j).set(k, listaJeży.get(index).symbol);
                            listaJeży.get(index).x = j;
                            listaJeży.get(index).y = k;
                            index--;
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
                    } else if (element.equals("M")) {
                        text.setFill(Color.DARKRED);
                    } else if (element.equals("L")) {
                        text.setFill(Color.ORANGE);
                    } else if (element.equals("S")) {
                        text.setFill(Color.BROWN);
                    } else if (element.equals("J")) {
                        text.setFill(Color.PINK);
                    }
                    mapka.getChildren().add(text);
                }
                Text newline = new Text("\n");
                mapka.getChildren().add(newline);
            }
        }
    }

    @FXML
    private void dalej(){
        iloscEtapow++;
        liczba.setText(String.valueOf(iloscEtapow));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Text t1 = new Text("Mapka łąki się tutaj wygeneruje!\nProszę podać wartości x, y i kliknąć przycisk 'Generuj Mape'.");
        mapka.getChildren().add(t1);
        etap.setVisible(false);
        dalej.setVisible(false);
    }
}
