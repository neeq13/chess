package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Figurs.Figure;
import com.mygdx.game.Figurs.Rook;

public class GameClass extends ApplicationAdapter {
    SpriteBatch batch;
    Texture pole;
    Texture smile;
    Texture smileEnd;



    Figure[] white = new Figure[8];


    int mouseX;
    int mouseY;
    int mouseCellX;
    int mouseCellY;


    int selectIndex = -1;

    @Override
    public void create() {
        batch = new SpriteBatch();
        pole = new Texture("pole.png");
        smile = new Texture("smile.png");
        smileEnd = new Texture("smileEnd.png");

        for (int i = 0; i < 8; i++) {
            white[i] = new Rook(i, 0);
        }
    }

    @Override
    public void render() {
        update();
        Gdx.gl.glClearColor(0, 0, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 != 0) {
                    batch.draw(pole, j * 60, i * 60, 0, 0, 60, 60);
                } else {
                    batch.draw(pole, j * 60, i * 60, 60, 0, 60, 60);
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            if (i == selectIndex) continue;
            batch.draw(smile, white[i].getX() * 60, white[i].getY() * 60);
        }

        if (selectIndex > -1) {
            //batch.draw(smileEnd, white[selectIndex].getX() * 60, white[selectIndex].getY() * 60);
            batch.draw(smile, mouseX - 30, mouseY - 30);
        }
        batch.end();
    }


    public void update() {
        mouseX = Gdx.input.getX();
        mouseY = 480 - Gdx.input.getY();

        mouseCellX = mouseX / 60;
        mouseCellY = mouseY / 60;


        if (selectIndex == -1) {
            for (int i = 0; i < 8; i++) {
                if (white[i].getX() == mouseCellX && white[i].getY() == mouseCellY && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    selectIndex = i;
                    break;
                }
            }
        }

        if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT) && selectIndex > -1) {
            white[selectIndex].setPosition(mouseCellX, mouseCellY);
            selectIndex = -1;
        }
    }

}
