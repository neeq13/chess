package com.mygdx.game;

import com.mygdx.game.Figures.*;

import java.util.ArrayList;

public class GameInit {

    ArrayList<Figure> figures;

    public GameInit() {

        figures = new ArrayList<Figure>();

        for (int i = 0; i < 9; i++) {
            figures.add(new Pawn(i, 2, 'w'));
            figures.add(new Pawn(i, 7, 'b'));
        }

        figures.add(new Rook(1, 1, 'w'));
        figures.add(new Rook(8, 1, 'w'));
        figures.add(new Rook(1, 8, 'b'));
        figures.add(new Rook(8, 8, 'b'));

        figures.add(new Knight(2, 1, 'w'));
        figures.add(new Knight(7, 1, 'w'));
        figures.add(new Knight(2, 8, 'b'));
        figures.add(new Knight(7, 8, 'b'));

        figures.add(new Bishop(3, 1, 'w'));
        figures.add(new Bishop(6, 1, 'w'));
        figures.add(new Bishop(3, 8, 'b'));
        figures.add(new Bishop(6, 8, 'b'));

        figures.add(new Queen(4, 1, 'w'));
        figures.add(new Queen(4, 8, 'b'));

        figures.add(new King(5, 1, 'w'));
        figures.add(new King(5, 8, 'b'));
    }
}
