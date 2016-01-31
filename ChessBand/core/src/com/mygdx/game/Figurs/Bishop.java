package com.mygdx.game.Figurs;

import com.mygdx.game.Turn;

public class Bishop extends Figure {

    public Bishop(int x, int y) {
        super(x, y);
        this.name = "bishop";
        this.avialableTurns.add(new Turn(1, 1, true));
        this.avialableTurns.add(new Turn(-1, -1, true));
        this.avialableTurns.add(new Turn(1, -1, true));
        this.avialableTurns.add(new Turn(-1, 1, true));
    }

}
