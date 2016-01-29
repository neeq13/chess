package com.mygdx.game.Figurs;

import com.mygdx.game.FigureFactory;
import com.mygdx.game.Koordinati;
import com.mygdx.game.Point;

import java.util.ArrayList;

/**
 * Created by Алексей on 23.01.2016.
 */
public abstract class Figure {
    protected int x;
    protected int y;
    Koordinati kr = new Koordinati();
    FigureFactory ff = new FigureFactory();


    protected ArrayList<Point> kletkaSFiguroy = new ArrayList();


    public Figure() {
    }

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ArrayList<Point> getKletkaSFiguroy() {
        return kletkaSFiguroy;
    }

    public void setKletkaSFiguroy(ArrayList<Point> kletkaSFiguroy) {
        this.kletkaSFiguroy = kletkaSFiguroy;
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
                    if (ff.proverka(i, j)) continue;
                    kletkaSFiguroy.add(new Point(i,j));

                }
                ff.zapisKoordinat();
            }
        }
    }


    public void resetLight() {
        kletkaSFiguroy.clear();
    }

    public abstract void setPosition(int x, int y);

    public abstract boolean proverka(int x, int y);


}
