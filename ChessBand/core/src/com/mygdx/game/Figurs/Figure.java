package com.mygdx.game.Figurs;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Field;
import com.mygdx.game.Point;
import com.mygdx.game.Turn;

import java.util.ArrayList;


public abstract class Figure {
    protected int x;
    protected int y;
    protected String name;
    protected char shName;
    public Texture figtex;
    protected Array<Turn> avialableTurns = new Array<Turn>();

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

    public int getY() {
        return y;
    }
    // заполняем массив точек с подсветкой
    public void light() {
        for (Turn avialableTurn : avialableTurns) {
            boolean doContinue = true;
            for (int i = 1; doContinue; i++) {
                int tempX = x + avialableTurn.x * i;
                int tempY = y + avialableTurn.y * i;

                if((tempX > -1) && (tempX < 8) && (tempY > -1) && (tempY < 8)) {
                    if(Field.getFigure(tempX, (Field.getFieldSize() - 1 - tempY)) != null) {
                        doContinue = false;
                    } else {
                        podsvetka.add(new Point(tempX, tempY));
                    }
                } else {
                    doContinue = false;
                }

                if (!avialableTurn.nextStep) {
                    doContinue = false;
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




}
