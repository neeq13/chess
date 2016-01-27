package com.mygdx.game;

/**
 * Created by Алексей on 27.01.2016.
 */
public class Point {
    private int xKoordinata;
    private int yKoordinata;

    public Point(int xKoordinata, int yKoordinata) {
        this.xKoordinata = xKoordinata;
        this.yKoordinata = yKoordinata;
    }

    public int getxKoordinata() {
        return xKoordinata;
    }

    public void setxKoordinata(int xKoordinata) {
        this.xKoordinata = xKoordinata;
    }

    public int getyKoordinata() {
        return yKoordinata;
    }

    public void setyKoordinata(int yKoordinata) {
        this.yKoordinata = yKoordinata;
    }
}
