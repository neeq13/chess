package com.mygdx.game.Figurs;

import com.mygdx.game.Field;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Pawn extends Figure {
    public Pawn(int x, int y) {
        super(x, y);
        this.name = "pawn";
        this.shName = 'p';
        this.directions = new int[][]{{0,-1}};
        hasMoved = false;
        this.length = 2;
        if(isHasMoved()) this.length = 1;
    }
}



