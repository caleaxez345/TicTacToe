import java.util.Random;
import java.util.Scanner;
public class TicTacToe {
    public static void main (String[]args)
    {
        //Creating a board for the tic-tac-toe board using a 2D array.
        char[][] board = {{' ', ' ', ' '}, 
                          {' ', ' ', ' '}, 
                          {' ', ' ', ' '}};
        //Calling printboard method & passing board from main into there to also print out.
        printBoard(board);

        while(true){
        //Calling playerturn method to allow player to enter input on what spot they pick.
        playerTurn(board);

        //Calling the method that determines if the game is over or not for player turn.
        if(isGameOver(board)){
            //break from loop if the game is finished.
            break;
        }

        //Calling printboard method to print
        printBoard(board);

        //Calling the computerTurn method so that the comptuer gets their turn.
        computerTurn(board);

        //Calling the game over method for computer turn
        if(isGameOver(board)){
            //Break if game is over.
            break;
        }
        
        //Print the board.
        printBoard(board);
        }  
    }

    //Creating a method to print the boardgame.
    private static void printBoard(char[][] board){
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println("-+-+-");
    }

    //Creating a method to get user input and show them where on the board they selected.
    public static void playerTurn(char[][] board)
    {
        String input;
        while(true){
        Scanner scan = new Scanner(System.in);
        System.out.print("Where would you like to play? (1-9): ");
        //Getting the user input.
        input = scan.nextLine();

        //Calling computerValidMove mrthod and passing the info in these parameters over there.
        if (computerValidMove(board, input)){
            break;
        }
            else {
                System.out.println(input + " Is not a valid move");
            }
        }
        //Calling playermove and pass the parameters over there.
        playerMove(board, input, 'X');
    }

    //Method to place player move.
    private static void playerMove(char[][] board, String position, char sign){
        //Switch depending on user input
        switch(position){
            case "1":
                board[0][0] = sign;
                break;
            case "2":
                board[0][1] = sign;
                break;
            case "3":
                board[0][2] = sign;
                break;
            case "4":
                board[1][0] = sign;
                break;
            case "5":
                board[1][1] = sign;
                break;
            case "6":
                board[1][2] = sign;
                break;
            case "7":
                board[2][0] = sign;
                break;
            case "8":
                board[2][1] = sign;
                break;
            case "9":
                board[2][2] = sign;
                break;  
            default:
                System.out.println(":(");
        }
    }


    //Creating a method for computer to determine if space is available on the board.
    private static boolean computerValidMove (char[][] board, String position){
        switch(position){
            case "1":
                return (board[0][0] == ' ');     
            case "2":
                return (board[0][1] == ' ');     
            case "3":
                return (board[0][2] == ' ');     
            case "4":
                return (board[1][0] == ' ');     
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');     
            case "7":
                return (board[2][0] == ' ');     
            case "8":
                return (board[2][1] == ' ');     
            case "9":
                return (board[2][2] == ' ');     
            default:
                return false;
        }
    }

    //Creating a method to get the turn for the computer.
    private static void computerTurn(char[] [] board)
    {
        //Making new random object.
        Random rand = new Random();
        int compMove;
        //While true loop to see if a spot is taken and if it is the AI loops for an open spot.
        while(true){
             //Getting a random int between 1 and 9.
            compMove = rand.nextInt(9)+1;

            //Call computerValidMove method and pass the parameters.
            if(computerValidMove(board, Integer.toString(compMove))){
                //If exits loop the computer play is valid move.
                break;
            }
        }
        System.out.println("Computer chose " + compMove);
        playerMove(board, Integer.toString(compMove), 'O');
    }

    //Method to determine if the game is over.
    private static boolean isGameOver(char[][] board){
        //Calling this method to determine if someone won
        if(hasContestantWon(board, 'X'))
        {
            printBoard(board);
            System.out.println("The player wins!");
            return true;
        }
        if(hasContestantWon(board, 'O'))
        {
            printBoard(board);
            System.out.println("The computer wins!");
            return true;
        }

        //If nobody won then it goes to this because it's a tie.
        //for loop for rows.
        for(int i = 0; i < board.length; i++)
        {
            //For loop looking through columns and the i index.
            for(int j = 0; j < board[i].length; j++)
            {
                //If blank spot and false then game isn't over
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }

        //Call this method to print the final board which shows the end result.
        printBoard(board);
        System.out.println("Game ended in a tie!");

        //Returns true if the game is completely over.
        return true;
    }

    public static boolean hasContestantWon(char[][] board, char sign){
        //Checking if anybody won.
        if((board[0][0] == sign && board[0][1] == sign && board[0][2] == sign) ||
            (board[1][0] == sign && board[1][1] == sign && board[1][2] == sign) ||
            (board[2][0] == sign && board[2][1] == sign && board[2][2] == sign) ||

            (board[0][0] == sign && board[1][0] == sign && board[2][0] == sign) ||
            (board[0][1] == sign && board[1][1] == sign && board[2][1] == sign) ||
            (board[0][2] == sign && board[1][2] == sign && board[2][2] == sign) ||

            (board[0][0] == sign && board[1][1] == sign && board[2][2] == sign) ||
            (board[0][2] == sign && board[1][1] == sign && board[2][0] == sign) ) 
            {
                return true;
            }
        return false;
    }
}