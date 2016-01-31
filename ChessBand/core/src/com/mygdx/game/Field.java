package com.mygdx.game;

import com.mygdx.game.Figurs.Figure;

public class Field {
    private Figure figure;
    private static final int FIELD_SIZE = 8;
    private int x;
    private int y;
    private static Figure[][] field;

    //инициализируем поле
    public static void initField()    {
        field = new Figure[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                field[i][j] = null;
            }
        }
    }

    //ищем фигуру на поле
    public static Figure getFigure(int _x, int _y) {
        return field[_y][_x];
    }

    //выводим размер поля
    public static int getFieldSize() {
        return FIELD_SIZE;
    }

    //печатаем поле
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

    //ставим фигуру на поле
    public static void setXO(int _y, int _x, Figure figure) {
        field[FIELD_SIZE - 1 - _y][_x] = figure;
    }
    
}
