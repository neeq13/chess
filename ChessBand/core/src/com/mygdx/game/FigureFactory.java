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

    public static ArrayList<Figure> white = new ArrayList<Figure>();

    private char color;


    public FigureFactory(char color) {
        this.color = color;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }
    
// заполняем массивы фигурами
    public void initFigure() {
        white.add(new King(4, 0));
        white.add(new Queen(3, 0));
        white.add(new Rook(0, 0));
        white.add(new Rook(7, 0));
        white.add(new Knight(1, 0));
        white.add(new Knight(6, 0));
        white.add(new Bishop(2, 0));
        white.add(new Bishop(5, 0));
        for (int i = 0; i < 8; i++) {
            white.add(new Pawn(i, 1));
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
