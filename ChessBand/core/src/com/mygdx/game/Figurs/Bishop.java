
package com.mygdx.game.Figurs;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Bishop extends Figure {

    public Bishop(String name, char color, int x, int y) {
        super(name, color, x, y);
        this.shName = 'B';
    }

    @Override
    public void setPosition(int x, int y) {
        if (y - this.y == x - this.x || -(y - this.y) == (x - this.x)) {
            this.y = y;
            this.x = x;
        }
    }
}
