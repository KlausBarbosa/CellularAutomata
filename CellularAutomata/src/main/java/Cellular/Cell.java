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

    public static void main(String[] args) {
        Generation generation = new Generation(5, 10);

        generation.populateBoard();
        generation.showGeneration();

        generation.nextGeneration();
        generation.showGeneration();

        generation.nextGeneration();
        generation.showGeneration();

        generation.nextGeneration();
        generation.showGeneration();

        generation.nextGeneration();
        generation.showGeneration();

        generation.nextGeneration();
        generation.showGeneration();


    }
}


