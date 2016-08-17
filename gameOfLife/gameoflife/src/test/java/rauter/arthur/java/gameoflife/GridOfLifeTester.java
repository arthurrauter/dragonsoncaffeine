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

        boolean living = true;

        for (int i = 0; i < 2000; i++) {

            oscillator.nextGeneration();
            //central cell is always alive
            Assert.assertEquals(m[2][2].isAlive(), true);

            //adjacent cells in x
            Assert.assertEquals(m[2][1].isAlive(), !living);
            Assert.assertEquals(m[2][3].isAlive(), !living);
            //adjacent cells in y
            Assert.assertEquals(m[1][2].isAlive(), living);
            Assert.assertEquals(m[3][2].isAlive(), living);

            //everything else has to be dead
            for (int y = 0; y < m.length; y++) {
                for (int x = 0; x < m[y].length; x++) {
                    if (!((x == 2 && (y == 2 || y == 1 || y == 3) || (y == 2 && (x == 1 || x == 3))))) {
                        Assert.assertEquals("x " + x + " y " + y, false, m[y][x].isAlive());
                    }
                }
            }

            living = !living;
        }

    }

    @Test
    public void instantiateCells() {
        boolean startingMatrix[][] = Utilities.oscillator;
        GridOfLife gridOfLife = new GridOfLife(startingMatrix);

        for (int y = 0; y < startingMatrix.length; y++) {
            for (int x = 0; x < startingMatrix[y].length; x++) {
                Assert.assertEquals(
                        gridOfLife.getMatrix()[y][x].isAlive(),
                        startingMatrix[y][x]);
            }

        }
    }

    @Test
    public void createCellsWithCallBack() {
        boolean startingMatrix[][] = Utilities.oscillator;
        GridOfLife gridOfLife = new GridOfLife(startingMatrix);
        gridOfLife.instantiateCells2(startingMatrix);

        for (int y = 0; y < startingMatrix.length; y++) {
            for (int x = 0; x < startingMatrix[y].length; x++) {
                Assert.assertEquals(
                        gridOfLife.getMatrix()[y][x].isAlive(),
                        startingMatrix[y][x]);
            }

        }
    }

}
