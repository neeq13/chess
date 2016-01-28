package com.mygdx.game.Figurs;

import java.util.ArrayList;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Rook extends Figure {


    public Rook(int x, int y) {
        super(x, y);

    }

    @Override
    public boolean proverka(int x, int y) {
        if (Math.abs(y-this.y) <= 8&& x - this.x == 0|| y-this.y == 0&& Math.abs(x - this.x) <=8 ){
            return true;
        }
        return false;
    }

    @Override
    public void setTex() {

    }

    @Override
    public void setPosition(int x, int y) {
        if (Math.abs(y-this.y) <= 8&& x - this.x == 0|| y-this.y == 0&& Math.abs(x - this.x) <=8 ){
            this.y = y;
            this.x = x;
        }
    }
}
