package com.mygdx.game.Figurs;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Field;

/**
 * Created by Алексей on 23.01.2016.
 */
public class King extends Figure {

    public King(int x, int y) {
        super(x, y);
        this.name = "king";
        this.shName = 'K';
        this.directions = new int[][]{{0,1},{1,0},{1,1},{-1,-1},{-1,0},{0,-1}};
        this.length = 1;
    }

}
