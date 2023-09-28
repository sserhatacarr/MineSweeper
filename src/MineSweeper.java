import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    //1- Defined class and variables
    int rowNumber, colNumber;
    int[][] board, plan;
    boolean check = true;
    boolean[][] cellVisited;
    Scanner scan = new Scanner(System.in);

    public MineSweeper(int rowNumber, int colNumber) { // Defined constructor method
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.board = new int[rowNumber][colNumber];
        this.plan = new int[rowNumber][colNumber];
        cellVisited = new boolean[rowNumber][colNumber];

    }

    public void placedMines() { // 3-Function that randomly places mines
        Random random = new Random();
        int placedMines = 0;
        int mineCount = (rowNumber * colNumber) / 4;

        // Loop that will add mines until we reach the number of mines we set
        while (placedMines < mineCount) {
            int randomRow = random.nextInt(rowNumber);
            int randomCols = random.nextInt(colNumber);

            // If a mine has not been added before, we add it
            if (plan[randomRow][randomCols] != -1) {
                plan[randomRow][randomCols] = -1;
                placedMines++;
            }
        }
        // Rest of the board will have 0s, if there is no mine
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                if (plan[i][j] != -1) {
                    plan[i][j] = 0;
                }
            }
        }
    }
    public void initializeBoard() {                     // Function that starts the game and controls its flow
        int row, col, step = 0;
        int size = rowNumber * colNumber;
        placedMines();

        System.out.println("Mines Coordinates");        // 4-Mines coordinates if we want to check it.
        displayBoard(plan);

        System.out.println("Game has started !");
        while (check) {  // 5- Get coordinates from the user and check
            displayBoard(board);
            System.out.print("Row : ");
            row = scan.nextInt();
            System.out.print("Column : ");
            col = scan.nextInt();

            if (row < 0 || row >= rowNumber) {
                System.out.println("Enter coordinates in valid range!");
                continue;
            }
             // If the cell has been visited before, warn the user
            if (cellVisited[row][col]) {
                System.out.println("You have already visited this cell.");
                continue;
            }
            if (col < 0 || col >= colNumber) {
                System.out.println("Enter coordinates in valid range!");
                continue;
            }
            cellVisited[row][col] = true; // Mark the cell as visited

            if (plan[row][col] != -1) {
                makeMove(row, col);
                step++;
                if (step == size - (size / 4)) {
                    System.out.println("You achieve it. You didn't step on any mines.");
                    break;  // 7- Win check ?
                }
            } else {
                check = false;
                System.out.println("You stepped on a mine! \n" +   // 6 - a Game Over ?
                        "Game Over!");
            }
        }
    }

    public void makeMove(int row, int col) {    // 6 - b Controls 8 directions and increases value if there are mines around

        if (plan[row][col] == 0) {
            if ((col > 0) && (plan[row][col - 1] == -1)) {                                          // Check Left
                board[row][col]++;
            }
            if ((row > 0 && col > 0) && (plan[row - 1][col - 1] == -1)) {                           // Check Left and Up
                board[row][col]++;
            }
            if ((row > 0) && (plan[row - 1][col] == -1)) {                                          // Check Up
                board[row][col]++;
            }
            if ((row > 0 && col < colNumber - 1) && (plan[row - 1][col + 1] == -1)) {               // Check Right and Up
                board[row][col]++;
            }
            if ((col < colNumber - 1) && (plan[row][col + 1] == -1)) {                              // Check Right
                board[row][col]++;
            }
            if ((row < rowNumber - 1 && col < colNumber - 1) && (plan[row + 1][col + 1] == -1)) {   // Check Right and Down
                board[row][col]++;
            }
            if ((row < rowNumber - 1) && (plan[row + 1][col] == -1)) {                              // Check Down
                board[row][col]++;
            }
            if ((row < rowNumber - 1 && col > 0) && (plan[row + 1][col - 1] == -1)) {               // Check Left and Down
                board[row][col]++;
            }
        }
        if (board[row][col] == 0) {
            board[row][col] = -2;
        }

    }
    public void displayBoard(int[][] matrix) {  // 4-Displays the game board, representing cells with appropriate symbols
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) {
                    System.out.print("* ");
                } else if (matrix[i][j] == -2) {
                    System.out.print("0 ");

                } else if (matrix[i][j] == 0) {
                    System.out.print("- ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("========================");
    }
}
