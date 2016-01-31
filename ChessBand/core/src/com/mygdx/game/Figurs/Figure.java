package com.mygdx.game.Figurs;
import com.badlogic.gdx.graphics.Texture;
<<<<<<< HEAD
=======
import com.badlogic.gdx.utils.Array;
>>>>>>> rightNapravl
import com.mygdx.game.Field;
import com.mygdx.game.Point;
import com.mygdx.game.Turn;

import java.util.ArrayList;


public abstract class Figure {
    protected int x;
    protected int y;
    protected String name;
    protected char shName;
<<<<<<< HEAD
    Field field = new Field();

    public Texture getFigtex() {
        return figtex;
    }

    public void setFigtex(Texture figtex) {
        this.figtex = figtex;
    }

    protected Texture figtex;
    protected int[][] directions = {{0,1},{1,0},{1,1},{-1,-1},{-1,0},{0,-1}};
    protected int length;
=======
    public Texture figtex;
    protected Array<Turn> avialableTurns = new Array<Turn>();
>>>>>>> rightNapravl

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
<<<<<<< HEAD
        if (length + y > Field.getFieldSize() - 1) {
            length = Field.getFieldSize() - y;
        }
        for (int[] direction : directions) {
            ArrayList<Point> points = field.checkLine(y, x, direction[0], direction[1], length);
            for (Point point : points) {
                podsvetka.add(new Point(point.getX(), point.getY()));
=======
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
>>>>>>> rightNapravl
            }
        }
    }
// очищаем массив от фигур
    public void resetLight() {
        podsvetka.clear();
    }
<<<<<<< HEAD
// абстрактные методы, установка фигуры в новые координаты и проверка на ход фигуры
=======

>>>>>>> rightNapravl
    public void setPosition(int x, int y) {
        if (proverka(x, y)) {
            this.y = y;
            this.x = x;
        }
    }

    public boolean isChangePosition(int x, int y) {
        if(this.x != x || this.y != y) {
            return true;
        } else {
            return false;
        }
    }

    public boolean proverka(int x, int y) {
<<<<<<< HEAD
        if (length + y > Field.getFieldSize() - 1) {
            length = Field.getFieldSize() - 1- y;
        }
        for (int[] direction : directions) {
            if (field.checkLine(y, x, direction[0], direction[1], length).size() > 0) {
                return true;
            }
=======
        for (Point podsv : podsvetka) {
            if(podsv.getX() == x && podsv.getY() == y) return true;
>>>>>>> rightNapravl
        }
        return false;
    }

}
