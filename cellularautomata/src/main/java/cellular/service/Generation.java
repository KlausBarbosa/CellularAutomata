package cellular.service;

import cellular.Cell;
import cellular.CellState;

import java.util.Random;

public class Generation {
    private Cell[][] board;
    private final int matrixSize;
    private int recovered;
    private int susceptibles;
    private int infected;
    private int totalCells;


    public Generation(int n) {
        matrixSize = n;
        board = new Cell[matrixSize][matrixSize];
        totalCells = n * n;
    }

    public void populateBoard() {
        for(int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                board[i][j] = new Cell(CellState.S);
            }
        }

        Random random = new Random();
        int randomRow = random.nextInt(matrixSize);
        int randomColum = random.nextInt(matrixSize);
        board[randomRow][randomColum] = new Cell(CellState.I);
    }


    public void showGeneration() {
        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                System.out.print("[" + cell.toString() + "]");
            }
            System.out.println();
        }

        satateCounter();

        System.out.println("\nInfected: " + infected);
        System.out.println("Susceptibles: " + susceptibles);
        System.out.println("Recovered: " + recovered + "\n\n");
    }

    public void satateCounter() {
        susceptibles = 0;
        infected = 0;
        recovered = 0;

        for (Cell[] cells : board) {
            for (Cell cell : cells) {
                if (cell.state == CellState.S) {
                    susceptibles++;

                } else if (cell.state == CellState.I) {
                    infected++;

                } else {
                    recovered++;
                }
            }
        }
    }

    public void nextGeneration(double Pv, double Ps, double Pc, double Pd, double Po, double k) {
        Cell[][] newBoard = new Cell[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                Cell currentCell = board[i][j];
                CellState currentCellState = currentCell.state;

                int infectedNeighbors = countInfectedNeighbors(i, j);
                double Pi = 1 - Math.exp(-k * infectedNeighbors);

                if (currentCellState == CellState.S) {
                    //Probabilidade de S -> R (vacina)
                    if (Math.random() < Pv) {
                        newBoard[i][j] = new Cell(CellState.R);

                        //Probabilidade de S -> I (infecção espontânea)
                    } else if (Math.random() < Ps) {
                        newBoard[i][j] = new Cell(CellState.I);

                        //Probabilidade de S + vI -> I + vI (infecção por contato com vizinho)
                    } else if (infectedNeighbors > 0 && Math.random() < Pi) {
                        newBoard[i][j] = new Cell(CellState.I);

                    } else {
                        newBoard[i][j] = currentCell;
                    }

                } else if (currentCellState == CellState.I) {
                    //Probabilidade de I -> R (Recuperado)
                    if (Math.random() < Pc) {
                        newBoard[i][j] = new Cell(CellState.R);

                        //Probabilidade de I -> S (Morrer)
                    } else if (Math.random() < Pd) {
                        newBoard[i][j] = new Cell(CellState.S);

                    } else {
                        newBoard[i][j] = currentCell;
                    }

                } else if (currentCellState == CellState.R) {
                    //Probabilidade de R -> S (morrer por outras causas)
                    if (Math.random() < Po) {
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

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = colum - 1; j <= colum + 1; j++) {
                int neighborRow = (i + matrixSize) % matrixSize;
                int neighborColum = (j + matrixSize) % matrixSize;

                if (!(i == row && j == colum) && board[neighborRow][neighborColum].state == CellState.I) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getSusceptibles() {
        return susceptibles;
    }

    public int getInfected() {
        return infected;
    }

    public int getRecovered() {
        return recovered;
    }

    public int getTotalCells() {
        return totalCells;
    }
}