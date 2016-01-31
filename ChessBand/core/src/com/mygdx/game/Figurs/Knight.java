
package com.mygdx.game.Figurs;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Field;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Knight extends Figure {


    public Knight(int x, int y) {
        super(x, y);
        this.name = "knight";
        this.shName = 'N';
    }

    public boolean proverka(int x, int y) {
        if (Field.isCellEmpty(Field.getFieldSize() - 1 - y, x)) {
            if (Math.abs(y - this.y) == 2 && Math.abs(x - this.x) == 1 || Math.abs(y - this.y) == 1 && Math.abs(x - this.x) == 2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setPosition(int x, int y) {
        if (proverka(x,y)){
            this.y = y;
            this.x = x;
        }
    }

}
