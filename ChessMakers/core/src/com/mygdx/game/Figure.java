package com.mygdx.game;

/**
 * Created by Белл on 21.01.2016.
 */
public class Figure {
    private int x;
    private int y;
    protected String name;

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

    public void corse(int x, int y)
    {
        this.x = x * 60;
        this.y = y * 60;
    }

}
