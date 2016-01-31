
package com.mygdx.game.Figurs;

import com.mygdx.game.Field;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Queen extends Figure {

    public Queen(int x, int y) {
        super(x, y);
        this.name = "queen";
        this.shName = 'Q';
        this.directions = new int[][]{{0,1},{1,0},{1,1},{-1,-1},{-1,0},{0,-1}};
        this.length = 7;
    }

}
