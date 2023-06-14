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
2.3. Głód (Głód);<br />
<br />
3. Klasa „Roślinożerca” – klasa ta dziedziczy po klasie „Zwierzę”, <br />
3.1. zawiera takie dodatkowe pole jak ilość zjedzonego pokarmu (pokarm)<br />
3.2. Głód (Głód);<br />
<br />
4. Klasa „Wszystkożerca” – klasa ta dziedziczy po klasie „Zwierzę”, <br />
4.1. zawiera takie dodatkowe pole jak ilość zjedzonego pokarmu (pokarm)<br />
4.2. Głód (Głód);<br />
4.3. zawiera takie dodatkowe pole jak ilość zadawanych obrażeń (obrażenia).<br />
4.4. Ilość ofiar (ofiary)<br />
4.5. Głód (Głód);<br />
<br />
5. Klasa „Roślinność” – zawiera takie atrybuty jak:<br />
5.1. nazwę rośliny (nazwa)<br />
5.2. symbol, który reprezentuje na planszy (symbol),<br />
<br />
6. Klasa „Trująca” – klasa ta dziedziczy po klasie „Roślinność”,<br />
6.1. zawiera takie dodatkowe pole jak ilość zadanych obrażeń z powodu trucizny (trucizna)<br />
6.2. sytość (sytość)<br />
<br />
7. Klasa „Jadalna” – klasa ta dziedziczy po klasie „Roślinność”,<br />
7.1. zawiera takie dodatkowe pole jak ilość zregenerowanych punktów zdrowia po spożyciu(Regeneracja).<br />
7.2. sytość (sytość)<br />
<br />
Wygląd po aplikacji po włączeniu, możliwość zadania różnych parametrów początkowych:<br /><br />

![Screenshot](nowamapa.png)<br />

Wygląd wygenerowanej mapy z obiektami losowo na niej umieszonej:<br />

![Screenshot](Meadowmapa.png)<br />

