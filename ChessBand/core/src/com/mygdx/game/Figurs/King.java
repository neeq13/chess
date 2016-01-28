package com.mygdx.game.Figurs;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Алексей on 23.01.2016.
 */
public class King extends Figure {

    public King(char color, int x, int y) {
        super(color, x, y);
        this.name = "king";
        this.shName = 'K';
    }

    @Override
    public void setPosition(int x, int y) {
        if (Math.abs(y-this.y) == 1&& Math.abs(x - this.x) == 0|| Math.abs(y-this.y) == 0&& Math.abs(x - this.x) == 1||Math.abs(y-this.y) == 1 && Math.abs(x - this.x) == 1){
            this.y = y;
            this.x = x;
        }
    }
}
