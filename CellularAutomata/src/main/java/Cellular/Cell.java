package Cellular;

import java.util.Random;

public class Cell {
   public CellState state;

    public Cell(CellState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}


