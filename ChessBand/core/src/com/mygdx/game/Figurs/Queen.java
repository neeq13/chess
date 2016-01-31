
package com.mygdx.game.Figurs;

import com.mygdx.game.Field;
import com.mygdx.game.Turn;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Queen extends Figure {

    public Queen(int x, int y) {
        super(x, y);
        this.name = "queen";
        this.shName = 'Q';
        this.avialableTurns.add(new Turn(1, 0, true));
        this.avialableTurns.add(new Turn(0, 1, true));
        this.avialableTurns.add(new Turn(1, 1, true));
        this.avialableTurns.add(new Turn(1, -1, true));
        this.avialableTurns.add(new Turn(-1, -1, true));
        this.avialableTurns.add(new Turn(-1, 0, true));
        this.avialableTurns.add(new Turn(0, -1, true));
        this.avialableTurns.add(new Turn(-1, 1, true));

    }

    public boolean proverka(int x, int y) {
        if (Field.isCellEmpty(y, x)) {
            if (Math.abs(y - this.y) <= Field.getFieldSize() && x - this.x == 0 ||
                    y - this.y == 0 && Math.abs(x - this.x) <= Field.getFieldSize() ||
                    Math.abs(y - this.y) == Math.abs(x - this.x)) {
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
