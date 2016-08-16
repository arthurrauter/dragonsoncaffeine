package rauter.arthur.java.gameoflife;
//arthurrauter on 16/08/16.

import org.junit.Assert;
import org.junit.Test;

public class GridOfLifeTester {

    @Test
    public void createGrid() {
        boolean startingMatrix[][] = Utilities.oscillator;
        GridOfLife gridOfLife;
        gridOfLife = new GridOfLife(startingMatrix);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rejectNonRectangularGrids() {
        int y = Utilities.oscillator.length;

        boolean matrix[][] = new boolean[y + 1][];
        for (int i = 0; i < matrix.length - 1; i++) {
            matrix[i] = new boolean[]{true, true, false};
        }
        matrix[matrix.length - 1] = new boolean[]{false};

        GridOfLife gridOfLife;
        gridOfLife = new GridOfLife(matrix);
    }

    @Test
    public void oscillatorFullTest() {
        GridOfLife oscillator = new GridOfLife(Utilities.oscillator);
        Cell m[][] = oscillator.getMatrix();

        Assert.assertEquals("2-2 should be alive", m[2][2].isAlive(), true);
        Assert.assertEquals("2-2 should have 2 alive neighbours", 2, m[2][2].countAliveAdjacentCells());
        Assert.assertEquals("2-1 should be alive", m[2][1].isAlive(), true);
        Assert.assertEquals("2-1 should have 1 alive neighbours", 1, m[2][1].countAliveAdjacentCells());
        Assert.assertEquals("2-3 should be alive", m[2][3].isAlive(), true);
        Assert.assertEquals("2-3 should have 1 alive neighbours", 1, m[2][3].countAliveAdjacentCells());

    }

    @Test
    public void createCells() {
        boolean startingMatrix[][] = Utilities.oscillator;
        GridOfLife gridOfLife = new GridOfLife(startingMatrix);
        gridOfLife.instantiateCells(startingMatrix);

        for (int y = 0; y < startingMatrix.length; y++) {
            for (int x = 0; x < startingMatrix[y].length; x++) {
                Assert.assertEquals(
                        gridOfLife.getMatrix()[y][x].isAlive(),
                        startingMatrix[y][x]);
            }

        }
    }

    @Test
    public void createCellCallBackMadness() {
        boolean startingMatrix[][] = Utilities.oscillator;
        GridOfLife gridOfLife = new GridOfLife(startingMatrix);
        gridOfLife.cbCreateCellsOnGrid(startingMatrix);

        for (int y = 0; y < startingMatrix.length; y++) {
            for (int x = 0; x < startingMatrix[y].length; x++) {
                Assert.assertEquals(
                        gridOfLife.getMatrix()[y][x].isAlive(),
                        startingMatrix[y][x]);
            }

        }
    }

}
