package com.mygdx.game;

import com.mygdx.game.Figurs.*;

import java.util.ArrayList;

/**
 * Created by Белл on 27.01.2016.
 */
public class FigureFactory {

    public static ArrayList<Figure> white = new ArrayList<Figure>();
    public static Figure[] black = new Figure[16];

    public  FigureFactory(){
    }

    public void initFigure(){
        white.add(new King(4, 0));
        white.add(new Queen(3, 0));
        white.add(new Rook(0, 0));
        white.add(new Rook(7, 0));
        white.add(new Knight(2, 0));
        white.add(new Knight(5, 0));
        white.add(new Bishop(1, 0));
        white.add(new Bishop(6, 0));
        for (int i = 0; i < 8; i++) {
            white.add(new Pawn(i, 1));
        }

        black[0] = new King(4, 7);
        black[1] = new Queen(3, 7);
        black[2] = new Rook(0, 7);
        black[3] = new Rook(7, 7);
        black[4] = new Knight(2, 7);
        black[5] = new Knight(5, 7);
        black[6] = new Bishop(1, 7);
        black[7] = new Bishop(6, 7);
        for (int i = 0; i < 8; i++) {
            black[8+i] = new Pawn(i, 6);
        }
    }

    public boolean proverka(int x, int y) {
        for (int i = 0; i < white.size(); i++) {
            if (white.get(i).getX() == x && white.get(i).getY() == y){
                return true;
            }
        }
        return false;
    }

}
