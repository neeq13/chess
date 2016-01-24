package com.mygdx.game;

/**
 * Created by Белл on 21.01.2016.
 */
public abstract class Figure {
    protected int x;
    protected int y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public abstract void setCores(int x, int y);

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }


}
