package rauter.arthur.java.gameoflife;
//arthurrauter on 15/08/16.

import java.util.ArrayList;
import java.util.List;

public class Utilities {

    static boolean ttttt = true;
    static boolean fffff = false;

    public static boolean oscillator[][] = {
            {false, false, false, false, false},
            {false, false, false, false, false},
            {false, ttttt, ttttt, ttttt, false},
            {false, false, false, false, false},
            {false, false, false, false, false}
    };

    public static void printCellMatrix(Cell matrix[][]) {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                if (matrix[y][x].isAlive())
                    System.out.print("[*]");
                else
                    System.out.print("[ ]");
            }
            System.out.println();
        }
    }

    public static List<Cell> generateCells(int amount, boolean allAlive) {
        if (allAlive)
            return generateCells(amount, amount);
        else
            return generateCells(amount, 0);
    }

    public static List<Cell> generateCells(int amount, int alive) {
        List<Cell> cells = new ArrayList<>();

        for (int i = 0; i < alive; i++) {
            cells.add(new Cell(true));
        }

        for (int i = alive; i < amount; i++) {
            cells.add(new Cell(false));
        }

        return cells;
    }

}
