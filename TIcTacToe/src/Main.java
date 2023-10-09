import java.util.Scanner;

public class Main {
    // Inisialisasi Variabel dan Kerangka Papan Permainan
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    // Looping
    public static void main(String[] args) {
        initializeBoard();
        boolean gameOver = false;

        while (!gameOver) {
            printBoard();
            makeMove();
            gameOver = checkGameOver();
            switchPlayer();
        }

    }

    // Setting Kerangka Papan Permainan
    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Setting Tampilan Papan Permainan
    private static void printBoard() {
        System.out.println("_____________");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n_____________");
        }
    }

    // Alur Permainan
    private static void makeMove() {
        int row, col;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Player " + currentPlayer + ", input row (0, 1, atau 2) and column (0, 1, atau 2): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ');

        board[row][col] = currentPlayer;
    }

    //Pernyataan Hasil Permainan
    private static boolean checkGameOver() {
        return checkWin() || checkDraw();
    }

    private static boolean checkWin() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    // Setting Menang - Baris
    private static boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    // Setting Menang - Kolom
    private static boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    // Setting Menang - Diagonal
    private static boolean checkDiagonals() {
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    // Setting Draw
    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        System.out.println("Game ended with draw");
        return true;
    }

    // Alur Pergantian Pemain
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}

// Project created by Bill Gram Melkisedek & Reffki Andrea Pratama
// Group One, Informatics Major, Engineering Faculty, University of Bengkulu