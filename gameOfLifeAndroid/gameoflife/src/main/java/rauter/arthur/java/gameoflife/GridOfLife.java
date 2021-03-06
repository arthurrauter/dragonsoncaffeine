package rauter.arthur.java.gameoflife;
//arthurrauter on 15/08/16.

import java.util.ArrayList;
import java.util.List;

public class GridOfLife {

    private boolean pattern[][];
    private Cell matrix[][];
    private int y_rows;
    private int x_columns;

    GridOfLife(boolean startingPattern[][]) {

        pattern = startingPattern;
        y_rows = startingPattern.length;
        x_columns = startingPattern[0].length;

        for (boolean[] row : startingPattern)
            if (row.length != x_columns) {
                throw new IllegalArgumentException("start matrix has to be a MxN rectangle");
            }

        matrix = new Cell[y_rows][x_columns];

        instantiateCells();
        setCellAdjacency();
    }

    private void instantiateCells() {
        for (int y = 0; y < y_rows; y++) {
            for (int x = 0; x < x_columns; x++) {
                this.matrix[y][x] = new Cell(pattern[y][x]);
            }
        }
    }

    private void setCellAdjacency() {

        for (int y = 0; y < y_rows; y++) {
            for (int x = 0; x < x_columns; x++) {
                List<Cell> cellsAdjacentToXY = new ArrayList<>();
                for (int dy = -1; dy <= 1; dy++) {
                    for (int dx = -1; dx <= 1; dx++) {
                        int xx = x + dx;
                        int yy = y + dy;

                        if (xx >= 0 && yy >= 0 && xx < x_columns && yy < y_rows && !(dy == 0 && dx == 0)) {
                            cellsAdjacentToXY.add(matrix[yy][xx]);
                        }
                    }
                }
                matrix[y][x].setAdjacentCells(cellsAdjacentToXY);
            }
        }
    }

    public void nextGeneration() {

        for (int y = 0; y < y_rows; y++) {
            for (int x = 0; x < x_columns; x++) {
                matrix[y][x].tick();
            }
        }

        for (int y = 0; y < y_rows; y++) {
            for (int x = 0; x < x_columns; x++) {
                matrix[y][x].tack();
            }
        }
    }

    protected Cell[][] getMatrix() {
        return matrix;
    }
    public boolean[][] getPattern() {
        return pattern;
    }

    //Callback experience
    public interface ApplyOnEach {
        void apply(Cell matrix[][], int y, int x);
    }

    public static void traverseTheMatrix(Cell cellMatrix[][], ApplyOnEach method) {
        for (int y = 0; y < cellMatrix.length; y++) {
            for (int x = 0; x < cellMatrix[y].length; x++) {
                method.apply(cellMatrix, y, x);
            }
        }
    }

    public void setCellAdjacency2() {
        traverseTheMatrix(matrix, new ApplyOnEach() {
            @Override
            public void apply(Cell[][] matrix, int y, int x) {

                List<Cell> cellsAdjacentToXY = new ArrayList<>();
                for (int dy = -1; dy <= 1; dy++) {
                    for (int dx = -1; dx <= 1; dx++) {
                        int xx = x + dx;
                        int yy = y + dy;

                        if (xx >= 0 && yy >= 0 && xx < x_columns && yy < y_rows && !(dy == 0 && dx == 0)) {
                            cellsAdjacentToXY.add(matrix[yy][xx]);
                        }
                    }
                }

                matrix[y][x].setAdjacentCells(cellsAdjacentToXY);

            }
        });
    }

    public void instantiateCells2(final boolean startingMatrix[][]) {

        traverseTheMatrix(matrix, new ApplyOnEach() {
            @Override
            public void apply(Cell[][] matrix, int y, int x) {
                matrix[y][x] = new Cell(startingMatrix[y][x]);
            }
        });
    }

    //a little main function to play with stuff
    public static void main(String[] args) {
        int testMatrix[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                System.out.print(testMatrix[y][x]);
            }
            System.out.println();
        }

        GridOfLife game = new GridOfLife(Utilities.oscillator);
        for (int i = 0; i < 20; i++) {
            Utilities.printCellMatrix(game.matrix);
            game.nextGeneration();
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
