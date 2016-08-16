package rauter.arthur.java.gameoflife;
//arthurrauter on 12/08/16.

import java.util.List;

public class Cell {

    private List<Cell> adjacentCells;
    private boolean alive;
    private boolean willSurvive;

    public Cell(boolean alive){
        this.alive = alive;
        this.willSurvive = this.alive;
    }

    public int countAliveAdjacentCells() {
        int alive = 0;
        for (Cell c : adjacentCells) {
            if (c.isAlive()) {
                alive++;
            }
        }
        return alive;
    }

    public void tick() {
        if (adjacentCells == null) throw new IllegalStateException("no adjacent cells");

        int alive = countAliveAdjacentCells();
        this.willSurvive = this.alive;

        if (this.alive) {
            if (alive < 2 || alive > 3) willSurvive = false;
        } else {
            if (alive == 3) willSurvive = true;
        }

    }
     public void tack() {
         alive = willSurvive;
     }

    public List<Cell> getAdjacentCells() {
        return adjacentCells;
    }

    public void setAdjacentCells(List<Cell> adjacentCells) {
        this.adjacentCells = adjacentCells;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
