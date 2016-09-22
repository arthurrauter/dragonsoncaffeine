package rauter.arthur.java.gameoflife;
//arthurrauter on 16/08/16.

import java.util.ArrayList;
import java.util.List;

public class DeleteNoCallBack {

    private Cell[][] matrix;
    private int x_columns;
    private int y_rows;

    public void instantiateCells(boolean startingMatrix[][]) {
        for (int y = 0; y < y_rows; y++) {
            for (int x = 0; x < x_columns; x++) {
                this.matrix[y][x] = new Cell(startingMatrix[y][x]);
            }
        }
    }

    public void setCellsAdjacency() {
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
}
