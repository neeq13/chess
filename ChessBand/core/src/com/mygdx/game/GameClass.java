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
    FigureFactory figures = new FigureFactory('w'); // массив армии белых ('w'). TODO: массив армии чёрных - отзеркалить
    Field field = new Field();
    /*
    ** Перемещение мыши и определение клеток
     */
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

        lightField = new Texture("allocation.png");
        figures.initFigure();
        // Каждой фигуре автоматическе присваивается текстура
        for (Figure fig : figures.army) {
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
        //отрисовка первоначального расположения фигур
        for (Figure figure: figures.army) {
            batch.draw(figure.getFigtex(), figure.getX() * 60, figure.getY() * 60);
            field.setXO(figure.getY(), figure.getX(), figure);
        }
        // отрисовка отмеченной фигуры
        if (selectIndex > -1) {
            Texture texture = new Texture(figures.army.get(selectIndex).getName() + figures.getColor() + ".png");
            batch.draw(texture, mouseX - 30, mouseY - 30);
            for (int i = 0; i < figures.army.get(selectIndex).getLighting().size(); i++) {
                batch.draw(lightField, figures.army.get(selectIndex).getLighting().get(i).getX() * 60, figures.army.get(selectIndex).getLighting().get(i).getY() * 60);
            }
            //batch.draw(texture, figures.army.get(selectIndex).getX() * 60, figures.army.get(selectIndex).getY() * 60);
            batch.draw(texture, mouseX - 30, mouseY - 30);
        }

        batch.end();
    }

    public void update() {
        mouseX = Gdx.input.getX();
        mouseY = 480 - Gdx.input.getY();
        mouseCellX = mouseX / 60;
        mouseCellY = mouseY / 60;

        //поиск фигуры, на которую щёлкнули
        if (selectIndex == -1) {
            for (int i = 0; i < figures.army.size(); i++) {
                if (figures.army.get(i).getX() == mouseCellX && figures.army.get(i).getY() == mouseCellY && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    figures.army.get(i).light();
                    selectIndex = i;
                    break;
                }
            }
        }

        // ходим фигурами
        if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT) && selectIndex > -1 &&
                figures.army.get(selectIndex).isChangePosition(mouseCellX, mouseCellY)) {
            field.setXO(figures.army.get(selectIndex).getY(), figures.army.get(selectIndex).getX(), null);
            if (mouseCellX >= 0 && mouseCellY >= 0 && mouseCellX < 8 && mouseCellY < 8) {//Условие запрета выхода за границу поля
                figures.army.get(selectIndex).setPosition(mouseCellX, mouseCellY);
            }
            figures.army.get(selectIndex).resetLight(); // сбрасываем подсветку возможных ходов
            selectIndex = -1; // сбрасываем индекс отмеченной фигуры
        }
    }
}

