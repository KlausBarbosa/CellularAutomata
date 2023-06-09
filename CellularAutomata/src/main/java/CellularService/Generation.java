package CellularService;

import Cellular.Cell;
import Cellular.CellState;

public class Generation {
    private final Cell[][] board;
    private int cured;
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
    }

    public void showGeneration() {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                System.out.print("[" + cell.toString() + "]");
            }
            System.out.println();
        }
    }

    public int susceptibleCounter() {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                if (cell.state == CellState.Susceptible ) {
                    susceptibles++;
                }
            }
        }
        return susceptibles;
    }

    public int infectedCounter() {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                if (cell.state == CellState.Infected) {
                    infected++;
                }
            }
        }
        return infected;
    }

    public int curedCounter() {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                if (cell.state == CellState.Cured) {
                    cured++;
                }
            }
        }
        return cured;
    }
}

