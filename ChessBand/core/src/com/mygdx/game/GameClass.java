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
//    Pawn pawn = new Pawn(1,1);

//хочу массивы с фигурами перенести в класс фигур фактори
//    public static Figure[] white = new Figure[16];
//    public static Figure[] black = new Figure[16];


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
//Ura)))
        for (Figure figura : ff.white) {
            batch.draw(pown, figura.getX() * 60, figura.getY() * 60);
        }

        if (selectIndex > -1) {
            for (int i = 0; i < ff.white.get(selectIndex).getPodsvetka().size(); i++) {
                batch.draw(lightField, ff.white.get(selectIndex).getPodsvetka().get(i).getX()* 60, ff.white.get(selectIndex).getPodsvetka().get(i).getY() * 60);
            }
            batch.draw(smileEnd, ff.white.get(selectIndex).getX() * 60, ff.white.get(selectIndex).getY() * 60);
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
            for (int i = 0; i < ff.white.size(); i++) {
                if (ff.white.get(i).getX() == mouseCellX && ff.white.get(i).getY() == mouseCellY && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    ff.white.get(i).light();
                    selectIndex = i;
                    break;
                }
            }
        }

        if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT) && selectIndex > -1) {
            if (mouseCellX >= 0 && mouseCellY >= 0 && mouseCellX < 8 && mouseCellY < 8)//Условие запрета выхода за границу поля
                ff.white.get(selectIndex).setPosition(mouseCellX, mouseCellY);
            ff.white.get(selectIndex).resetLight();
            selectIndex = -1;

        }
    }

}
