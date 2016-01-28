
package com.mygdx.game.Figurs;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Bishop extends Figure {

    public Bishop(char color, int x, int y) {
        super(color, x, y);
        this.name = "bishop";
        this.shName = 'B';
    }

    @Override
    public void setPosition(int x, int y) {
        if (Math.abs(y - this.y) == Math.abs(x - this.x)) {
            this.y = y;
            this.x = x;
        }
    }
}
