package com.example.meadowfx;

public class Trująca extends Roślina{
    int trucizna;
    int odpoczynek;

    public Trująca(){
        this.symbol = "T";
        this.odpoczynek = 2;
        this.trucizna = 50;
        this.maxWiek = 5;
        this.wzrost =1;
        this.wystepowanie = 20;
    }
    @Override
    public void akcja() {
        super.akcja();
    }
    public void zatruj(){

    }
}
