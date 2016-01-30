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

    ArrayList<Figure> figures = new ArrayList();
    Field field = new Field();

    int mouseX;
    int mouseY;
    int mouseCellX;
    int mouseCellY;
    int vx;
    int vy;
    int length = 0;
    int pawns = 8;
    int selectIndex = -1;



    @Override
    public void create() {

        batch = new SpriteBatch();
        pole = new Texture("size.png");
        Field.initField();
        Field.printField();
        lightField = new Texture("allocation.png");

        for (int i = 0; i < pawns; i++) {
            figures.add(new Pawn('w', i, Field.getFieldSize() - 7));
            figures.add(new Pawn('b', i, Field.getFieldSize() - 2));
        }
        for (int i = 0; i < 1; i++) {
            figures.add(new Rook('w', 0, 0));
            figures.add(new Rook('b', 0, 7));
            figures.add(new Rook('w', 7, 0));
            figures.add(new Rook('b', 7, 7));
            figures.add(new Knight('w', 1, 0));
            figures.add(new Knight('b', 1, 7));
            figures.add(new Knight('w', 6, 0));
            figures.add(new Knight('b', 6, 7));
            figures.add(new Bishop('w', 2, 0));
            figures.add(new Bishop('b', 2, 7));
            figures.add(new Bishop('w', 5, 0));
            figures.add(new Bishop('b', 5, 7));
            figures.add(new King('w', 4, 0));
            figures.add(new Queen('w', 3, 0));
            figures.add(new King('b', 4, 7));
            figures.add(new Queen('b', 3, 7));


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

        for (Figure figure:figures) {
            Texture texture = new Texture(figure.getName() + figure.getColor() + ".png");
            batch.draw(texture, figure.getX() * 60, figure.getY() * 60);
            field.setXO(figure.getY(), figure.getX(), figure);
        }
        //field.printField();

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
                }
            }
        }

        if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT) && selectIndex > -1) {
            int lengthY = Math.abs(mouseCellY - figures.get(selectIndex).getY());
            int lengthX = Math.abs(mouseCellX - figures.get(selectIndex).getX());
            length = (lengthY > lengthX)? lengthY : lengthX;

            if (mouseCellX - figures.get(selectIndex).getX() > 0) {
                vx = 1;
            } else if (mouseCellX - figures.get(selectIndex).getX() < 0) {
                vx = -1;
            } else {
                vx = 0;
            }
            if (mouseCellY - figures.get(selectIndex).getY() > 0) {
                vy = 1;
            } else if (mouseCellY - figures.get(selectIndex).getY() < 0) {
                vy = -1;
            } else {
                vy = 0;
            }

            if(figures.get(selectIndex).isChangePosition(mouseCellX, mouseCellY)&& field.isCellEmpty(mouseCellY, mouseCellX)) {
                field.setXO(figures.get(selectIndex).getY(), figures.get(selectIndex).getX(), null);
                if((field.checkLine(figures.get(selectIndex).getY(), figures.get(selectIndex).getX(), vx, vy, length))||
                        (figures.get(selectIndex).getShName() == 'N')) {
                    /*
                    ** заготовка для рокировки
                    ** TODO: проверить что линия свободна (в ту сторону, куда пошла мышь)
                    * найти на последней клетке ладью
                    * проверить, чтобы ладья не ходила
                    * проверить, чтобы не было шаха
                    * проверить, чтобы поле не было под ударом
                    * переместить короля и ладью
                     */
                    if ((figures.get(selectIndex).getShName() == 'K') && (!figures.get(selectIndex).isHasMoved())) {
                        System.out.println("Можно делать рокировку ");
                    }
                    figures.get(selectIndex).setPosition(mouseCellX, mouseCellY);
                    figures.get(selectIndex).setHasMoved(true);
                    field.setXO(mouseCellY, mouseCellX, figures.get(selectIndex));
                }
            }
            selectIndex = -1;
        }
    }

}
