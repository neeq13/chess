package com.mygdx.game.Figurs;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Pawn extends Figure implements ApplicationListener {
    Texture texPawnw;
    Texture texPawnb;
    public Pawn(int x, int y) {
        super(x, y);
        texPawnw = new Texture("pawmw.png");
        texPawnb = new Texture("pawmw.png");


    }


    @Override
    public boolean proverka(int x, int y) {
        if (y - this.y == 1 && x - this.x == 0 || y - this.y == 2 && x - this.x == 0 && this.y <= 1){
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


    @Override
    public void create() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
