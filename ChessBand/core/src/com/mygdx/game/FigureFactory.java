package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.Figurs.*;
import com.sun.prism.impl.paint.PaintUtil;

import java.util.ArrayList;

/**
 * Created by Белл on 27.01.2016.
 */
public class FigureFactory {
// создаем два массива фигур черные и белые
    public static ArrayList<Figure> white = new ArrayList<Figure>();
    public static ArrayList<Figure> black = new ArrayList<Figure>();

    public FigureFactory() {
    }
// заполняем массивы фигурами
    public void initFigure() {
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

        black.add(new King(4, 7));
        black.add(new Queen(3, 7));
        black.add(new Rook(0, 7));
        black.add(new Rook(7, 7));
        black.add(new Knight(2, 7));
        black.add(new Knight(5, 7));
        black.add(new Bishop(1, 7));
        black.add(new Bishop(6, 7));
        for (int i = 0; i < 8; i++) {
            black.add(new Pawn(i, 6));
        }
    }
//проверяем стоит ли во входных координатах наша фигура(пока проверка по белым фигурам идет)
    public boolean proverka(int x, int y) {
        for (int i = 0; i < white.size(); i++) {
            if (white.get(i).getX() == x && white.get(i).getY() == y) {
                return true;
            }
        }
        return false;
    }

}
