package com.mygdx.game.Figurs;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Pawn extends Figure {

    public Pawn(int x, int y) {
        super(x, y);
    }


    @Override
    public boolean proverka(int x, int y) {
        if (!ff.proverka(x, y))
            if (y - this.y == 1 && x - this.x == 0 || y - this.y == 2 && x - this.x == 0 && this.y <= 1) {
                return true;
            }
        return false;
    }

    @Override
    public void setPosition(int x, int y) {
        if (proverka(x, y)) {

            this.y = y;
        }
    }
}



