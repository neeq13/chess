package com.mygdx.game;

/**
 * Created by Белл on 23.01.2016.
 */
public class Rook extends Figure {

    public Rook(int x, int y) {
        super(x, y);

    }

    @Override
    public void setCores(int x, int y) {
        if (Math.abs(y - this.y) == Math.abs(x - this.x)) {
            this.y = y;
            this.x = x;
        }
    }
}
