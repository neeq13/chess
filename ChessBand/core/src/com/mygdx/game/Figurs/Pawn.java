package com.mygdx.game.Figurs;

/**
 * Created by Алексей on 24.01.2016.
 */
public class Pawn extends Figure {
    public Pawn(String name, char color, int x, int y) {
        super(name, color, x, y);
        this.shName = 'p';
    }

    @Override
    public void setPosition(int x, int y) {
        if((y - this.y > 0)&& (y - this.y < 3)&&(this.x == x)&&(color == 'w')) {
            this.y = y;
            this.x = x;
        }
        if((this.y - y > 0) && (this.y - y < 3)&&(this.x == x)&&(color == 'b')) {
            this.y = y;
            this.x = x;
        }
    }
}
