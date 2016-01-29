package com.mygdx.game.Figurs;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/**
 * Created by Алексей on 23.01.2016.
 */
public abstract class Figure {
    protected int x;
    protected int y;



    protected Texture texture;
    protected boolean isWasTurn;
    protected boolean isWhite = true;

    public static int[][] field = new int[8][8];

    public Figure(int x, int y, Texture texture, boolean isWhite) {
        this.x = x;
        this.y = y;
        this.texture = texture;
        this.isWhite = isWhite;
        if (isWhite) field[y][x] = 1;
        else field[y][x] = 2;
        isWasTurn = false;
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

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

//    public void setPosition(int x, int y) {
//        if (y - this.y == 1 && x-this.x == 1) {
//            this.y = y++;
//            this.x = x++;
//        }
//    }
//


    public abstract boolean setPosition(int x, int y);

    //Все возможные ходы
    public abstract int[][] availableMoves();
}
