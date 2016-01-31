
package com.mygdx.game.Figurs;

import com.mygdx.game.Field;

/**
 * Created by Алексей on 23.01.2016.
 */
public class Bishop extends Figure {

    public Bishop(int x, int y) {
        super(x, y);
        this.name = "bishop";
        this.shName = 'B';
        this.directions = new int[][]{{1,1},{-1,-1}};
        this.length = 7;

    }
}
