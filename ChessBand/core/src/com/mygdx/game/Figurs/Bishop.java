
package com.mygdx.game.Figurs;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Bishop extends Figure {

    public Bishop(int x, int y) {
        super(x, y);
    }


    @Override

    public boolean setPosition(int x, int y) {
        if (y - this.y == x - this.x || -(y - this.y) == (x - this.x)) {
            this.y = y;
            this.x = x;
            return true;
        }
        return false;
    }


}
