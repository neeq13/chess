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
    Texture smileEnd;
    Texture lightField;

    FigureFactory figures = new FigureFactory();

    Field field = new Field();

    int mouseX;
    int mouseY;
    int mouseCellX;
    int mouseCellY;
    int vx;
    int vy;
    int length = 0;
    int selectIndex = -1;

    @Override
    public void create() {

        batch = new SpriteBatch();
        pole = new Texture("size.png");
        Field.initField();
        Field.printField();
        lightField = new Texture("allocation.png");
        figures.initFigure();
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
            Texture texture = new Texture(figure.getName() + figure.getColor() + ".png");
            batch.draw(texture, figure.getX() * 60, figure.getY() * 60);
            field.setXO(figure.getY(), figure.getX(), figure);
        }

        //field.printField();

        if (selectIndex > -1) {
            Texture texture = new Texture(figures.white.get(selectIndex).getName() + figures.white.get(selectIndex).getColor() + ".png");
            //System.out.println(texture);
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

//      if (selectIndex == -1)
//          for (Figure figure : figures.white) {
//            if (figure.getX() == mouseCellX && figure.getY() == mouseCellY && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
//                selectIndex = figures.white.indexOf(figure);
//                for (int i = 0; i < figures.white.size(); i++) {
//                    if (figures.white.get(i).getX() == mouseCellX && figures.white.get(i).getY() == mouseCellY && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
//                        figures.white.get(i).light();
//                        selectIndex = i;
//                        break;
//                    }
//                }
//            }
//        }
        if (selectIndex == -1) {
            for (int i = 0; i < figures.white.size(); i++) {
                if (figures.white.get(i).getX() == mouseCellX && figures.white.get(i).getY() == mouseCellY && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    figures.white.get(i).light();
                    selectIndex = i;
                    break;
                }
            }
        }


        if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT) && selectIndex > -1) {
//            int lengthY = Math.abs(mouseCellY - figures.white.get(selectIndex).getY());
//            int lengthX = Math.abs(mouseCellX - figures.white.get(selectIndex).getX());
//            length = (lengthY > lengthX) ? lengthY : lengthX;
//            int rokirovkaLength = field.getFieldSize() - 4;
//
//            if (mouseCellX - figures.white.get(selectIndex).getX() > 0) {
//                vx = 1;
//                --rokirovkaLength;
//                //char rookFind = field[field.getFieldSize()]
//            } else if (mouseCellX - figures.white.get(selectIndex).getX() < 0) {
//                vx = -1;
//            } else {
//                vx = 0;
//            }
//            if (mouseCellY - figures.white.get(selectIndex).getY() > 0) {
//                vy = 1;
//            } else if (mouseCellY - figures.white.get(selectIndex).getY() < 0) {
//                vy = -1;
//            } else {
//                vy = 0;
//            }
//
//            if (figures.white.get(selectIndex).isChangePosition(mouseCellX, mouseCellY) && field.isCellEmpty(mouseCellY, mouseCellX)) {
//                field.setXO(figures.white.get(selectIndex).getY(), figures.white.get(selectIndex).getX(), null);
//                if ((field.checkLine(figures.white.get(selectIndex).getY(), figures.white.get(selectIndex).getX(), vx, vy, length)) ||
//                        (figures.white.get(selectIndex).getShName() == 'N')) {
//                    /*
//                    ** заготовка для рокировки
//                    ** TODO: проверить что линия свободна (в ту сторону, куда пошла мышь)+
//                    * найти на последней клетке ладью+
//                    * проверить, чтобы ладья не ходила+
//                    * проверить, чтобы не было шаха
//                    * проверить, чтобы поле не было под ударом
//                    * переместить короля и ладью
//                     */
//                    if ((figures.white.get(selectIndex).getShName() == 'K') &&
//                            (!figures.white.get(selectIndex).isHasMoved()) &&
//                            (field.checkLine(figures.white.get(selectIndex).getY(), figures.white.get(selectIndex).getX(), vx, 0, rokirovkaLength))) {
//                        for (Figure rook : figures.white) { //не нравится, надо сделать поле, которое в клетку помещает объект, чтобы можно было извлечь легко
//                            int newX = figures.white.get(selectIndex).getX() + rokirovkaLength * vx;
//                            int newY = figures.white.get(selectIndex).getY();
//                            if (rook.getX() == newX && rook.getY() == newY && rook.getName() == "rook" &&
//                                    rook.getColor() == figures.white.get(selectIndex).getColor() && !rook.isHasMoved()) {
//                                System.out.println("Это ладья");
//                            }
//                        }
//                        System.out.println("Можно делать рокировку ");
//
//                    }
//                    figures.white.get(selectIndex).setPosition(mouseCellX, mouseCellY);
//                    figures.white.get(selectIndex).setHasMoved(true);
//                    field.setXO(mouseCellY, mouseCellX, figures.white.get(selectIndex));
//                }
//            }

            if (mouseCellX >= 0 && mouseCellY >= 0 && mouseCellX < 8 && mouseCellY < 8)//Условие запрета выхода за границу поля
                figures.white.get(selectIndex).setPosition(mouseCellX, mouseCellY);
            figures.white.get(selectIndex).resetLight();

            selectIndex = -1;

        }
    }
}
