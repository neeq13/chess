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
    Texture pownb;
    Texture pown;
    Texture queenb;
    Texture queen;
    Texture kingb;
    Texture king;
    Texture rookb;
    Texture rook;
    Texture knightb;
    Texture knight;
    Texture bisopb;
    Texture bisop;
    Texture smileEnd;
    Texture lightField;

    FigureFactory ff = new FigureFactory();
    Pawn pawn = new Pawn(1,1);


    public static Figure[] white = new Figure[16];
    public static Figure[] black = new Figure[16];


    int mouseX;
    int mouseY;
    int mouseCellX;
    int mouseCellY;


    int selectIndex = -1;


    @Override
    public void create() {
        batch = new SpriteBatch();
        pole = new Texture("size.png");
        pown = new Texture("pawnw.png");
        queen = new Texture("queenw.png");
        king = new Texture("kingw.png");
        knight = new Texture("knightw.png");
        rook = new Texture("rookw.png");
        bisop = new Texture("bishopw.png");
        pownb = new Texture("pawnb.png");
        queenb = new Texture("queenb.png");
        kingb = new Texture("kingb.png");
        knightb = new Texture("knightb.png");
        rookb = new Texture("rookb.png");
        bisopb = new Texture("bishopb.png");
        smileEnd = new Texture("smileEnd.png");
        lightField = new Texture("allocation.png");

        ff.initFigure();
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
        for (int i = 8; i < white.length; i++) {
            if (i == selectIndex) continue;
            batch.draw(pown, white[i].getX() * 60, white[i].getY() * 60);
            batch.draw(king, white[0].getX() * 60, white[0].getY() * 60);
            batch.draw(queen, white[1].getX() * 60, white[1].getY() * 60);
            batch.draw(rook, white[2].getX() * 60, white[2].getY() * 60);
            batch.draw(rook, white[3].getX() * 60, white[3].getY() * 60);
            batch.draw(knight, white[4].getX() * 60, white[4].getY() * 60);
            batch.draw(knight, white[5].getX() * 60, white[5].getY() * 60);
            batch.draw(bisop, white[6].getX() * 60, white[6].getY() * 60);
            batch.draw(bisop, white[7].getX() * 60, white[7].getY() * 60);
//            pawn.setTex();
        }
//        for (int i = 8; i < black.length; i++) {
//            if (i == selectIndex) continue;
//            batch.draw(pownb, black[i].getX() * 60, black[i].getY() * 60);
//        }

        if (selectIndex > -1) {
            for (int i = 0; i < white[selectIndex].getKeyX().size(); i++) {
                batch.draw(lightField, white[selectIndex].getKeyX().get(i) * 60, white[selectIndex].getKeyY().get(i) * 60);
            }
            batch.draw(smileEnd, white[selectIndex].getX() * 60, white[selectIndex].getY() * 60);
            batch.draw(pown, mouseX - 30, mouseY - 30);
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
                    white[i].light();
                    selectIndex = i;
                    break;
                }
            }
        }

        if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT) && selectIndex > -1) {
            if (mouseCellX >= 0 && mouseCellY >= 0 && mouseCellX < 8 && mouseCellY < 8)//Условие запрета выхода за границу поля
                white[selectIndex].setPosition(mouseCellX, mouseCellY);
            white[selectIndex].resetLight();
            selectIndex = -1;

        }
    }

}
