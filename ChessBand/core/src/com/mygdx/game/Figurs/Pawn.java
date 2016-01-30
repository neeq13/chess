package com.mygdx.game.Figurs;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Pawn extends Figure {

    public Pawn(int x, int y) {
        super(x, y);
        this.name = "pawn";
        this.shName = 'p';
    }

    @Override
    public boolean proverka(int x, int y) {
        if (!ff.proverka(x, y))
            if(((y - this.y > 0)&& (y - this.y < 3)&&(this.x == x)&& !isHasMoved())||
                    ((y - this.y == 1)&&(this.x == x)&& isHasMoved())) {
                return true;
            }
        return false;

    }

    @Override
    public void setPosition(int x, int y) {
        if (proverka(x, y)) {
            this.y = y;
        }
    }
}



