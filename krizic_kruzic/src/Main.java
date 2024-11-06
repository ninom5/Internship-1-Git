import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num = 1;
        int turn = 0;
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = (char) ('0' + num);
                num++;
            }
        }

        while(turn < 9)
        {
            displayCurrentBoard(board);
            if(turn % 2 == 0)
            {
                System.out.println("Player X plays");
                int field = sc.nextInt();
                if(isValid(board, field))
                {
                    board[(field - 1) / 3][(field - 1) % 3] = 'X';
                    if(isWin(board))
                    {
                        System.out.println("Player X wins");
                        return;
                    }
                    turn++;
                }
                else
                    System.out.println("Invalid input. Try again.");
            }
            else
            {
                System.out.println("Player O plays");
                int field = sc.nextInt();
                if(isValid(board, field))
                {
                    board[(field - 1) / 3][(field - 1) % 3] = 'O';
                    if(isWin(board))
                    {
                        System.out.println("Player O wins");
                        return;
                    }
                    turn++;
                }
                else
                    System.out.println("Invalid input. Try again.");
            }
        }
        displayCurrentBoard(board);
        System.out.println("Draw");
    }

    public static void displayCurrentBoard(char [][]board)
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean isValid(char [][] board, int field)
    {
        if(field < 1 || field > 9)
            return false;
        if(board[(field - 1) / 3][(field - 1) % 3] == 'X' || board[(field - 1) / 3][(field - 1) % 3] == 'O')
            return false;


        return true;
    }

    public static boolean isWin(char [][] board)
    {
        for(int i = 0; i < 3; i++)
        {
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2]) //provjeravamo redove
                return true;
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i]) //provjeravamo stupce
                return true;
        }

        if(board[0][0] == board[1][1] && board[1][1] == board[2][2])//dijagonala
            return true;
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0])//dijagonala
            return true;

        return false;
    }
}