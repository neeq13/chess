package com.mygdx.game.Figurs;

public abstract class Figure {
    protected int x;
    protected int y;
    protected String name;
    protected char shName;
    protected char color;

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    protected boolean hasMoved = false;

    public char getShName() {
        return shName;
    }

    public char getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public Figure(char color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void setPosition(int x, int y);

    public boolean isChangePosition(int x, int y) {
        if(this.x != x || this.y != y) {
            return true;
        } else {
            return false;
        }
    }


}
