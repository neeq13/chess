package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public abstract class Figure {
    protected int x;
    protected int y;
    protected char color;
    protected Texture texture;

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

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public abstract void moveTo(int x, int y);

    public abstract void canMove(int x, int y);

}
