import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int rows, cols;

        System.out.println("Welcome to MineSweeper Game !");
        Scanner scan = new Scanner(System.in);

        // 3 - Loop until the user enters valid values
        while (true) {
            System.out.print("Enter the number of rows (between 2 and 16): ");
            rows = scan.nextInt();

            // Row number check
            if (rows >= 2 && rows <= 16) {
                break; // Success, exit the loop
            } else {
                System.out.println("Please enter a valid number of rows.");
            }
        }

        // The same check can be done for columns as well
        while (true) {
            System.out.print("Enter the number of columns (between 2 and 16): ");
            cols = scan.nextInt();

            // Column number check
            if (cols >= 2 && cols <= 16) {
                break;
            } else {
                System.out.println("Please enter a valid number of columns.");
            }
        }

        MineSweeper mine = new MineSweeper(rows, cols);
        mine.initializeBoard();
    }

}
