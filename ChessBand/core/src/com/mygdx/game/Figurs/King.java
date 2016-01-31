package com.mygdx.game.Figurs;

import com.mygdx.game.Turn;

public class King extends Figure {

    public King(int x, int y) {
        super(x, y);
        this.name = "king";
        this.shName = 'K';
<<<<<<< HEAD
        this.directions = new int[][]{{0,1},{1,0},{1,1},{-1,-1},{-1,0},{0,-1}};
        this.length = 1;
    }

=======
        this.avialableTurns.add(new Turn(1, 0, false));
        this.avialableTurns.add(new Turn(0, 1, false));
        this.avialableTurns.add(new Turn(1, 1, false));
        this.avialableTurns.add(new Turn(1, -1, false));
        this.avialableTurns.add(new Turn(-1, -1, false));
        this.avialableTurns.add(new Turn(-1, 0, false));
        this.avialableTurns.add(new Turn(0, -1, false));
        this.avialableTurns.add(new Turn(-1, 1, false));
    }
>>>>>>> rightNapravl
}
