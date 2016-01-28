package com.mygdx.game.Figurs;

import com.mygdx.game.Koordinati;

import java.util.ArrayList;

/**
 * Created by Алексей on 23.01.2016.
 */
public abstract class Figure {
    protected int x;
    protected int y;
    Koordinati kr = new Koordinati();


    protected ArrayList<Integer> keyX = new ArrayList<Integer>();
    protected ArrayList<Integer> keyY = new ArrayList<Integer>();

    public Figure() {
    }

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ArrayList<Integer> getKeyX() {
        return keyX;
    }

    public ArrayList<Integer> getKeyY() {
        return keyY;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void light() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (proverka(i, j)) {
                    if (kr.proverka(i, j)) continue;
                    keyX.add(i);
                    keyY.add(j);
                }
                kr.zapisKoordinat();
            }
        }
    }

//    public abstract void setTex();

    public void resetLight() {
        keyX.clear();
        keyY.clear();
    }

    public abstract void setPosition(int x, int y);

    public abstract boolean proverka(int x, int y);


}
