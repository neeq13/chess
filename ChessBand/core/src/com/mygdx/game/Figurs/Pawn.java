package com.mygdx.game.Figurs;

/**
 * Created by Алексей on 24.01.2016.
 */
public class Pawn extends Figure {
    public Pawn(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean setPosition(int x, int y) {
        if ( y - this.y == 1 && this.x == x){
            this.y = y;
            this.x = x;
            isWasTurn = true;
            return true;
        } else if (y - this.y == 2 && this.x == x && !isWasTurn) {
            this.y = y;
            this.x = x;
            isWasTurn = true;
            return true;
        }

        return false;
    }

    //У Пешки их максимум 6(Пока без провеки на врагов и взятий на проходе)
    @Override
    public int[] availableMoves() {
        int[] result = new int[6];
        if (y < 7) result[0] = y + 1;
        if (!isWasTurn) result[1] = y + 2;

        return result;
    }
}
