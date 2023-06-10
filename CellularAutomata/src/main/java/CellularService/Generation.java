package CellularService;

import Cellular.Cell;
import Cellular.CellState;

public class Generation {
    private final Cell[][] board;
    private int recovered;
    private int susceptibles;
    private int infected;


    public Generation() {
        board = new Cell[3][3];
    }
    public Generation(int rows, int columns) {
        board = new Cell[rows][columns];
    }

    public void populateBoard() {
        int rows = board.length;

        for (int i = 0; i < rows; i++) {
            int columns = board[i].length;

            for (int j = 0; j < columns; j++) {
                board[i][j] = new Cell();
            }
        }
        susceptibleCounter();
        infectedCounter();
        recoveredCounter();
    }

    public void showGeneration() {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                System.out.print("[" + cell.toString() + "]");
            }
            System.out.println();
        }
        System.out.println("\nInfected: " + infected);
        System.out.println("Susceptibles: " + susceptibles);
        System.out.println("Recovered: " + recovered);
    }

    public void susceptibleCounter() {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                if (cell.state == CellState.S ) {
                    susceptibles++;
                }
            }
        }
    }

    public void infectedCounter() {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                if (cell.state == CellState.I) {
                    infected++;
                }
            }
        }
    }

    public void recoveredCounter() {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                if (cell.state == CellState.R) {
                    recovered++;
                }
            }
        }
    }

    public int getRecovered() {
        return recovered;
    }

    public int getSusceptibles() {
        return susceptibles;
    }

    public int getInfected() {
        return infected;
    }
}