package com.mygdx.game.Figurs;

import java.util.ArrayList;

/**
 * Created by Алексей on 23.01.2016.
 */
public abstract class Figure {
    protected int x;
    protected int y;


    public Figure() {
    }

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

//    public void setPosition(int x, int y) {
//        if (y - this.y == 1 && x-this.x == 1) {
//            this.y = y++;
//            this.x = x++;
//        }
//    }
//


    public abstract boolean setPosition(int x, int y);

}
