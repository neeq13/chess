package com.mygdx.game.Figurs;

import com.mygdx.game.Field;

public class Rook extends Figure {
    public Rook(char color, int x, int y) {
        super(color, x, y);
        this.name = "rook";
        this.shName = 'R';
    }

    @Override
    public void setPosition(int x, int y) {
        if (Math.abs(y-this.y) <= Field.getFieldSize() && x - this.x == 0 ||
                y-this.y == 0 && Math.abs(x - this.x) <= Field.getFieldSize()){
            this.y = y;
            this.x = x;
        }
    }
}
