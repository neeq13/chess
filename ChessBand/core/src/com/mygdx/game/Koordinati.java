package com.mygdx.game;

import java.util.ArrayList;

/**
 * Created by Алексей on 26.01.2016.
 */
public class Koordinati {
    ArrayList<Point> tochkaFiguri = new ArrayList<Point>();
//    ArrayList<Integer> whiteXkey = new ArrayList<Integer>();
//    ArrayList<Integer> whiteYkey = new ArrayList<Integer>();

    public void zapisKoordinat() {
        ochistka();
        for (int i = 0; i < GameClass.white.length; i++) {
            tochkaFiguri.add(new Point(GameClass.white[i].getX(),GameClass.white[i].getY()));
//            whiteXkey.add(GameClass.white[i].getX());
//            whiteYkey.add(GameClass.white[i].getY());
        }
    }

    public boolean proverka(int x, int y) {
        for (int i = 0; i < tochkaFiguri.size(); i++) {
            if (tochkaFiguri.get(i).getxKoordinata() == x &&tochkaFiguri.get(i).getyKoordinata() == y){
                return true;
        }
//        for (int i = 0; i < whiteYkey.size(); i++) {
//            if(whiteXkey.get(i) == x &&whiteYkey.get(i) == y)
//                return true;
        }
        return false;
    }

    public void ochistka(){
        tochkaFiguri.clear();
//        whiteXkey.clear();
//        whiteYkey.clear();
    }

}
