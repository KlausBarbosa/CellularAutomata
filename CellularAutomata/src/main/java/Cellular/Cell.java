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

    @Override
    public String toString() {
        return state.toString();
    }

    public static void main(String[] args) {
        Generation generation = new Generation();
        generation.populateBoard();
        generation.showGeneration();

        System.out.println("\n\nCured: " + generation.curedCounter());
        System.out.println("Infected: " + generation.infectedCounter());
        System.out.println("Susceptible: " + generation.susceptibleCounter());
    }
}


