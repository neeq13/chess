package com.mygdx.game;

import com.mygdx.game.Figurs.Figure;

import java.util.ArrayList;

public class Field {
    private Figure figure;
    private static final int FIELD_SIZE = 8;
    private int x;
    private int y;
    private static Figure[][] field;
    //private static final char freeDot = '*'; // обозначение пустой ячейки

    public static void initField()    {
        field = new Figure[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                field[i][j] = null;
            }
        }
    }
    public static Figure getFigure(int _x, int _y) {
        return field[_y][_x];
    }
    public static int getFieldSize() {
        return FIELD_SIZE;
    }

    public static void printField() {
        System.out.print("  ");
        for(int i = 0; i < FIELD_SIZE; i++) {
            System.out.printf("%2d ", (i + 1));
        }
        System.out.print('\n');
        for (int i = 0; i < FIELD_SIZE; i++) {
            System.out.printf("%2d ", (i + 1));
            for (int j = 0; j < FIELD_SIZE; j++) {
                System.out.print(field[i][j] + "  ");
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }


    public static void setXO(int _y, int _x, Figure figure)
    {
        field[FIELD_SIZE - 1 - _y][_x] = figure;
    }


    public static boolean isCellEmpty(int _y, int _x)
    {
        if(_y < getFieldSize() && _y >= 0 && _x < getFieldSize() && _x >= 0) {
            if (field[_y][_x] == null) {
                return true;
            }
        }
            return false;
    }

    public ArrayList<Point> checkLine(int _y, int _x, int _vx, int _vy, int _l)
    {
        ArrayList points = new ArrayList();

        for(int i=1; i<_l; i++) {
            if (isCellEmpty(Field.getFieldSize() - 1 - _y + i * _vy, _x - i * _vx))
            {
                System.out.println("Точка " + (_x - i * _vx) + ":" + (_y - i * _vy));
                points.add(new Point((_x - i * _vx), (_y - i * _vy)));
            } else {
                break;
            }
        }
        return points;
    }
    
}
