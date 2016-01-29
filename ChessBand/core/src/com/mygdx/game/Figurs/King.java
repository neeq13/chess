package com.mygdx.game.Figurs;

/**
 * Created by Алексей on 23.01.2016.
 */
public class King extends Figure {


    public King(int x, int y) {
        super(x, y);

    }


    @Override
    public boolean proverka(int x, int y) {
        if (!ff.proverka(x, y))
            if (Math.abs(y - this.y) == 1 && Math.abs(x - this.x) == 0 || Math.abs(y - this.y) == 0 && Math.abs(x - this.x) == 1 || Math.abs(y - this.y) == 1 && Math.abs(x - this.x) == 1) {
                return true;
            }
        return false;
    }

    @Override
    public void setPosition(int x, int y) {
        if (proverka(x, y)) {
            this.y = y;
            this.x = x;
        }
    }


}
