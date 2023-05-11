# Meadow
Język: Java
Temat 1
Łąka
Program służy do symulowania życia zwierząt na łące oraz występującej na niej roślinności. Tworzona jest plansza o określonej wielkości, a następnie losowo są dodawane obiekty na planszę. Możliwa jest opcja manipulowania wartościami pewnych zmiennych. Ostatecznie, program pozwala na obserwowanie życia na łące w czasie rzeczywistym i interakcje z planszą. Każdy obiekt posiada odmienne własności i wzorce zachowań.  Zwierzęta mogą poruszać się (w sposób losowy) po planszy o zadanych wymiarach. Każde z pól planszy może kryć jakiegoś rodzaju zasób (Roślinność). Symulację rozpoczynamy od utworzenia losowej planszy z zasobami o zadanych wymiarach. Następnie rozmieszczamy na niej losowo wygenerowane Zwierzęta. W każdym z kroków symulacji organizm przemieszcza się o specyficzną dla niego liczbę pól. W trakcie swojej wędrówki może znajdować zasoby, spotykać inne organizmy oraz wchodzić z nimi w interakcje.

1. Klasa „Zwierzę” - zawiera takie atrybuty: 
1.1. nazwę zwierzęcia (nazwa), 
1.2. symbol, który reprezentuje zwierzę na planszy (symbol),
1.3. wartość życia, która określa, jak wiele punktów życia ma dany obiekt (życie)
1.4. poziom głodu (głód). 
1.5. Ilość populacji (populacja)
2. Klasa „Mięsożerca” – klasa ta dziedziczy po klasie „Zwierzę”
2.1.  zawiera takie dodatkowe pole jak ilość zadawanych obrażeń (obrażenia).
2.2. Ilość ofiar (ofiary)
3. Klasa „Roślinożerca” – klasa ta dziedziczy po klasie „Zwierzę”, 
3.1. zawiera takie dodatkowe pole jak ilość zjedzonego pokarmu (pokarm)
4. Klasa „Roślinność” – zawiera takie atrybuty jak:
4.1. Szybkość wzrostu o 1 roślinę na planszy (wzrost)
4.2. Długość życia (maxWiek)
4.3. Ilość występowania na mapie (występowanie)
5. Klasa „Trująca” – klasa ta dziedziczy po klasie „Roślinność”,
5.1. zawiera takie dodatkowe pole jak ilość zadanych obrażeń z powodu trucizny (trucizna)
5.2. zawiera takie dodatkowe pole jak ilość potrzebnego czasu do ponownego ruszenia obiektu po spożyciu trującej rośliny (odpoczynek)
6. Klasa „Jadalna” – klasa ta dziedziczy po klasie „Roślinność”,
6.1. zawiera takie dodatkowe pole jak poziom uzupełnienia głodu (sytość)
6.2. zawiera takie dodatkowe pole jak ilość zregenerowanych punktów zdrowia po spożyciu(Regeneracja).
