package com.mygdx.game.Figurs;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Алексей on 23.01.2016.
 */
public class King extends Figure {


    public King(int x, int y, Texture texture, boolean isWhite) {
        super(x, y, texture, isWhite);
    }


    @Override
    public boolean setPosition(int x, int y) {
        if (field[y][x] == 0 &&
                (Math.abs(y-this.y) == 1 && Math.abs(x - this.x) == 0 ||
                        Math.abs(y-this.y) == 0&& Math.abs(x - this.x) == 1 ||
                        Math.abs(y-this.y) == 1 && Math.abs(x - this.x) == 1)){
            field[this.y][this.x] = 0;
            this.y = y;
            this.x = x;
            if (isWhite) field[this.y][this.x] = 1;
            else field[this.y][this.x] = 2;
            isWasTurn = true;
            return true;
        }
        return false;
    }

    @Override
    public int[][] availableMoves() {
        int[][] result = new int[8][8];
//        if (x == 0) {
//            for (int i = 0; i < 3; i++) {
//                for (int j = 1; j < 3; j++) {
//                    if (field[y - i + 1][x + j - 1] == 0)
//                        result[y - i + 1][x + j - 1] = 1;
//                }
//
//            }
//        } else if (y == field.length - 1){
//            for (int i = 1; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                    if (field[y - i + 1][x + j - 1] == 0)
//                        result[y - i + 1][x + j - 1] = 1;
//                }
//
//            }
//        } else{
        for (int i = 0, i2 = 1, i3 = 0; i < 3 && i2 < 3 && i3 < 2; i++) {
            for (int j = 0, j2 = 1, j3 = 0; j < 3 && j2 < 3 && j3 < 2; j++) {
                //Угловые клетки
                if (x == 0 && y == field.length - 1) {
                    if (field[y - i2 + 1][x + j2 - 1] == 0)
                        result[y - i2 + 1][x + j2 - 1] = 1;
                    j2++;
                } else if(x == field.length - 1 && y == field.length - 1) {
                    if (field[y - i2 + 1][x + j3 - 1] == 0)
                        result[y - i2 + 1][x + j3 - 1] = 1;
                    j3++;
                } else if (x == 0 && y == 0) {
                    if (field[y - i3 + 1][x + j2 - 1] == 0)
                        result[y - i3 + 1][x + j2 - 1] = 1;
                    j2++;
                } else if (x == field.length - 1 && y == 0) {
                    if (field[y - i3 + 1][x + j3 - 1] == 0)
                        result[y - i3 + 1][x + j3 - 1] = 1;
                    j3++;
                } else if (x == 0) { //Вся левая вертикаль
                    if (field[y - i + 1][x + j2 - 1] == 0)
                        result[y - i + 1][x + j2 - 1] = 1;
                    j2++;
                } else if (y == 0) { //Вся нижняя горизонталь
                    if (field[y - i3 + 1][x + j - 1] == 0)
                        result[y - i3 + 1][x + j - 1] = 1;

                } else if (y == field.length - 1) {//Вся верхняя горизонталь
                    if (field[y - i2 + 1][x + j - 1] == 0)
                        result[y - i2 + 1][x + j - 1] = 1;

                } else if (x == field.length - 1) { // Вся правая вертикаль
                    if (field[y - i + 1][x + j3 - 1] == 0)
                        result[y - i + 1][x + j3 - 1] = 1;
                    j3++;
                } else { // Всё остальное
                    if (field[y - i + 1][x + j - 1] == 0)
                        result[y - i + 1][x + j - 1] = 1;
                }
            }
            if (y == field.length - 1) i2++;
            if (y == 0) i3++;
        }

        return result;
        }
}
