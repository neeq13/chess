package com.mygdx.game.Figurs;

import com.mygdx.game.Turn;

public class Bishop extends Figure {

    public Bishop(int x, int y) {
        super(x, y);
        this.name = "bishop";
<<<<<<< HEAD
        this.shName = 'B';
        this.directions = new int[][]{{1,1},{-1,-1}};
        this.length = 7;

    }
=======
        this.avialableTurns.add(new Turn(1, 1, true));
        this.avialableTurns.add(new Turn(-1, -1, true));
        this.avialableTurns.add(new Turn(1, -1, true));
        this.avialableTurns.add(new Turn(-1, 1, true));
    }

>>>>>>> rightNapravl
}
