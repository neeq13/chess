package com.mygdx.game.Figurs;
import com.mygdx.game.Field;


/**
 * Created by Алексей on 23.01.2016.
 */
public class Rook extends Figure {

    public Rook(char color, int x, int y) {
        super(color, x, y);
        this.name = "rook";
        this.shName = 'R';
    }

    public boolean proverka(int x, int y) {
        if (!ff.proverka(x, y))
            if(Math.abs(y - this.y) <= Field.getFieldSize() && x - this.x == 0 ||
                    y - this.y == 0 && Math.abs(x - this.x) <= Field.getFieldSize()) {
            return true;
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
