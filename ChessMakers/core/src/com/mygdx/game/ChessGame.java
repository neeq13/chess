package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ChessGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture texSize;
    Texture texSpawn;
    Texture texAllocation;
    int mouseX;
    int mouseY;
    int courseMouseX;
    int courseMouseY;
    boolean mousePressed;
    boolean dragging;
    int xv;
    int yv;

    Figure fg1, fg2;


    @Override
    public void create() {
        batch = new SpriteBatch();
        texSize = new Texture("size.png");
        texSpawn = new Texture("spawn.png");
        texAllocation = new Texture("allocation.png");
        fg1 = new Rook(1, 2);
        fg2 = new Rook(3, 2);
    }

    @Override
    public void render() {

        update();

        Gdx.gl.glClearColor(0.0f, 0.0f, 0.8f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                batch.draw(texSize, i * 60, j * 60, (i + j) % 2 != 0 ? 0 : 60, 0, 60, 60);//условие отрисовки игрового поля
            }

        }
        //for (int i = 0; i < 8; i++) {

        //batch.draw(texSpawn,fg.getX(),fg.getY());
        //}
        if (dragging) {
            batch.draw(texSpawn, mouseX, mouseY);
        } else {
            batch.draw(texSpawn, fg1.getX() * 60, fg1.getY() * 60);
        }
        //batch.draw(texAllocation, courseMouseX * 60, courseMouseY * 60);

        batch.end();
    }

    public void update() {

        mouseX = Gdx.input.getX();
        mouseY = 480 - Gdx.input.getY();

        courseMouseX = mouseX / 60;
        courseMouseY = mouseY / 60;

       /* if (courseMouseX * 60 == fg.getX() && courseMouseY * 60 == fg.getY() && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {//передвигает фигуру в пределах одной клетки
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                xv = mouseX;
                yv = mouseY;
            }
            //fg.setX(xv);
            //fg.setY(yv);
        }*/
        if (fg1.getX() == courseMouseX && fg1.getY() == courseMouseY && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {

            dragging = true;
        }

        if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT) && dragging) {
            dragging = false;
            fg1.setCores(courseMouseX, courseMouseY);


        }

    }
}
