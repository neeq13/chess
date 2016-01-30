
package com.mygdx.game.Figurs;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Knight extends Figure {

    public Knight(int x, int y, Texture texture, boolean isWhite) {
        super(x, y, texture, isWhite);
    }


    @Override
    public boolean setPosition(int x, int y) {
        if (field[y][x] == 0 && (Math.abs(y-this.y) == 2&& Math.abs(x - this.x) == 1|| Math.abs(y-this.y) == 1&& Math.abs(x - this.x) == 2)){
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

        if (y < 6) {
            if (x < 7 && field[y + 2][x + 1] == 0)
                result[y + 2][x + 1] = 1;

            if (x > 0 && field[y + 2][x - 1] == 0)
                result[y + 2][x - 1] = 1;
        }
        if (y > 1) {
            if (x < 7 && field[y - 2][x + 1] == 0)
                result[y - 2][x + 1] = 1;

            if (x > 0 && field[y - 2][x - 1] == 0)
                result[y - 2][x - 1] = 1;
        }
        if (x < 6) {
            if (y < 7 && field[y + 1][x + 2] == 0)
                result[y + 1][x + 2] = 1;

            if (y > 0 && field[y - 1][x + 2] == 0)
                result[y - 1][x + 2] = 1;
        }
        if (x > 1) {
            if (y < 7 && field[y + 1][x - 2] == 0)
                result[y + 1][x - 2] = 1;

            if (y > 0 && field[y - 1][x - 2] == 0)
                result[y - 1][x - 2] = 1;
        }
        return result;
    }


}
