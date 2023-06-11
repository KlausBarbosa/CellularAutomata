package CellularService;

import Cellular.Cell;
import Cellular.CellState;

public class Generation {
    private Cell[][] board;
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
    }

    public void showGeneration() {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                System.out.print("[" + cell.toString() + "]");
            }
            System.out.println();
        }

        susceptibles = susceptibleCounter();
        infected = infectedCounter();
        recovered = recoveredCounter();

        System.out.println("\nInfected: " + infected);
        System.out.println("Susceptibles: " + susceptibles);
        System.out.println("Recovered: " + recovered + "\n\n");
    }

    public int susceptibleCounter() {
        susceptibles = 0;

        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                if (cell.state == CellState.S ) {
                    susceptibles++;
                }
            }
        }
        return susceptibles;
    }

    public int infectedCounter() {
        infected = 0;

        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                if (cell.state == CellState.I) {
                    infected++;
                }
            }
        }
        return infected;
    }

    public int recoveredCounter() {
        recovered = 0;

        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                if (cell.state == CellState.R) {
                    recovered++;
                }
            }
        }
        return recovered;
    }

    public void nextGeneration() {
        int rows = board.length;
        int columns = board[0].length;

        Cell[][] newBoard = new Cell[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Cell currentCell = board[i][j];
                CellState currentCellState = currentCell.state;
                int infectedNeighbors = countInfectedNeighbors(i, j);

                if (currentCellState == CellState.S) {
                    //Probabilidade de S -> R
                    if (Math.random() < 0.8) {
                        newBoard[i][j] = new Cell(CellState.R);

                    //Probabilidade de S -> I
                    } else if (Math.random() < 0.02) {
                        newBoard[i][j] = new Cell(CellState.I);

                        //Probabilidade de S -> I por contato com vizinho
                    } else if (infectedNeighbors > 0 && Math.random() < 0.3 * infectedNeighbors) {
                        newBoard[i][j] = new Cell(CellState.I);

                    } else {
                        newBoard[i][j] = currentCell;
                    }

                } else if (currentCellState == CellState.I) {
                    //Probabilidade de I -> R
                    if (Math.random() < 0.2) {
                        newBoard[i][j] = new Cell(CellState.R);

                        //Probabilidade de I -> S (Morrer)
                    } else if (Math.random() < 0.1) {
                        newBoard[i][j] = new Cell(CellState.S);

                    } else {
                        newBoard[i][j] = currentCell;
                    }

                } else if (currentCellState == CellState.R) {
                    //Probabilidade de R -> S (morrer por outras causas)
                    if (Math.random() < 0.02) {
                        newBoard[i][j] = new Cell(CellState.S);

                    } else {
                        newBoard[i][j] = currentCell;
                    }
                }
            }
        }

        board = newBoard;
    }

    private int countInfectedNeighbors(int row, int colum) {
        int count = 0;
        int rows = board.length;
        int columns = board[0].length;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = colum - 1; j <= colum + 1; j++) {
                int neighborRow = (i + rows) % rows;
                int neighborColum = (j + columns) % columns;

                if (board[neighborRow][neighborColum].state == CellState.I) {
                    count++;
                }
            }
        }

        if (board[row][colum].state == CellState.I) {
            count--;
        }

        return count;
    }
}