
package com.mygdx.game.Figurs;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Bishop extends Figure {

    public Bishop(int x, int y, Texture texture, boolean isWhite) {
        super(x, y, texture, isWhite);
    }


    @Override

    public boolean setPosition(int x, int y) {
        if (field[y][x] == 0 && (y - this.y == x - this.x || -(y - this.y) == (x - this.x))) {
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
        for (int i = y + 1, j = x + 1; i < field.length && j < field.length; i++, j++) {
            if (field[i][j] == 0)
                result[i][j] = 1;
            else break;
        }

        for (int i = y - 1, j = x - 1; i >= 0 && j >= 0; i--, j--) {
            if (field[i][j] == 0)
                result[i][j] = 1;
            else break;
        }

        for (int i = y + 1, j = x - 1; i < field.length && j >= 0; i++, j--) {
            if (field[i][j] == 0)
                result[i][j] = 1;
            else break;
        }

        for (int i = y - 1, j = x + 1; j < field.length && i >= 0; i--, j++) {
            if (field[i][j] == 0)
                result[i][j] = 1;
            else break;
        }
        return result;
    }


}
