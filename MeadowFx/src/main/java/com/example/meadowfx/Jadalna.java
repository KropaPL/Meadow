package com.example.meadowfx;

public class Jadalna extends Roślina{
    int sytosc;
    int regeneracja;
    public Jadalna(){
        this.symbol = "G";
        this.sytosc = 70;
        this.regeneracja = 50;
        this.maxWiek = 5;
        this.wzrost = 1;
        this.wystepowanie = 20;
    }

    @Override
    public void akcja() {
        super.akcja();
    }
    public void leczenie(){

    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getSytosc(int wartosc){
        return sytosc;
    }
    public int getRegeneracja(){
        return regeneracja;
    }
    public void setX(int wartosc){
        this.x += wartosc;
    }
    public void setY(int wartosc){
        this.y += wartosc;
    }


}
