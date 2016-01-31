package com.mygdx.game.Figurs;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Field;

/**
 * Created by Алексей on 23.01.2016.
 */
public class King extends Figure {

    public King(int x, int y) {
        super(x, y);
        this.name = "king";
        this.shName = 'K';
        this.directions = new int[][]{{0,1},{1,0},{1,1},{-1,-1},{-1,0},{0,-1}};
        this.length = 1;
    }

    public boolean proverka(int x, int y) {
        if (Field.isCellEmpty(Field.getFieldSize() - 1 - y, x)) {
            if (Math.abs(y-this.y) == 1&& Math.abs(x - this.x) == 0|| Math.abs(y-this.y) == 0&& Math.abs(x - this.x) == 1||
                    Math.abs(y-this.y) == 1 && Math.abs(x - this.x) == 1) {
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
