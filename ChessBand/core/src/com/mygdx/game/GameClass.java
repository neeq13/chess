package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Figurs.*;

import java.util.ArrayList;

public class GameClass extends ApplicationAdapter {
    SpriteBatch batch;
    Texture pole;
    Texture lightField;

    public static Figure[] white = new Figure[32];
    ArrayList<Figure> figures = new ArrayList();
    Field field = new Field();

    int mouseX;
    int mouseY;
    int mouseCellX;
    int mouseCellY;
    int pawns = 8;
    int rooks = 2;
    int bishops = 2;
    int knights = 2;

    int selectIndex = -1;



    @Override
    public void create() {

        batch = new SpriteBatch();
        pole = new Texture("size.png");
        Field.initField();
        Field.printField();
        lightField = new Texture("allocation.png");

        for (int i = 0; i < pawns; i++) {
            figures.add(new Pawn("pawn", 'w', i, Field.getFieldSize() - 7));
            figures.add(new Pawn("pawn", 'b', i, Field.getFieldSize() - 2));
        }
        for (int i = 0; i < 1; i++) {
            figures.add(new Rook("rook", 'w', 0, 0));
            figures.add(new Rook("rook", 'b', 0, 7));
        }

        /*
        white[16] = new Rook("rook", 'w', 0, 0);
        white[17] = new Rook("rook", 'w', 7, 0);
        white[18] = new Rook("rook", 'b', 0, 7);
        white[19] = new Rook("rook", 'b', 7, 7);

        white[20] = new Knight("knight", 'w', 1, 0);
        white[21] = new Knight("knight", 'w', 6, 0);
        white[22] = new Knight("knight", 'b', 1, 7);
        white[23] = new Knight("knight", 'b', 6, 7);
        white[24] = new Bishop("bishop", 'w', 2, 0);
        white[25] = new Bishop("bishop", 'w', 5, 0);
        white[26] = new Bishop("bishop", 'b', 2, 7);
        white[27] = new Bishop("bishop", 'b', 5, 7);
        white[28] = new Queen("queen", 'w', 3, 0);
        white[29] = new Queen("queen", 'b', 3, 7);
        white[30] = new King("king", 'w', 4, 0);
        white[31] = new King("king", 'b', 4, 7);


        for (int i = 0; i < white.length; i++) {
            figures.add(white[i]);

        }
*/
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

        for (Figure figure:figures) {
            //if (iguri == selectIndex) continue;
            Texture texture = new Texture(figure.getName() + figure.getColor() + ".png");
            batch.draw(texture, figure.getX() * 60, figure.getY() * 60);
            field.setXO(figure.getY(), figure.getX(), figure.getShName());
        }
        field.printField();

        if (selectIndex > -1) {
            Texture texture = new Texture(figures.get(selectIndex).getName() + figures.get(selectIndex).getColor() + ".png");
            batch.draw(texture, mouseX - 30, mouseY - 30);
        }

        batch.end();
    }

    public void update() {
        mouseX = Gdx.input.getX();
        mouseY = 480 - Gdx.input.getY();
        mouseCellX = mouseX / 60;
        mouseCellY = mouseY / 60;

        if (selectIndex == -1) {
            for (Figure figure : figures) {
                if (figure.getX() == mouseCellX && figure.getY() == mouseCellY && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    selectIndex = figures.indexOf(figure);
                    break;
                }
            }
        }

        if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT) && selectIndex > -1) {
            if(figures.get(selectIndex).isChangePosition(mouseCellX, mouseCellY)&& field.isCellEmpty(mouseCellY, mouseCellX)) {
                field.setXO(figures.get(selectIndex).getY(), figures.get(selectIndex).getX(), '*');
                figures.get(selectIndex).setPosition(mouseCellX, mouseCellY);
                field.setXO(mouseCellY, mouseCellX, figures.get(selectIndex).getShName());
            }
            selectIndex = -1;
        }
    }

}
