package com.mygdx.game.Figurs;

import com.mygdx.game.Field;
import com.mygdx.game.Turn;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Pawn extends Figure {

    public Pawn(int x, int y) {
        super(x, y);
        this.name = "pawn";
        this.shName = 'p';
        this.avialableTurns.add(new Turn(0, 1, false));
        this.avialableTurns.add(new Turn(0, 2, false));
    }

    @Override
    public boolean proverka(int x, int y) {
        if (Field.isCellEmpty(y, x)) {
            if (((y - this.y > 0) && (y - this.y < 3) && (this.x == x) && !isHasMoved()) ||
                    ((y - this.y == 1) && (this.x == x) && isHasMoved())) {
                return true;
            }
        }
        return false;

    }

    @Override
    public void setPosition(int x, int y) {
        if (proverka(x, y)) {
            this.y = y;
            hasMoved = true;
        }
    }
}



