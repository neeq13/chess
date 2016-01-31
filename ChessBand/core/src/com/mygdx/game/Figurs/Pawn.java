package com.mygdx.game.Figurs;
import com.mygdx.game.Turn;
public class Pawn extends Figure {
    public Pawn(int x, int y) {
        super(x, y);
        this.name = "pawn";
        this.shName = 'p';
<<<<<<< HEAD
        this.directions = new int[][]{{0,-1}};
        hasMoved = false;
        this.length = 2;
        if(isHasMoved()) this.length = 1;
=======
        this.avialableTurns.add(new Turn(0, 1, false));
        this.avialableTurns.add(new Turn(0, 2, false));
    }

    public void setPosition(int x, int y) {
        if (proverka(x, y)) {
            this.y = y;
            this.x = x;
            this.hasMoved = true;
            if (this.avialableTurns.size == 2) {
                this.avialableTurns.pop();
            }
        }

>>>>>>> rightNapravl
    }
}



