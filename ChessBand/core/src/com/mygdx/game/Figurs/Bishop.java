
package com.mygdx.game.Figurs;

import com.mygdx.game.Field;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Bishop extends Figure {

    public Bishop(int x, int y) {
        super(x, y);
        this.name = "bishop";

    }

    public boolean proverka(int x, int y){
        if (Field.isCellEmpty(y, x)) {
            if (Math.abs(y - this.y) == Math.abs(x - this.x)) {
                return true;
            }
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
