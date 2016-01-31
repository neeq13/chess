package com.mygdx.game;

import com.mygdx.game.Figurs.*;

import java.util.ArrayList;

/**
 * Created by Белл on 27.01.2016.
 */
public class FigureFactory {

    public static ArrayList<Figure> army = new ArrayList<Figure>();
    private char color;
    public FigureFactory(char color) {
        this.color = color;
    }
    public char getColor() {
        return color;
    }

    // заполняем массив фигурами
    public void initFigure() {
        army.add(new King(4, 0));
        army.add(new Queen(3, 0));
        army.add(new Rook(0, 0));
        army.add(new Rook(7, 0));
        army.add(new Knight(1, 0));
        army.add(new Knight(6, 0));
        army.add(new Bishop(2, 0));
        army.add(new Bishop(5, 0));
        for (int i = 0; i < 8; i++) {
            army.add(new Pawn(i, 1));
        }
    }
}
