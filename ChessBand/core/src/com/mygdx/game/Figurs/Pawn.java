package com.mygdx.game.Figurs;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Алексей on 24.01.2016.
 */
public class Pawn extends Figure {
    public Pawn(int x, int y, Texture texture, boolean isWhite) {
        super(x, y, texture, isWhite);
    }

    @Override
    public boolean setPosition(int x, int y) {

        if (field[y][x] == 0 && (y - this.y == 1 && this.x == x)) {
            field[this.y][this.x] = 0;
            this.y = y;
            this.x = x;
            if (isWhite) field[this.y][this.x] = 1;
            else field[this.y][this.x] = 2;
            isWasTurn = true;
            return true;
        } else if (field[y][x] == 0 && (y - this.y == 2 && this.x == x && !isWasTurn)) {
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

    //У Пешки их максимум 6(Пока без провеки на врагов и взятий на проходе)
    @Override
    public int[][] availableMoves() {
        int[][] result = new int[8][8];
        if (field[y + 1][x] == 0 && y < 7) result[y + 1][x] = 1;
        if (field[y + 2][x] == 0 && !isWasTurn) result[y + 2][x] = 1;

        return result;
    }
}
