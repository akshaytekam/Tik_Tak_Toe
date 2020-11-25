 
package game;
 
import java.util.Arrays;
import java.util.Scanner;

 
public class Game {
	static Scanner in;
	static String[] board;
	static String turn;
     
    static void askUser(){
        String win = null;
	System.out.println("X's will play first");            //Entering slot values
        System.out.println("Please enter the slot number.");

	while (win == null) {                       //Checking the Invalid data.  
	    int input;
		try {
			input = in.nextInt();
			if (!(input > 0 && input <= 9)) {
			System.out.println("Invalid");
			continue;
	            }
	        } catch (Exception e) {
			System.out.println("Invalid");
			continue;
		}
	if (board[input-1].equals(String.valueOf(input))) {
			board[input-1] = turn;
			if (turn.equals("X")) {
			turn = "O";
		} else {
			turn = "X";
	}
		printBoard();
		win = check();
		}  
	}
		if (win.equalsIgnoreCase("Tie")) {
			System.out.println("It's a Tie");
		} else {
			System.out.println("Winner is: " + win);
		}
	}
        
static String check() {                                //Checking the winner
	for (int i = 0; i < 8; i++) {
		String row = null;
		switch (i) {
		case 0:
			row=board[0]+board[1]+board[2];
			break;
		case 1:
			row =board[3]+ board[4]+board[5];
			break;
		case 2:
			row = board[6]+board[7]+board[8];
			break;
		case 3:
			row = board[0]+board[3]+board[6];
			break;
		case 4:
			row = board[1]+board[4]+board[7];
			break;
		case 5:
			row = board[2]+board[5]+board[8];
			break;
		case 6:
			row = board[0]+board[4]+board[8];
			break;
		case 7:
			row = board[2]+board[4]+board[6];
			break;
			}
			if (row.equals("XXX")) {
				return "X";
			} else if (row.equals("OOO")) {
				return "O";
			}
		}

		/*for (int i = 0; i < 9; i++) {
			if (Arrays.asList(board).contains(String.valueOf(i+1))) {
				break;
			}
			 
		}*/

		System.out.println(turn + "'s turn");
		return null;
	}

   static void printBoard() {            //Printing the Board
		 
	System.out.println("* " + board[0] + " * " + board[1] + " * " + board[2] + " *");
	System.out.println("*-----------*");
	System.out.println("* " + board[3] + " * " + board[4] + " * " + board[5] + " *");
	System.out.println("*-----------*");
	System.out.println("* " + board[6] + " * " + board[7] + " * " + board[8] + " *");
		 
	}

	static void emptyBoard() {
		for (int i = 0; i < 9; i++) {
			board[i] = String.valueOf(i+1);
		}
	}
        public static void main(String[] args) {
		in = new Scanner(System.in);
		board = new String[10];
		turn = "X";
		
		emptyBoard();

		printBoard();
                askUser();
        }
}