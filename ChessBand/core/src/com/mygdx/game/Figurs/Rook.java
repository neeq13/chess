package com.mygdx.game.Figurs;
import com.mygdx.game.Turn;

public class Rook extends Figure {

    public Rook(int x, int y) {
        super(x, y);
        this.name = "rook";
        this.shName = 'R';
        this.avialableTurns.add(new Turn(1, 0, true));
        this.avialableTurns.add(new Turn(0, 1, true));
        this.avialableTurns.add(new Turn(0, -1, true));
        this.avialableTurns.add(new Turn(-1, 0, true));
    }

}
