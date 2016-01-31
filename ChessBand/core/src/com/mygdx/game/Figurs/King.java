package com.mygdx.game.Figurs;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Field;
import com.mygdx.game.Turn;

/**
 * Created by Алексей on 23.01.2016.
 */
public class King extends Figure {

    public King(int x, int y) {
        super(x, y);
        this.name = "king";
        this.shName = 'K';
        this.avialableTurns.add(new Turn(1, 0, false));
        this.avialableTurns.add(new Turn(0, 1, false));
        this.avialableTurns.add(new Turn(1, 1, false));
        this.avialableTurns.add(new Turn(1, -1, false));
        this.avialableTurns.add(new Turn(-1, -1, false));
        this.avialableTurns.add(new Turn(-1, 0, false));
        this.avialableTurns.add(new Turn(0, -1, false));
        this.avialableTurns.add(new Turn(-1, 1, false));
    }

    public boolean proverka(int x, int y) {
        if (Field.isCellEmpty(y, x)) {
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
