package org.example;

public class Main {
    public static void main(String[] args) {
        CellularAutomata ca = new CellularAutomata(10);

        ca.setCell(0, 0, CellularAutomata.INFECTED);

        for (int i = 0; i < 10; i++) {
            ca.nextGeneration();
            ca.printWorld();
            ca.saveWorld("generations.txt");
        }
    }
}