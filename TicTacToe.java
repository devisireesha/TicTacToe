import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {

            }
        }
        char player = 'X';
        boolean gameOver = false;
        Scanner in = new Scanner(System.in);
        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + " Enter: ");
            int row = in.nextInt();
            int col = in.nextInt();

            if (board[row][col] == '\u0000') {
                board[row][col] = player; //place the element
                gameOver = haveWon(board, player);
                if (gameOver) {
                    System.out.println("Player " + player + " has won.");
                } else {
//                    if (player =='X') {
//                        player='O';
//                    }
//                    else{
//                        player='x';
//                    }
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again!");
            }

            if (isBoardFull(board) && !gameOver) {
                System.out.println("The game ended in a draw.");
                break;
            }
        }

        printBoard(board);
    }

    public static boolean haveWon(char[][] board, char player) {
        // Check the row
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        // Check the column
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        // Check the diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        // Check for a draw
        boolean isDraw = true;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '\u0000') {
                    isDraw = false;
                    break;
                }
            }
            if (!isDraw) {
                break;
            }
        }

        return false;
    }

        public static void printBoard(char[][] board){

            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    System.out.print(board[row][col] + " | ");
                }
                System.out.println();
            }
        }
    public static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '\u0000') {
                    return false;
                }
            }
        }
        return true;
    }

}
