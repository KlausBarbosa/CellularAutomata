package Cellular;

import CellularService.Generation;

import java.util.Arrays;
import java.util.Random;

public class Cell {
   private State state;

    public Cell() {
        Random random = new Random();
        int index = random.nextInt(State.values().length);
        state = State.values()[index];
    }

    @Override
    public String toString() {
        return state.toString();
    }

    public static void main(String[] args) {
        Generation generation = new Generation();
        generation.populateBoard();
        generation.printBoard();

    }
}

enum State {
    Susceptible, Infected, Cured
}


