package com.mygdx.game;

import com.mygdx.game.Figurs.Figure;
import java.util.ArrayList;

/**
 * Created by Olesya on 30.01.2016.
 */
public class Box {

    public static ArrayList<Figure> whiteBox = new ArrayList<Figure>();

    private char color;

    Box(char color) {
        this.color = color;
    }

    public char getColor() {
        return color;
    }

}
