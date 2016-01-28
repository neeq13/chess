
package com.mygdx.game.Figurs;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Knight extends Figure {


    public Knight(char color, int x, int y) {
        super(color, x, y);
        this.name = "knight";
        this.shName = 'N';
    }

    @Override
    public void setPosition(int x, int y) {
        if (Math.abs(y-this.y) == 2 && Math.abs(x - this.x) == 1|| Math.abs(y-this.y) == 1 && Math.abs(x - this.x) == 2){
            this.y = y;
            this.x = x;
        }
    }
}
