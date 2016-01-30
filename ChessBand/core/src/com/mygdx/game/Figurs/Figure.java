package com.mygdx.game.Figurs;
import com.mygdx.game.FigureFactory;
import com.mygdx.game.Point;

import java.util.ArrayList;


public abstract class Figure {
    protected int x;
    protected int y;
    protected String name;
    protected char shName;
    FigureFactory ff = new FigureFactory('w');

    Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected ArrayList<Point> podsvetka = new ArrayList<Point>();

    public ArrayList<Point> getPodsvetka() {
        return podsvetka;
    }

    public void setPodsvetka(ArrayList<Point> podsvetka) {
        this.podsvetka = podsvetka;
    }

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    protected boolean hasMoved = false;

    public char getShName() {
        return shName;
    }

    public String getName() {
        return name;
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
    // заполняем массив точек с подсветкой
    public void light() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (proverka(i, j)) {
                    podsvetka.add(new Point(i, j));
                }
            }
        }
    }
// очищаем массив от фигур
    public void resetLight() {
        podsvetka.clear();
    }
// абстрактные методы, установка фигуры в новые координаты и проверка на ход фигуры
    public abstract void setPosition(int x, int y);

    public boolean isChangePosition(int x, int y) {
        if(this.x != x || this.y != y) {
            return true;
        } else {
            return false;
        }
    }

    public abstract boolean proverka(int x, int y);


    public abstract boolean setPosition(int x, int y);

}
