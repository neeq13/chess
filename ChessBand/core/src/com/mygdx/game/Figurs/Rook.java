package com.mygdx.game.Figurs;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Rook extends Figure {



    public Rook(int x, int y, Texture texture, boolean isWhite) {
        super(x, y, texture, isWhite);
    }


    @Override
    public boolean setPosition(int x, int y) {
        if (Math.abs(y-this.y) <= 8 && x - this.x == 0|| y-this.y == 0&& Math.abs(x - this.x) <=8 ){
            this.y = y;
            this.x = x;
            return true;
        }
        return false;
    }

    @Override
    public int[][] availableMoves() {
        return null;
    }


}
