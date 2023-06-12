package Cellular;

import CellularService.Generation;
import java.util.Random;

public class Cell {
   public CellState state;

    public Cell() {
        Random random = new Random();
        int index = random.nextInt(CellState.values().length);
        state = CellState.values()[index];
    }

    public Cell(CellState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}


