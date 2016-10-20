package rauter.arthur.java.gameoflife;
//arthurrauter on 16/08/16.

import java.util.ArrayList;
import java.util.List;

public class DeleteCallBack {

    private Cell[][] matrix;
    private int x_columns;
    private int y_rows;

    interface ApplyOnEach {
        void apply(Cell matrix[][], int y, int x);
    }

    public void traverseTheMatrix(Cell cellMatrix[][], ApplyOnEach method) {
        for (int y = 0; y < cellMatrix.length; y++) {
            for (int x = 0; x < cellMatrix[y].length; x++) {
                method.apply(cellMatrix, y, x);
            }
        }
    }

    public void cbLinkCells() {
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

    public void cbCreateCellsOnGrid(final boolean startingMatrix[][]) {
        traverseTheMatrix(matrix, new ApplyOnEach() {
            @Override
            public void apply(Cell[][] matrix, int y, int x) {
                matrix[y][x] = new Cell(startingMatrix[y][x]);
            }
        });
    }

    public void cbNextGeneration() {
        traverseTheMatrix(matrix, new ApplyOnEach() {
            @Override
            public void apply(Cell[][] matrix, int y, int x) {
                matrix[y][x].tick();
            }
        });

        traverseTheMatrix(matrix, new ApplyOnEach() {
            @Override
            public void apply(Cell[][] matrix, int y, int x) {
                matrix[y][x].tack();
            }
        });
    }
}
