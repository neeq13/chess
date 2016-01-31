package com.mygdx.game.Figurs;
import com.mygdx.game.Field;


/**
 * Created by Алексей on 23.01.2016.
 */
public class Rook extends Figure {

    public Rook(int x, int y) {
        super(x, y);
        this.name = "rook";
        this.shName = 'R';
        this.directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        this.length = 7;
    }

    public boolean proverka(int x, int y) {
        if (Field.isCellEmpty(Field.getFieldSize() - 1 - y, x)) {
            if(Math.abs(y - this.y) <= Field.getFieldSize() && x - this.x == 0 ||
                    y - this.y == 0 && Math.abs(x - this.x) <= Field.getFieldSize()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setPosition(int x, int y) {
        if (proverka(x,y)){
            this.y = y;
            this.x = x;
        }
    }
}
