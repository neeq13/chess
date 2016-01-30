package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Figurs.*;

public class GameClass extends ApplicationAdapter {
    SpriteBatch batch;
    Texture pole;
    Texture smile;
    Texture smileEnd;
    Texture pawnW;
    Texture allocation;
    Texture bishopW;
    Texture knightW;
    Texture kingW;


    Figure[] white = new Figure[11];


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
        pawnW = new Texture("pawnw.png");
        bishopW = new Texture("bishopw.png");
        allocation = new Texture("allocation.png");
        knightW = new Texture("knightw.png");
        kingW = new Texture("kingw.png");

        for (int i = 0; i < 8; i++) {
            white[i] = new Pawn(i, 1, pawnW, true);
        }
        white[8] = new Bishop(3, 5, bishopW, true);
        white[9] = new Knight(5, 0, knightW, true);
        white[10] = new King(0, 7, kingW, true);
        ;


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
            batch.draw(white[i].getTexture(), white[i].getX() * 60, white[i].getY() * 60);
        }

        batch.draw(white[8].getTexture(), white[8].getX() * 60, white[8].getY() * 60);
        batch.draw(white[9].getTexture(), white[9].getX() * 60, white[9].getY() * 60);
        batch.draw(white[10].getTexture(), white[10].getX() * 60, white[10].getY() * 60);

        if (selectIndex > -1) {
            batch.draw(white[selectIndex].getTexture(), white[selectIndex].getX() * 60, white[selectIndex].getY() * 60);

            paintAllocation(white[selectIndex].availableMoves());

        }
        batch.end();
    }


    public void update() {
        mouseX = Gdx.input.getX();
        mouseY = 480 - Gdx.input.getY();

        mouseCellX = mouseX / 60;
        mouseCellY = mouseY / 60;


        if (selectIndex == -1) {
            for (int i = 0; i < white.length; i++) {
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

    private void paintAllocation(int[][] stroke) {
        for (int i = 0; i < stroke.length; i++) {
            for (int j = 0; j < stroke.length; j++) {
                if (stroke[i][j] != 0) {
                    batch.draw(allocation, j * 60, i * 60);
                }
            }
        }
    }

}
