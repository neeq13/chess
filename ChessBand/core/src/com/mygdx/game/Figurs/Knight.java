package com.mygdx.game.Figurs;
import com.mygdx.game.Turn;

public class Knight extends Figure {

    public Knight(int x, int y) {
        super(x, y);
        this.name = "knight";
        this.shName = 'N';
<<<<<<< HEAD
    }

    public boolean proverka(int x, int y) {
        if (Field.isCellEmpty(Field.getFieldSize() - 1 - y, x)) {
            if (Math.abs(y - this.y) == 2 && Math.abs(x - this.x) == 1 || Math.abs(y - this.y) == 1 && Math.abs(x - this.x) == 2) {
                return true;
            }
        }
        return false;
    }

=======
        this.avialableTurns.add(new Turn(2, 1, false));
        this.avialableTurns.add(new Turn(2, -1, false));
        this.avialableTurns.add(new Turn(1, 2, false));
        this.avialableTurns.add(new Turn(1, -2, false));
        this.avialableTurns.add(new Turn(-1, 2, false));
        this.avialableTurns.add(new Turn(-1, -2, false));
        this.avialableTurns.add(new Turn(-2, 1, false));
        this.avialableTurns.add(new Turn(-2, -1, false));

    }

>>>>>>> rightNapravl
}
