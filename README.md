# MineSweeper Game

This is a console-based implementation of the classic game MineSweeper in Java.

## Author

- Serhat Acar

## Instructions

1. **Compile the Java files** using `javac`:

    ```bash
    javac Main.java | MineSweeper.java
    ```

2. **Run the game** using `java`:

    ```bash
    java Main
    ```

3. Follow the prompts to input the number of rows and columns for the game board.

4. Play the MineSweeper game and avoid stepping on mines!


## How to Play

- Enter the row and column coordinates to reveal a cell.
- If the revealed cell is a mine, the game ends.
- If the revealed cell is empty, it shows the number of mines in the adjacent cells.
- Try to reveal all cells without stepping on a mine.

## Notes

- Cells are represented by numbers indicating the number of nearby mines.
- Mines are represented by `*`.
- Unrevealed cells are initially represented by `-`.

- ## License

This project is licensed under the [MIT License](LICENSE).

