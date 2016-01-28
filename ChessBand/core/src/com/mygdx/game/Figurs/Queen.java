
package com.mygdx.game.Figurs;

import com.mygdx.game.Field;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Queen extends Figure {

    public Queen(char color, int x, int y) {
        super(color, x, y);
        this.name = "queen";
        this.shName = 'Q';
    }

    @Override
    public void setPosition(int x, int y) {
        if (Math.abs(y-this.y) <= Field.getFieldSize() && x - this.x == 0||
                y-this.y == 0 && Math.abs(x - this.x) <= Field.getFieldSize() ||
                Math.abs(y - this.y) == Math.abs(x - this.x)){
            this.y = y;
            this.x = x;
        }
    }
}
