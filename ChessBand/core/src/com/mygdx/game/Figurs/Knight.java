
package com.mygdx.game.Figurs;

import com.mygdx.game.Field;
import com.mygdx.game.Turn;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Knight extends Figure {


    public Knight(int x, int y) {
        super(x, y);
        this.name = "knight";
        this.shName = 'N';
        this.avialableTurns.add(new Turn(2, 1, false));
        this.avialableTurns.add(new Turn(2, -1, false));
        this.avialableTurns.add(new Turn(1, 2, false));
        this.avialableTurns.add(new Turn(1, -2, false));
        this.avialableTurns.add(new Turn(-1, 2, false));
        this.avialableTurns.add(new Turn(-1, -2, false));
        this.avialableTurns.add(new Turn(-2, 1, false));
        this.avialableTurns.add(new Turn(-2, -1, false));

    }

    public boolean proverka(int x, int y) {
        if (Field.isCellEmpty(y, x)) {
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
