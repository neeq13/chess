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
    private char color = 'w';

    public FigureFactory() {
    }
// заполняем массивы фигурами
    public void initFigure() {
        white.add(new King(color, 4, 0));
        white.add(new Queen(color, 3, 0));
        white.add(new Rook(color, 0, 0));
        white.add(new Rook(color, 7, 0));
        white.add(new Knight(color, 1, 0));
        white.add(new Knight(color, 6, 0));
        white.add(new Bishop(color, 2, 0));
        white.add(new Bishop(color, 5, 0));
        for (int i = 0; i < 8; i++) {
            white.add(new Pawn(color, i, 1));
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
