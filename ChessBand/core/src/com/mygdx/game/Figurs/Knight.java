
package com.mygdx.game.Figurs;
/**
 * Created by Алексей on 23.01.2016.
 */
public class Knight extends Figure {

    public Knight(int x, int y) {
        super(x, y);
    }


    @Override
    public boolean setPosition(int x, int y) {
        if (Math.abs(y-this.y) == 2&& Math.abs(x - this.x) == 1|| Math.abs(y-this.y) == 1&& Math.abs(x - this.x) == 2){
            this.y = y;
            this.x = x;
            return true;
        }
        return false;
    }

    @Override
    public int[] availableMoves() {
        return null;
    }


}
