package CellularService;

import Cellular.Cell;

public class Generation {
    private Cell[][] board;


    public Generation() {
        board = new Cell[3][3];
    }
    public Generation(int columns, int rows) {
        board = new Cell[columns][rows];
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

    public void printBoard() {
        int rows = board.length;

        for (int i = 0; i < rows; i++) {
            int columns = board[i].length;

            for (int j = 0; j < columns; j++) {
                System.out.print("[" + board[i][j].toString() + "]" + " ");
            }
            System.out.println();
        }
    }
}

