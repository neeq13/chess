package com.mygdx.game.Figurs;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sun.java2d.SunGraphics2D;
import sun.print.PathGraphics;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Pawn extends Figure {
    Texture texPawnw = new Texture("pawmw.png");
    Texture texPawnb = new Texture("pawmb.png");
    SpriteBatch batch;

    public Pawn(int x, int y) {
        super(x, y);
    }

    @Override
    public void setTex() {
        batch.draw(texPawnw, this.x, this.y);
    }


    @Override
    public boolean proverka(int x, int y) {
        if (y - this.y == 1 && x - this.x == 0 || y - this.y == 2 && x - this.x == 0 && this.y <= 1) {
            return true;
        }
        return false;
    }

    @Override
    public void setPosition(int x, int y) {
        if (y - this.y == 1 && x - this.x == 0 || y - this.y == 2 && x - this.x == 0 && this.y <= 1) {

            this.y = y;
        }
    }
}


