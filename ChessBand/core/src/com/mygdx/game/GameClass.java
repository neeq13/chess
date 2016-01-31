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
    Texture lightField;

    FigureFactory figures = new FigureFactory('w');

    Field field = new Field();

    int mouseX;
    int mouseY;
    int mouseCellX;
    int mouseCellY;
    int selectIndex = -1;

    @Override
    public void create() {

        batch = new SpriteBatch();
        pole = new Texture("size.png");
        Field.initField();
        Field.printField();
        lightField = new Texture("allocation.png");
        figures.initFigure();
        for (Figure fig : figures.white) {
            fig.setFigtex(new Texture(fig.getName() + figures.getColor() + ".png"));
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

        for (Figure figure: figures.white) {
            batch.draw(figure.getFigtex(), figure.getX() * 60, figure.getY() * 60);
            field.setXO(figure.getY(), figure.getX(), figure);
        }

        //field.printField();

        if (selectIndex > -1) {
            Texture texture = new Texture(figures.white.get(selectIndex).getName() + figures.getColor() + ".png");
            batch.draw(texture, mouseX - 30, mouseY - 30);
            for (int i = 0; i < figures.white.get(selectIndex).getPodsvetka().size(); i++) {
                batch.draw(lightField, figures.white.get(selectIndex).getPodsvetka().get(i).getX() * 60, figures.white.get(selectIndex).getPodsvetka().get(i).getY() * 60);
            }
            //batch.draw(texture, figures.white.get(selectIndex).getX() * 60, figures.white.get(selectIndex).getY() * 60);
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
            for (int i = 0; i < figures.white.size(); i++) {
                if (figures.white.get(i).getX() == mouseCellX && figures.white.get(i).getY() == mouseCellY && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    figures.white.get(i).light();
                    selectIndex = i;
                    break;
                }
            }
        }

        if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT) && selectIndex > -1 &&
                figures.white.get(selectIndex).isChangePosition(mouseCellX, mouseCellY)) {
            field.setXO(figures.white.get(selectIndex).getY(), figures.white.get(selectIndex).getX(), null);
            if (mouseCellX >= 0 && mouseCellY >= 0 && mouseCellX < 8 && mouseCellY < 8) {//Условие запрета выхода за границу поля
                figures.white.get(selectIndex).setPosition(mouseCellX, mouseCellY);

            }
            figures.white.get(selectIndex).resetLight();
            selectIndex = -1;
        }
    }
}

