package com.mygdx.game.Figures;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Figure;

public class Rook extends Figure{

    public Rook(int x, int y, char color) {

        this.x = x - 1;
        this.y = y - 1;
        this.color = color;
        if (color == 'w')
            texture = new Texture("rookw.png");
        if (color == 'b')
            texture = new Texture("rookb.png");
    }





    @Override
    public void moveTo(int x, int y) {

    }

    @Override
    public void canMove(int x, int y) {

    }
}
