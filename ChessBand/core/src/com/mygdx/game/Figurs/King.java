package com.mygdx.game.Figurs;


public class King extends Figure {


    public King(int x, int y) {
        super(x, y);

    }


    @Override
    public boolean setPosition(int x, int y) {
        if (Math.abs(y-this.y) == 1&& Math.abs(x - this.x) == 0|| Math.abs(y-this.y) == 0&& Math.abs(x - this.x) == 1||Math.abs(y-this.y) == 1 && Math.abs(x - this.x) == 1){
            this.y = y;
            this.x = x;
            return true;
        }
        return false;
    }



}
