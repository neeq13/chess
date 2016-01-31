package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameClass extends ApplicationAdapter {
    SpriteBatch batch;
    Texture field;

    @Override
    public void create () {
        batch = new SpriteBatch();
        field = new Texture("size.png");
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0)
                    batch.draw(field, i * 60, j * 60, 60, 0, 60, 60);
                else
                    batch.draw(field, i * 60, j * 60, 0, 0, 60, 60);
            }
        }

        batch.end();
    }
}
