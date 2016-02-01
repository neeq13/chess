package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameClass extends ApplicationAdapter {
    SpriteBatch batch;
    Texture field;
    GameInit newGame;

    @Override
    public void create () {
        batch = new SpriteBatch();
        field = new Texture("field.png");
        newGame = new GameInit();

    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        batch.draw(field, 0, 0);

        for (int i = 0; i <newGame.figures.size() ; i++) {
            batch.draw(newGame.figures.get(i).getTexture(), newGame.figures.get(i).getX() * 60, newGame.figures.get(i).getY() * 60);
        }

        batch.end();
    }
}
