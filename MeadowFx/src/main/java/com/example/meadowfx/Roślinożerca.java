package com.example.meadowfx;

public class Roślinożerca extends Zwierzę{
    int spożytyPokarm;
    private boolean zabity;

    public Roślinożerca(){
        this.symbol = "S";
        this.nazwa = "Sarna";
        this.życie = 100;
        this.glod = 0;
        this.zabity = false;
    }
    @Override
    public void akcja(){

    }
    public void unik(){

    }
    public boolean czyZabity() {
        return zabity;
    }

    public void zabiJ() {
        this.zabity = true;
    }

}
