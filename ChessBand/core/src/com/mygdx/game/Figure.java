package com.mygdx.game;

public abstract class Figure {
    private int x;
    private int y;
    private char color;

    public abstract void moveTo(int x, int y);

    public abstract void canMove(int x, int y);

}
