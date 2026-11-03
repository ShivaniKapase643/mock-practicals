
import java.util.Arrays;
import java.util.Scanner;

class NQueenA5 {
    static int n;
    static int[] board;
    static int step = 1;

    static boolean safe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col ||
                Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    static void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i] == j ? "Q " : "- ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean solve(int row) {
        if (row == n) {
            return true;
        }

        for (int col = 0; col < n; col++) {
            System.out.println("Step " + step++ +
                ": Checking Row " + (row + 1) +
                ", Column " + (col + 1));

            if (safe(row, col)) {
                board[row] = col;

                System.out.println("Queen placed at Row " +
                    (row + 1) + ", Column " + (col + 1));

                printBoard();

                if (solve(row + 1)) {
                    return true;
                }

                System.out.println("Backtracking from Row " +
                    (row + 1) + ", Column " + (col + 1));

                board[row] = -1;
                printBoard();

            } else {
                System.out.println("Position is not safe.\n");
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter board size (4 or 8): ");
        n = sc.nextInt();

        if (n < 1) {
            System.out.println("Board size must be positive.");
            sc.close();
            return;
        }

        board = new int[n];
        Arrays.fill(board, -1);

        if (solve(0)) {
            System.out.println("Final Solution:");
            printBoard();
        } else {
            System.out.println("No solution exists.");
        }

        sc.close();
    }
}