package com.mygdx.game.Figurs;

public class Rook extends Figure {
    public Rook(String name, char color, int x, int y) {
        super(name, color, x, y);
        this.shName = 'R';
    }

    @Override
    public void setPosition(int x, int y) {
        if (Math.abs(y-this.y) <= 8&& x - this.x == 0|| y-this.y == 0&& Math.abs(x - this.x) <=8 ){
            this.y = y;
            this.x = x;
        }
    }
}
