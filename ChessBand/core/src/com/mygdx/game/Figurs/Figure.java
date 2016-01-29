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
    FigureFactory ff = new FigureFactory();

    protected ArrayList<Point> podsvetka = new ArrayList<Point>();

    public ArrayList<Point> getPodsvetka() {
        return podsvetka;
    }

    public void setPodsvetka(ArrayList<Point> podsvetka) {
        this.podsvetka = podsvetka;
    }

    public Figure() {
    }

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
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
                    if (ff.proverka(i,j))continue;
                        podsvetka.add(new Point(i, j));
                }
            }
        }
    }


    public void resetLight() {
        podsvetka.clear();
    }

    public abstract void setPosition(int x, int y);

    public abstract boolean proverka(int x, int y);


}
