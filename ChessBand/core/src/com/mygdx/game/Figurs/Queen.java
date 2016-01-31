package com.mygdx.game.Figurs;

import com.mygdx.game.Turn;

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

}
