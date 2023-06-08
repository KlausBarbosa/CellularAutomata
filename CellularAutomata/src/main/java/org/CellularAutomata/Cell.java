package org.CellularAutomata;

import java.util.Random;

public class Cell {
    State state;

    public Cell() {
        Random random = new Random();
        int index = random.nextInt(State.values().length);
        state = State.values()[index];
    }
}

enum State {
    Susceptible, Infected, Cured
}


