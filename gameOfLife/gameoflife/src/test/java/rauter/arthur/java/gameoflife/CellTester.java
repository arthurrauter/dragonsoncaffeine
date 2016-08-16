package rauter.arthur.java.gameoflife;//arthurrauter on 12/08/16.

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CellTester {

    @Test
    public void instantiateCell() {
        Cell cell = new Cell(true);
        Assert.assertEquals(cell.isAlive(), true);
        cell = new Cell(false);
        Assert.assertEquals(cell.isAlive(), false);
    }

    @Test
    public void setAdjacentCells() {
        Cell cell = new Cell(true);
        int numberOfAdjacentCells = 8;

        List<Cell> listOfCells = new ArrayList<>();
        for (int i = numberOfAdjacentCells; i > 0; i--) {
            listOfCells.add(new Cell(true));
        }

        cell.setAdjacentCells(listOfCells);
        Assert.assertEquals(listOfCells, cell.getAdjacentCells());
    }

    @Test
    public void countLivingAdjacentCells() {
        Cell cell = new Cell(true);
        int numberOfAdjacentCells = 8;

        List<Cell> listOfCells = new ArrayList<>();
        for (int i = numberOfAdjacentCells; i > 0; i--) {
            listOfCells.add(new Cell(true));
        }

        listOfCells.get(listOfCells.size() - 1).setAlive(false);

        cell.setAdjacentCells(listOfCells);
        Assert.assertEquals(numberOfAdjacentCells - 1, cell.countAliveAdjacentCells());
    }

    @Test
    public void deathByOverpop() {
        Cell cell = new Cell(true);
        cell.setAdjacentCells(generate8Cells(true));
        cell.tick();
        cell.tack();
        Assert.assertEquals(false, cell.isAlive());
    }

    @Test
    public void deathByLoneliness() {
        Cell cell = new Cell(true);
        cell.setAdjacentCells(generate8Cells(false));
        cell.tick();
        cell.tack();
        Assert.assertEquals(false, cell.isAlive());
    }

    @Test
    public void reproduction() {
        Cell cell = new Cell(false);
        cell.setAdjacentCells(generate8Cells(3));
        cell.tick();
        cell.tack();
        Assert.assertEquals(true, cell.isAlive());
    }

    @Test
    public void deathByOverpopEdge() {
        Cell cell = new Cell(true);
        cell.setAdjacentCells(generate8Cells(4));
        cell.tick();
        cell.tack();
        Assert.assertEquals(false, cell.isAlive());
    }

    @Test
    public void deathByLonelinessEdge() {
        Cell cell = new Cell(true);
        cell.setAdjacentCells(generate8Cells(1));
        cell.tick();
        cell.tack();
        Assert.assertEquals(false, cell.isAlive());
    }

    private List<Cell> generate8Cells(boolean allAlive) {
        List<Cell> listOfCells = new ArrayList<>();
        for (int i = 8; i > 0; i--) {
            listOfCells.add(new Cell(allAlive));
        }
        return listOfCells;
    }

    private List<Cell> generate8Cells(int alive) {
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < alive; i++) {
            cells.add(new Cell(true));
        }
        for (int i = alive; i < 8; i++) {
            cells.add(new Cell(false));
        }
        return cells;
    }

    public void multipleTickTacks(boolean trueForTick, Cell cell) {
        boolean cellStartingState = cell.isAlive();
        for (int i = 0; i < 7; i++) {
            if (trueForTick) {
                cell.tick();
            } else {
                cell.tack();
            }
            Assert.assertEquals(cellStartingState, cell.isAlive());
        }
    }

    @Test
    public void multipleTicks() {
        Cell c = new Cell(true);
        c.setAdjacentCells(generate8Cells(6));

        multipleTickTacks(true, c);

        c.tick();
        c.tack();
        Assert.assertEquals(c.isAlive(), false);
    }

    @Test
    public void multipleTacks() {
        Cell c = new Cell(true);
        c.setAdjacentCells(generate8Cells(6));

        multipleTickTacks(false, c);

        c.tick();
        c.tack();
        Assert.assertEquals(c.isAlive(), false);
    }

    @BeforeClass
    public static void setUp() {
//        System.out.println("setUp");
    }

    @Before
    public void beforeEachTest() {
//        System.out.println("test is about to be executed");
    }

    @After
    public void afterEachTest() {
//        System.out.println("test finished");
    }

}
