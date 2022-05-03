public class App {

    private static final int GRID_SIZE = 9;
    private static final int BOX_ROW_SIZE = 3;
    private static final int BOX_COLUMN_SIZE = 3;

    public static void main(String[] args) throws Exception {

        /**
         * This is the suduko we want to solve
         * It's a two dimentional array where the 0 is a blank
         */

        // Grid size 9 with row = 3 and column = 3
        int[][] board = {
                { 7, 0, 2, 0, 5, 0, 6, 0, 0 },
                { 0, 0, 0, 0, 0, 3, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 9, 5, 0, 0 },
                { 8, 0, 0, 0, 0, 0, 0, 9, 0 },
                { 0, 4, 3, 0, 0, 0, 7, 5, 0 },
                { 0, 9, 0, 0, 0, 0, 0, 0, 8 },
                { 0, 0, 9, 7, 0, 0, 0, 0, 5 },
                { 0, 0, 0, 2, 0, 0, 0, 0, 0 },
                { 0, 0, 7, 0, 4, 0, 2, 0, 3 }
        };

        // Grid size 12 with row = 3 and column = 4
        // int[][] board = {
        // { 0, 0, 0, 0, 12, 0, 11, 6, 0, 9, 7, 0 },
        // { 9, 7, 0, 0, 0, 0, 0, 0, 0, 0, 11, 0 },
        // { 4, 0, 6, 12, 9, 0, 5, 0, 0, 2, 0, 0 },
        // { 0, 0, 0, 10, 0, 0, 7, 0, 3, 12, 0, 0 },
        // { 5, 0, 0, 0, 2, 0, 3, 11, 0, 10, 0, 6 },
        // { 2, 0, 3, 7, 4, 0, 0, 0, 0, 0, 0, 0 },
        // { 0, 0, 0, 0, 0, 0, 0, 9, 4, 5, 0, 7 },
        // { 1, 0, 7, 0, 8, 5, 0, 3, 0, 0, 0, 10 },
        // { 0, 0, 4, 6, 0, 11, 0, 0, 1, 0, 0, 0 },
        // { 0, 0, 5, 0, 0, 6, 0, 2, 12, 11, 0, 9 },
        // { 0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 3, 1 },
        // { 0, 2, 1, 0, 11, 12, 0, 10, 0, 0, 0, 0 }
        // };

        printBoard(board);
        System.out.println();

        if (solveBoard(board)) {
            System.out.println("Solved successfully!\n");
        } else {
            System.out.println("Unsolverble board :(");
        }

        printBoard(board);

    }

    /**
     * This method prints the bord and the result to the console
     * 
     * @param board
     */
    private static void printBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % BOX_ROW_SIZE == 0 && row != 0) {
                int repeatNumber = (GRID_SIZE * 3) + 5;
                String str = "-".repeat(repeatNumber);
                System.out.println(str);
            }
            for (int column = 0; column < GRID_SIZE; column++) {
                if (column % BOX_COLUMN_SIZE == 0 && column != 0) {
                    System.out.print(" |");
                }
                System.out.printf("%3d", board[row][column]);
            }
            System.out.println();
        }
    }

    /**
     * A method that takes tree parameters (board, number and row)
     * In this method we check if number exist in row
     * 
     * @param board
     * @param number
     * @param row
     * @return
     */
    private static boolean isNumberInRow(int[][] board, int number, int row) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * A method that takes tree parameters (board, number and column)
     * In this method we check if number exist in column
     * 
     * @param board
     * @param number
     * @param column
     * @return
     */
    private static boolean isNumberInColumn(int[][] board, int number, int column) {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * A method that takes four parameters (board, number, row and column)
     * In this method we check if number exist in box (3 * 3)
     * 
     * @param board
     * @param number
     * @param row
     * @param column
     * @return
     */
    private static boolean isNumberInBox(int[][] board, int number, int row, int column) {
        int localBoxRow = row - row % BOX_ROW_SIZE;
        int localBoxColumn = column - column % BOX_COLUMN_SIZE;

        for (int i = localBoxRow; i < localBoxRow + BOX_ROW_SIZE; i++) {
            for (int j = localBoxColumn; j < localBoxColumn + BOX_COLUMN_SIZE; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method checks if number is valid
     * 
     * @param board
     * @param number
     * @param row
     * @param column
     * @return
     */
    private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
        return !isNumberInRow(board, number, row) &&
                !isNumberInColumn(board, number, column) &&
                !isNumberInBox(board, number, row, column);
    }

    /**
     * Recursion
     * 
     * @param board
     * @return
     */
    private static boolean solveBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (board[row][column] == 0) {
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isValidPlacement(board, numberToTry, row, column)) {
                            board[row][column] = numberToTry;

                            if (solveBoard(board)) {
                                return true;
                            } else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

}
