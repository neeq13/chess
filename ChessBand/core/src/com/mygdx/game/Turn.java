package com.mygdx.game;

/*
** Вариант хода: nextStep - это продолжается ли линия (встречается у ферзя, слона, ладьи)
 */
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
