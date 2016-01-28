package com.mygdx.game.Figurs;

/**
 * Created by Алексей on 24.01.2016.
 */
public class Pawn extends Figure {
    public Pawn(char color, int x, int y) {
        super(color, x, y);
        this.name = "pawn";
        this.shName = 'p';
    }

    @Override
    public void setPosition(int x, int y) {
        if(((y - this.y > 0)&& (y - this.y < 3)&&(this.x == x)&&(color == 'w')&& !isHasMoved())||
                ((this.y - y > 0) && (this.y - y < 3)&&(this.x == x)&&(color == 'b'))&&!isHasMoved()||
                ((y - this.y == 1)&&(this.x == x)&&(color == 'w')&& isHasMoved())||
                ((this.y - y == 1)&&(this.x == x)&&(color == 'b'))&&isHasMoved()) {
            this.y = y;
            this.x = x;
        }
    }
}
