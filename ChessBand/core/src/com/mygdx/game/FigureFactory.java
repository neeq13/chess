package com.mygdx.game;

import com.mygdx.game.Figurs.*;

/**
 * Created by Белл on 27.01.2016.
 */
public class FigureFactory {

    public FigureFactory(){

    }

    public void initFigure(){
        GameClass.white[0] = new King(4, 0);
        GameClass.white[1] = new Queen(3, 0);
        GameClass.white[2] = new Rook(0, 0);
        GameClass.white[3] = new Rook(7, 0);
        GameClass.white[4] = new Knight(2, 0);
        GameClass.white[5] = new Knight(5, 0);
        GameClass.white[6] = new Bishop(1, 0);
        GameClass.white[7] = new Bishop(6, 0);
        for (int i = 0; i < 8; i++) {
            GameClass.white[8+i] = new Pawn(i, 1);
        }

        GameClass.black[0] = new King(4, 7);
        GameClass.black[1] = new Queen(3, 7);
        GameClass.black[2] = new Rook(0, 7);
        GameClass.black[3] = new Rook(7, 7);
        GameClass.black[4] = new Knight(2, 7);
        GameClass.black[5] = new Knight(5, 7);
        GameClass.black[6] = new Bishop(1, 7);
        GameClass.black[7] = new Bishop(6, 7);
        for (int i = 0; i < 8; i++) {
            GameClass.black[8+i] = new Pawn(i, 6);
        }
    }


}
