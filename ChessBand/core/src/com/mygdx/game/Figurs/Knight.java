package com.mygdx.game.Figurs;
import com.mygdx.game.Turn;

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

}
