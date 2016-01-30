package com.mygdx.game;

import com.mygdx.game.Figurs.Figure;
import java.util.ArrayList;

/**
 * Created by Olesya on 30.01.2016.
 */
public class Box {

    public static ArrayList<Figure> whiteBox = new ArrayList<Figure>();
    //ArrayList<Figure> blackBox = new ArrayList<Figure>();

    public void Main(){
        motionFigureBox(0, 0,"white" , GameClass.white[1]);
    }

    public void motionFigureBox(int _x, int _y, String _color, Figure _figure){

        whiteBox.add(_figure);

    }
}
