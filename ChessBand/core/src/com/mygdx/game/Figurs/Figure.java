package com.mygdx.game.Figurs;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Field;
import com.mygdx.game.Point;

import java.util.ArrayList;


public abstract class Figure {
    protected int x;
    protected int y;
    protected String name;
    protected char shName;
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
        if (length + y > Field.getFieldSize() - 1) {
            length = Field.getFieldSize() - y;
        }
        for (int[] direction : directions) {
            ArrayList<Point> points = field.checkLine(y, x, direction[0], direction[1], length);
            for (Point point : points) {
                podsvetka.add(new Point(point.getX(), point.getY()));
            }
        }
    }
// очищаем массив от фигур
    public void resetLight() {
        podsvetka.clear();
    }
// абстрактные методы, установка фигуры в новые координаты и проверка на ход фигуры
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
        if (length + y > Field.getFieldSize() - 1) {
            length = Field.getFieldSize() - 1- y;
        }
        for (int[] direction : directions) {
            if (field.checkLine(y, x, direction[0], direction[1], length).size() > 0) {
                return true;
            }
        }
        return false;
    }

}
