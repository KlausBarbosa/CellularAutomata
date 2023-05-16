package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CellularAutomata {
    public static final int SUSCEPTIBLE = 0;
    public static final int INFECTED = 1;
    public static final int CURED = 2;

    private int[][] world;
    private int size;

    public CellularAutomata(int size) {
        this.size = size;
        world = new int[size][size];
    }

    public void nextGeneration() {
        int[][] newWorld = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int state = world[i][j];
                int infectedNeighbors = countInfectedNeighbors(i, j);

                if (state == SUSCEPTIBLE && infectedNeighbors > 0) {
                    newWorld[i][j] = INFECTED;
                } else if (state == INFECTED) {
                    newWorld[i][j] = CURED;
                } else {
                    newWorld[i][j] = state;
                }
            }
        }

        world = newWorld;
    }

    private int countInfectedNeighbors(int x, int y) {
        int count = 0;

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < size && j >= 0 && j < size && !(i == x && j == y)) {
                    if (world[i][j] == INFECTED) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public void setCell(int x, int y, int state) {
        world[x][y] = state;
    }

    

    public void printWorld() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int state = world[i][j];
                char c = '.';

                if (state == SUSCEPTIBLE) {
                    c = 'S';
                } else if (state == INFECTED) {
                    c = 'I';
                } else if (state == CURED) {
                    c = 'C';
                }

                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void saveWorld(String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int state = world[i][j];
                    writer.write(state + " ");
                }
                writer.write("\n");
            }
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
