package com.example.meadowfx;


public class Wszystkożerca extends Zwierzę{
    int obrazenia;
    int ofiary;
    int spożytyPokarm;
    private boolean zabity;

    public Wszystkożerca(){
        this.symbol = "J";
        this.obrazenia = 70;
        this.glod = 0;
        this.życie = 100;
        this.nazwa = "Jeż";
        this.zabity = false;
    }
    @Override
    public void akcja(){

    }
    public void unik(){

    }
    public void atak(){

    }
    public boolean czyZabity() {
        return zabity;
    }

    public void zabiJ() {
        this.zabity = true;
    }
}
