package org.example;

public class Main {
    public static void main(String[] args) {
        CellularAutomata ca = new CellularAutomata(10);

        ca.setCell(0, 6, CellularAutomata.INFECTED);

        for (int i = 0; i < 10; i++) {
            ca.nextGeneration();
            ca.printWorld();
            ca.saveWorld("generations.txt");
        }

        ca.createChart();
    }
}