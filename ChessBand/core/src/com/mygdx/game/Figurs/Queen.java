
package com.mygdx.game.Figurs;
/**
 * Created by Алексей on 23.01.2016.
 */
public class Queen extends Figure {

    public Queen(int x, int y) {
        super(x, y);
    }


    @Override
    public boolean proverka(int x, int y) {
        if (Math.abs(y-this.y) <=8&& x - this.x == 0|| y-this.y == 0&& Math.abs(x - this.x) <=8 ||y - this.y == x - this.x || -(y - this.y) == (x - this.x)){
            return true;
        }
        return false;
    }

    @Override
    public void setTex() {

    }

    @Override
    public void setPosition(int x, int y) {
        if (proverka(x,y)){
            this.y = y;
            this.x = x;
        }

    }


}
