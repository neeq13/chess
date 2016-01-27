package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Figurs.*;

import java.util.ArrayList;

public class GameClass extends ApplicationAdapter {
    SpriteBatch batch;
    Texture chessDesk;
    Texture pawnw;
    Texture pawnb;
    Texture rookw;
    Texture rookb;
    Texture knightw;
    Texture knightb;
    Texture bishopw;
    Texture bishopb;
    Texture kingw;
    Texture kingb;
    Texture queenw;
    Texture queenb;


    ArrayList<Figure> white = new ArrayList<Figure>();
    ArrayList<Figure> black = new ArrayList<Figure>();


    int mouseX;
    int mouseY;
    int mouseCellX;
    int mouseCellY;


    int selectIndex = -1;


    @Override
    public void create() {
        batch = new SpriteBatch();
        chessDesk = new Texture("chessDesk.png");
        pawnw = new Texture("pawnw.png");
        pawnb = new Texture("pawnb.png");
        rookw = new Texture("rookw.png");
        rookb = new Texture("rookb.png");
        knightw = new Texture("knightw.png");
        knightb = new Texture("knightb.png");
        bishopw = new Texture("bishopw.png");
        bishopb = new Texture("bishopb.png");
        kingw = new Texture("kingw.png");
        kingb = new Texture("kingb.png");
        queenw = new Texture("queenw.png");
        queenb = new Texture("queenb.png");

        for (int i = 0; i < 8; i++) {
            white.add(new Pawn(i, 1));
        }
        white.add(new Rook(0, 0));
        white.add(new Rook(7, 0));
        white.add(new Knight(1, 0));
        white.add(new Knight(6, 0));
        white.add(new Bishop(2, 0));
        white.add(new Bishop(5, 0));
        white.add(new King(4, 0));
        white.add(new Queen(3, 0));

        for (int i = 0; i < 8; i++) {
            black.add(new Pawn(i, 6));
        }
        black.add(new Rook(0, 7));
        black.add(new Rook(7, 7));
        black.add(new Knight(1, 7));
        black.add(new Knight(6, 7));
        black.add(new Bishop(2, 7));
        black.add(new Bishop(5, 7));
        black.add(new King(4, 7));
        black.add(new Queen(3, 7));
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
                    batch.draw(chessDesk, j * 60, i * 60, 0, 0, 60, 60);
                } else {
                    batch.draw(chessDesk, j * 60, i * 60, 60, 0, 60, 60);
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            batch.draw(pawnw, white.get(i).getX() * 60, white.get(i).getY() * 60);
            batch.draw(pawnb, black.get(i).getX() * 60, black.get(i).getY() * 60);
        }
        batch.draw(rookw, white.get(8).getX() * 60, white.get(8).getY() * 60);
        batch.draw(rookw, white.get(9).getX() * 60, white.get(9).getY() * 60);
        batch.draw(rookb, black.get(8).getX() * 60, black.get(8).getY() * 60);
        batch.draw(rookb, black.get(9).getX() * 60, black.get(9).getY() * 60);
        batch.draw(knightw, white.get(10).getX() * 60, white.get(10).getY() * 60);
        batch.draw(knightw, white.get(11).getX() * 60, white.get(11).getY() * 60);
        batch.draw(knightb, black.get(10).getX() * 60, black.get(10).getY() * 60);
        batch.draw(knightb, black.get(11).getX() * 60, black.get(11).getY() * 60);
        batch.draw(bishopw, white.get(12).getX() * 60, white.get(12).getY() * 60);
        batch.draw(bishopw, white.get(13).getX() * 60, white.get(13).getY() * 60);
        batch.draw(bishopb, black.get(12).getX() * 60, black.get(12).getY() * 60);
        batch.draw(bishopb, black.get(13).getX() * 60, black.get(13).getY() * 60);
        batch.draw(kingw, white.get(14).getX() * 60, white.get(14).getY() * 60);
        batch.draw(kingb, black.get(14).getX() * 60, black.get(14).getY() * 60);
        batch.draw(queenw, white.get(15).getX() * 60, white.get(15).getY() * 60);
        batch.draw(queenb, black.get(15).getX() * 60, black.get(15).getY() * 60);

        /*for (int i = 0; i < 8; i++) {
            if (i == selectIndex) continue;
            batch.draw(pawnw, white.get(i).getX() * 60, white.get(i).getY() * 60);
        }

        if (selectIndex > -1) {
            //batch.draw(smileEnd, white[selectIndex].getX() * 60, white[selectIndex].getY() * 60);
            batch.draw(pawnw, mouseX - 30, mouseY - 30);
        }*/
        batch.end();
    }


    public void update() {
        mouseX = Gdx.input.getX();
        mouseY = 480 - Gdx.input.getY();

        mouseCellX = mouseX / 60;
        mouseCellY = mouseY / 60;


        /*if (selectIndex == -1) {
            for (int i = 0; i < 8; i++) {
                if (white.get(i).getX() == mouseCellX && white.get(i).getY() == mouseCellY && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    selectIndex = i;
                    break;
                }
            }
        }

        if (!Gdx.input.isButtonPressed(Input.Buttons.LEFT) && selectIndex > -1) {
            white.get(selectIndex).setPosition(mouseCellX, mouseCellY);
            selectIndex = -1;
        }*/
    }

}
