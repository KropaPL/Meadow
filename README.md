# Meadow
Język: Java

Łąka

Program służy do symulowania życia zwierząt na łące oraz występującej na niej roślinności. Tworzona jest plansza o określonej wielkości, a następnie losowo są dodawane obiekty na planszę. Możliwa jest opcja manipulowania wartościami pewnych zmiennych. Ostatecznie, program pozwala na obserwowanie życia na łące w czasie rzeczywistym i interakcje z planszą. Każdy obiekt posiada odmienne własności i wzorce zachowań.  Zwierzęta mogą poruszać się (w sposób losowy) po planszy o zadanych wymiarach. Każde z pól planszy może kryć jakiegoś rodzaju zasób (Roślinność). Symulację rozpoczynamy od utworzenia losowej planszy z zasobami o zadanych wymiarach. Następnie rozmieszczamy na niej losowo wygenerowane Zwierzęta. W każdym z kroków symulacji organizm przemieszcza się o specyficzną dla niego liczbę pól. W trakcie swojej wędrówki może znajdować zasoby, spotykać inne organizmy oraz wchodzić z nimi w interakcje.<br />

1. Klasa „Zwierzę” - zawiera takie atrybuty: <br />
1.1. nazwę zwierzęcia (nazwa), <br />
1.2. symbol, który reprezentuje zwierzę na planszy (symbol),<br />
1.3. wartość życia, która określa, jak wiele punktów życia ma dany obiekt (życie)<br />
<br />
2. Klasa „Mięsożerca” – klasa ta dziedziczy po klasie „Zwierzę”<br />
2.1.  zawiera takie dodatkowe pole jak ilość zadawanych obrażeń (obrażenia).<br />
2.2. Ilość ofiar (ofiary)<br />
<br />
3. Klasa „Roślinożerca” – klasa ta dziedziczy po klasie „Zwierzę”, <br />
3.1. zawiera takie dodatkowe pole jak ilość zjedzonego pokarmu (pokarm)<br />
<br />
4. Klasa „Roślinność” – zawiera takie atrybuty jak:<br />
4.2. nazwę rośliny (nazwa)<br />
4.3. symbol, który reprezentuje na planszy (symbol),<br />
<br />
5. Klasa „Trująca” – klasa ta dziedziczy po klasie „Roślinność”,<br />
5.1. zawiera takie dodatkowe pole jak ilość zadanych obrażeń z powodu trucizny (trucizna)<br />
<br />
6. Klasa „Jadalna” – klasa ta dziedziczy po klasie „Roślinność”,<br />
6.1. zawiera takie dodatkowe pole jak ilość zregenerowanych punktów zdrowia po spożyciu(Regeneracja).<br />
<br />
Wygląd po aplikacji po włączeniu, możliwość zadania różnych parametrów początkowych:
<br />
![Meadowekran](https://github.com/KropaPL/Meadow/assets/122940169/8c25fed9-0679-4b0a-b200-747921e9aabe)
<br />
Wygląd wygenerowanej mapy z obiektami losowo na niej umieszonej:
<br />
![Meadowmapa](https://github.com/KropaPL/Meadow/assets/122940169/20bacb03-688f-40f7-90fc-bc7929219502)
<br />
