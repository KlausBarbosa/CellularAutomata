package org.example;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CellularAutomata {

    public static final int SUSCEPTIBLE = 0;
    public static final int INFECTED = 1;
    public static final int CURED = 2;
    public static final int DEAD = 3;

    private int[][] world;
    private int size;
    private Random random;

    public CellularAutomata(int size) {
        this.size = size;
        world = new int[size][size];
        random = new Random();
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
                    if (random.nextDouble() < 0.2) {
                        newWorld[i][j] = DEAD;
                    } else {
                        newWorld[i][j] = CURED;
                    }
                } else if (state == CURED) {
                    newWorld[i][j] = CURED;
                } else if (state == DEAD) {
                    newWorld[i][j] = SUSCEPTIBLE;
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
                } else if (state == DEAD) {
                    c = 'D';
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
                for (int j = 0; j< size; j++) {
                    int state = world[i][j];
                    char c = '.';
                

                    if (state == SUSCEPTIBLE) {
                        c = 'S';
                    } else if (state == INFECTED) {
                        c = 'I';
                    } else if (state == CURED) {
                        c = 'C';
                    } else if (state == DEAD) {
                        c = 'D';
                    }
    
                    writer.write(c + " ");
                }
                writer.write("\n");
            }
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void createChart() {
        // Cria um gráfico de pizza
        PieChart chart = new PieChartBuilder().width(800).height(600).title("População do Autômato Celular").build();
    
        // Adiciona dados ao gráfico
        int[] populations = new int[4];
        int[] deaths = new int[10];
    
        for (int i = 0; i < 10; i++) {
            nextGeneration();
    
            populations[SUSCEPTIBLE] = countCells(SUSCEPTIBLE);
            populations[INFECTED] = countCells(INFECTED);
            populations[CURED] = countCells(CURED);
            populations[DEAD] = countCells(DEAD);
    
            deaths[i] = countDeaths();
        }
    
        chart.addSeries(getStateName(SUSCEPTIBLE), populations[SUSCEPTIBLE]);
        chart.addSeries(getStateName(INFECTED), populations[INFECTED]);
        chart.addSeries(getStateName(CURED), populations[CURED]);
        chart.addSeries(getStateName(DEAD), populations[DEAD]);
    
        // Exibir o gráfico de pizza
        new SwingWrapper<>(chart).displayChart();
    
        // Exibir as informações sobre as mortes
        System.out.println("Número de mortes por geração:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Geração " + (i + 1) + ": " + deaths[i]);
        }
    }
    
    private int countCells(int state) {
        int count = 0;
    
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (world[i][j] == state) {
                    count++;
                }
            }
        }
    
        return count;
    }
    
    private int countDeaths() {
        int count = 0;
    
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (world[i][j] == DEAD) {
                    count++;
                }
            }
        }
    
        return count;
    }
    
    private String getStateName(int state) {
        switch (state) {
            case SUSCEPTIBLE:
                return "Suscetível";
            case INFECTED:
                return "Infectado";
            case CURED:
                return "Curado";
            case DEAD:
                return "Morto";
            default:
                return "";
        }
    }
}
