package com.mygdx.game;

public class Field {
    private static final int FIELD_SIZE = 8;
    private int x;
    private int y;
    public static char[][] field;
    public static final char freeDot = '*'; // обозначение пустой ячейки

    public static void initField()    {
        field = new char[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                field[i][j] = freeDot;
            }
        }
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

    public static void setXO(int _y, int _x, char _ox)
    {
        field[FIELD_SIZE - 1 - _y][_x] = _ox;
    }

    public static boolean isCellEmpty(int _y, int _x)
    {
        // проверка на невыход на границы поля
        if((_x < FIELD_SIZE)&&(_y < FIELD_SIZE)) {
            if ((field[FIELD_SIZE - 1 - _y][_x] == freeDot) && (_x < FIELD_SIZE && _y < FIELD_SIZE)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isFreeLine(int _y, int _x, int _vx, int _vy, int _l)
    {

        if(_x + _vx * _l > FIELD_SIZE || (FIELD_SIZE - 1 - _y) + _vy * _l > FIELD_SIZE || (FIELD_SIZE - 1 - _y) + _vy * _l < -1 || _x * _vx * _l < -1) return false;
        for(int i=0;i<_l;i++) {
            System.out.println(_x + ":" + _y + ":" + _vx + ":" + _vy + ":" + i );
            if (isCellEmpty((FIELD_SIZE - 1 - _y) + i * _vy, _x + i * _vx))
            {return true;}
        }
        return false;
    }


}
