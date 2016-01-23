package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ChessGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture texSize;
	Texture texSpawn;
	Texture texAllocation;
	int mouseX = 0;
	int mouseY = 0;
	int courseMouseX;
	int courseMouseY;

	Figure fg;


	@Override
	public void create() {
		batch = new SpriteBatch();
		texSize = new Texture("size.png");
		texSpawn = new Texture("spawn.png");
		texAllocation = new Texture("allocation.png");
		fg = new Figure();
	}

	@Override
	public void render() {
		update();
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.8f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();


		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				batch.draw(texSize, i * 60, j * 60, (i + j) % 2 != 0 ? 0 : 60, 0, 60, 60);//исправил вчерашнее
			}

		}
		for (int i = 0; i < 8; i++) {
			fg.corse(i, 1);
			batch.draw(texSpawn, fg.getX(), fg.getY());
		}

		batch.draw(texAllocation, courseMouseX * 60, courseMouseY * 60);

		batch.end();
	}

	public void update() {

		mouseX = Gdx.input.getX() /*- 60 / 2*/;
		mouseY = 480 - Gdx.input.getY() /*- 60 / 2*/;

		courseMouseX = mouseX / 60;
		courseMouseY = mouseY / 60;


	}
}
