package com.example.meadowfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.File;
import java.io.FileWriter;

import javafx.stage.FileChooser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class HelloController implements Initializable {
    int iloscEtapow = 0;
    Random generator = new Random();
    List<Jadalna> listaGrzybków = new ArrayList<>();
    List<Trujaca> listaMuchomorow = new ArrayList<>();
    List<Roslinozerca> listaSaren = new ArrayList<>();
    List<Miesozerca> listaLisow = new ArrayList<>();
    List<Wszystkozerca> listaJeży = new ArrayList<>();
    List<List<String>> Mapa = new ArrayList<>();
    @FXML
    private TextFlow mapka;
    @FXML
    private TextField xwprowadzone, ywprowadzone, iloscJadalne, iloscTrujace, iloscWszystkozercy, iloscMiesozercy, iloscRoslinozercy;
    @FXML
    private Button generuj, dalej, zapisz;
    @FXML
    private Text iksy, igreki, mapa1, populacjaMiesozercow, populacjaRoslinozercow, populacjaWszystkozercow, wystepowanieJadalne, wystepowanieTrujace, etap, liczba, poczatkowo, aktualnie, aktualneLisy, aktualneSarny, aktualneJeze, aktualneGrzyby, aktualneMuchomory;

    @FXML
    private void generujMape() {
        if (xwprowadzone.getText().equals("") || ywprowadzone.getText().equals("") || iloscJadalne.getText().equals("") || iloscTrujace.getText().equals("") || iloscWszystkozercy.getText().equals("") || iloscMiesozercy.getText().equals("") || iloscRoslinozercy.getText().equals("")) {
            Text komunikat = new Text("BŁĄD!!!\nBRAK WPROWADZONYCH DANYCH! \nUSTAW WARTOŚCI MAPY i OBIEKTÓW.");
            komunikat.setFill(Color.RED); // Set text color to red
            mapka.getChildren().clear();
            mapka.getChildren().add(komunikat);
        } else if (Integer.parseInt(xwprowadzone.getText()) > 15 || Integer.parseInt(ywprowadzone.getText()) > 19) {
            Text komunikat = new Text("BŁĄD!!!\nZA DUŻE WYMIARY MAPY! \nX_MAX = 15 Y_MAX = 19");
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
                    Trujaca muchomor = new Trujaca();
                    listaMuchomorow.add(muchomor);
                }
                for (int i = 0; i < iloscLisow; i++) {
                    Miesozerca Lis = new Miesozerca();
                    listaLisow.add(Lis);
                }
                for (int i = 0; i < iloscSaren; i++) {
                    Roslinozerca Sarna = new Roslinozerca();
                    listaSaren.add(Sarna);
                }
                for (int i = 0; i < iloscJezy; i++) {
                    Wszystkozerca Jez = new Wszystkozerca();
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
                zapisz.setVisible(!zapisz.isVisible());
                iloscJadalne.setVisible(!iloscJadalne.isVisible());
                iloscTrujace.setVisible(!iloscTrujace.isVisible());
                iloscMiesozercy.setVisible(!iloscMiesozercy.isVisible());
                iloscRoslinozercy.setVisible(!iloscRoslinozercy.isVisible());
                iloscWszystkozercy.setVisible(!iloscWszystkozercy.isVisible());
                poczatkowo.setVisible(!poczatkowo.isVisible());
                aktualnie.setVisible(!aktualnie.isVisible());

                wystepowanieJadalne.setText(String.valueOf(wyświetlanaIlośćGrzybów));
                wystepowanieTrujace.setText(String.valueOf(wyświetlanaIlośćMuchomorów));
                populacjaMiesozercow.setText(String.valueOf(wyświetlanaIlośćLisow));
                populacjaRoslinozercow.setText(String.valueOf(wyświetlanaIlośćSaren));
                populacjaWszystkozercow.setText(String.valueOf(wyświetlanaIlośćJeży));

                // Generowanie Mapy i umiejscowienie obiektów
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

        for (Miesozerca lis : listaLisow) {
            lis.listaLisow = listaLisow;
            lis.listaRoślinożerców = listaSaren;
            lis.listaWszystkożerców = listaJeży;
            lis.Mapa = Mapa;
            lis.poruszajSie();
            lis.atakujZwierzęta();
            lis.wzmozGlod();
        }

        Iterator<Miesozerca> iteratorom = listaLisow.iterator();
        while (iteratorom.hasNext()) {
            Miesozerca lis = iteratorom.next();

            // Condition to remove the fox from the list
            if (lis.glod >= 100 || lis.życie <= 0) {
                Mapa.get(lis.x).set(lis.y, "X");
                iteratorom.remove(); // Remove the current element from the list
            }
        }

        for (Wszystkozerca jez : listaJeży) {
            jez.listaLisow = listaLisow;
            jez.listaRoślinożerców = listaSaren;
            jez.listaWszystkożerców = listaJeży;
            jez.listaJadalnych = listaGrzybków;
            jez.listaTrujących = listaMuchomorow;
            jez.Mapa = Mapa;
            listaGrzybków = jez.getlistaJadalnych();
            listaMuchomorow = jez.getListaTrujących();
            jez.poruszajSie();
            jez.atakujZwierzęta();
            jez.szukajrosliny();
            jez.wzmozGlod();
        }


        Iterator<Wszystkozerca> iterato = listaJeży.iterator();
        while (iterato.hasNext()) {
            Wszystkozerca jez = iterato.next();

            // Condition to remove the deer from the list
            if (jez.życie <= 0 || jez.glod >= 130) {
                Mapa.get(jez.x).set(jez.y, "X");
                iterato.remove(); // Remove the current element from the list
            }
        }


        for (Roslinozerca sarna : listaSaren) {
            sarna.listaJadalnych = listaGrzybków;
            sarna.listaRoślinożerców = listaSaren;
            sarna.listaTrujących = listaMuchomorow;
            sarna.Mapa = Mapa;
            sarna.poruszajSie();
            sarna.szukajrosliny();
            sarna.wzmozGlod();
            listaGrzybków = sarna.getlistaJadalnych();
            listaMuchomorow = sarna.getListaTrujących();
        }


        Iterator<Roslinozerca> iterator = listaSaren.iterator();
        while (iterator.hasNext()) {
            Roslinozerca sarna = iterator.next();

            // Condition to remove the deer from the list
            if (sarna.życie <= 0 || sarna.glod >= 150) {
                Mapa.get(sarna.x).set(sarna.y, "X");
                iterator.remove(); // Remove the current element from the list
            }
        }

        for (Jadalna grzyb : listaGrzybków){
            grzyb.zwiekszWiek();
        }
        for (Trujaca muchomor : listaMuchomorow){
            muchomor.zwiekszWiek();
        }


        if (iloscEtapow % 5 == 0) {
            List<Jadalna> noweGrzybki = new ArrayList<>();

            for (Iterator<Jadalna> iteratoro = listaGrzybków.iterator(); iteratoro.hasNext();) {
                Jadalna grzyb = iteratoro.next();
                grzyb.Mapa = Mapa;
                grzyb.setListaGrzybow(listaGrzybków);
                List<Jadalna> wygenerowaneGrzybki = Jadalna.generujNoweGrzybki(Mapa);
                noweGrzybki.addAll(wygenerowaneGrzybki);
                // Condition to remove the mushroom from the list
                if (grzyb.wiek == grzyb.Maxwiek) {
                    Mapa.get(grzyb.x).set(grzyb.y, "X");
                    iteratoro.remove(); // Remove the current element from the list
                }
            }

            listaGrzybków.addAll(noweGrzybki);
        }



        if (iloscEtapow % 5 == 0) {
            List<Trujaca> noweMuchomory = new ArrayList<>();

            for (Iterator<Trujaca> iteratory = listaMuchomorow.iterator(); iteratory.hasNext();) {
                Trujaca muchomor = iteratory.next();
                muchomor.Mapa = Mapa;
                muchomor.setListaMuchomorkow(listaMuchomorow);
                List<Trujaca> wygenerowaneMuchomory = Trujaca.generujNoweMuchomory(Mapa);
                noweMuchomory.addAll(wygenerowaneMuchomory);
                // Condition to remove the mushroom from the list
                if (muchomor.wiek == muchomor.Maxwiek) {
                    Mapa.get(muchomor.x).set(muchomor.y, "X");
                    iteratory.remove(); // Remove the current element from the list
                }
            }

            listaMuchomorow.addAll(noweMuchomory);
        }

        aktualneGrzyby.setText(String.valueOf(listaGrzybków.size()));
        aktualneMuchomory.setText(String.valueOf(listaMuchomorow.size()));
        aktualneJeze.setText(String.valueOf(listaJeży.size()));
        aktualneSarny.setText(String.valueOf(listaSaren.size()));
        aktualneLisy.setText(String.valueOf(listaLisow.size()));


        // Aktualizacja wyświetlanej mapy po poruszeniu się obiektów
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

    @FXML
    private void zapisz() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Wybierz ścieżkę do zapisu pliku CSV");

        // Dodajemy filtr dla plików CSV
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Pliki CSV", "*.csv");
        fileChooser.getExtensionFilters().add(filter);

        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            // Użytkownik wybrał plik
            String filePath = file.getAbsolutePath();

            try (FileWriter fileWriter = new FileWriter(filePath);
                 CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT)) {

                // Nagłówki kolumn w pliku CSV

                if (!listaSaren.isEmpty()){
                    csvPrinter.printRecord("Nazwa", "Symbol", "Zycie", "Pokarm spozyty", "Glod");
                    // Zapisujesz informacje o obiektach w pliku CSV
                    for (Roslinozerca sarna : listaSaren) {
                        csvPrinter.printRecord(sarna.nazwa, sarna.symbol, sarna.życie, sarna.spożytyPokarm, sarna.glod);
                    }}

                if (!listaLisow.isEmpty()){
                    // Nagłówki kolumn w pliku CSV
                    csvPrinter.printRecord("Nazwa", "Symbol", "Zycie", "Ofiary", "Glod");
                    for (Miesozerca lis : listaLisow) {
                        csvPrinter.printRecord(lis.nazwa, lis.symbol, lis.życie, lis.ofiary, lis.glod);
                    }}

                if (!listaJeży.isEmpty()){
                    // Nagłówki kolumn w pliku CSV
                    csvPrinter.printRecord("Nazwa", "Symbol", "Zycie", "Ofiary", "Pokarm spozyty", "Glod");
                    for (Wszystkozerca jez : listaJeży) {
                        csvPrinter.printRecord(jez.nazwa, jez.symbol, jez.życie, jez.ofiary, jez.spożytyPokarm, jez.glod);
                    }}

                if (!listaGrzybków.isEmpty()){
                    // Nagłówki kolumn w pliku CSV
                    csvPrinter.printRecord("Nazwa", "Symbol", "Wiek");
                    for (Jadalna jadalna : listaGrzybków) {
                        csvPrinter.printRecord(jadalna.nazwa, jadalna.symbol, jadalna.wiek);
                    }}

                if (!listaMuchomorow.isEmpty()){
                    // Nagłówki kolumn w pliku CSV
                    csvPrinter.printRecord("Nazwa", "Symbol", "Wiek");
                    for (Trujaca trująca : listaMuchomorow) {
                        csvPrinter.printRecord(trująca.nazwa, trująca.symbol, trująca.wiek);
                    }}

                // Pusty wiersz oddzielający
                csvPrinter.println();
                csvPrinter.printRecord("STAN MAPY PO ZAPISIE");


                // Mapa
                for (List<String> wiersz : Mapa) {
                    csvPrinter.printRecord(wiersz);
                }

                csvPrinter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Text t1 = new Text("Mapka łąki się tutaj wygeneruje!\nProszę podać wartości x, y i kliknąć przycisk 'Generuj Mape'.");
        mapka.getChildren().add(t1);
        etap.setVisible(false);
        dalej.setVisible(false);
        zapisz.setVisible(false);
        poczatkowo.setVisible(false);
        aktualnie.setVisible(false);
    }
}