package rauter.arthur.java.gameoflife;
//arthurrauter on 15/08/16.

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

}
