package com.mygdx.game;

public class Turn {
    public int x;
    public int y;
    public boolean nextStep;

    public Turn(int x, int y, boolean nextStep) {
        this.x = x;
        this.y = y;
        this.nextStep = nextStep;
    }
}
