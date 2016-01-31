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
    Texture boxField;

    FigureFactory figures = new FigureFactory('w');
    Box box = new Box('w');

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
        boxField = new Texture("box.jpg");
    }

    @Override
    public void render() {
        update();
        Gdx.gl.glClearColor(0, 0, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        //рисуем поле
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 != 0) {
                    batch.draw(pole, j * 60, i * 60, 0, 0, 60, 60);
                } else {
                    batch.draw(pole, j * 60, i * 60, 60, 0, 60, 60);
                }
            }
        }

        //рисуем ящики
        batch.draw(boxField,490,370,200,100);
        batch.draw(boxField,490,20,200,100);

        //рисуем фигуры
        for (Figure figure: figures.white) {
            Texture texture = new Texture(figure.getName() + figures.getColor() + ".png");
            batch.draw(texture, figure.getX() * 60, figure.getY() * 60);
            field.setXO(figure.getY(), figure.getX(), figure);
        }

        //рисуем срубленые фигуры
        int l = 0;
        for (Figure figure: box.whiteBox) {
            l=l+10;
            Texture texture1 = new Texture(figure.getName() + figures.getColor() + ".png");
            batch.draw(texture1, 480 + (l), 380, 30, 30);
        }

        if (selectIndex > -1) {
            Texture texture = new Texture(figures.white.get(selectIndex).getName() + figures.getColor() + ".png");
            batch.draw(texture, mouseX - 30, mouseY - 30);
            for (int i = 0; i < figures.white.get(selectIndex).getPodsvetka().size(); i++) {
                batch.draw(lightField, figures.white.get(selectIndex).getPodsvetka().get(i).getX() * 60, figures.white.get(selectIndex).getPodsvetka().get(i).getY() * 60);
            }

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

        //1-определяем нажата ли мышка;2-добавляем в ArrayList ящика срубленную фигуру;3-удаляем срубленную фигуру с ArrayList фигур
        if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT) && selectIndex > -1 && figures.white.get(selectIndex).isChangePosition(mouseCellX, mouseCellY)){
            Box.whiteBox.add(figures.white.get(selectIndex));
            figures.white.remove(figures.white.get(selectIndex));
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

