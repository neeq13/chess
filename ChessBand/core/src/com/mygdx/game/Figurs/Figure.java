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
    protected ArrayList<Point> lighting = new ArrayList<Point>();

    Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Texture getFigtex() {
        return figtex;
    }
    public void setFigtex(Texture figtex) {
        this.figtex = figtex;
    }

    public ArrayList<Point> getLighting() {
        return lighting;
    } // массив с подсветкой возможных ходов

    protected boolean hasMoved = false; // делала ли фигура ход

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
                        lighting.add(new Point(tempX, tempY));
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
        lighting.clear();
    }

    // ставим фигуру на клетку
    public void setPosition(int x, int y) {
        if (isRigthTurn(x, y)) {
            this.y = y;
            this.x = x;
        }
    }

    // поменялась ли позиция, т.е. не провели ли мышью на несуществующую клетку
    public boolean isChangePosition(int x, int y) {
        if(this.x != x || this.y != y) {
            return true;
        } else {
            return false;
        }
    }

    // можно ли сюда поставить фигуру
    public boolean isRigthTurn(int x, int y) {
        for (Point podsv : lighting) {
            if(podsv.getX() == x && podsv.getY() == y) return true;
        }
        return false;
    }

}
