/**
 * 
 */
package demo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author DELL
 *
 */
public class TicTacToePlayer {
	
	private char[][] board;
	private char player;
	

	/**
	 * Initialising the char array to spaces
	 * Initialising the player to ''X'
	 */
	public TicTacToePlayer() {
		/*
		* Step 1: create an empty board, with an initial value
		* of a space (' ')
		*/
		this.board = new char[3][3];
		for(int i = 0; i < 3; i++){
			for (int j=0; j < 3; j++){
				board[i][j] = ' ';
			}
		}
		this.player = 'X';
	}
	
	/* 
	 * If s represents a valid move, add the current player's symbol to the board and return true.
	 * Otherwise return false.
	 */
	public boolean play(String s) {
		/* Step 2: Fill in here with your own
		* play logic, and replace the return with you
		* own.
		*/
		boolean validPlay = false;
		if(s== null ||s.isEmpty()){
			System.out.println("Input cant be empty");
			return validPlay;
		} else {
			if(s.trim().length()==1||s.trim().length()>2||s.trim().length()==0){
				System.out.println("Invalid Input. Please provide the valid input");
				return validPlay;
			}else if (s.trim().length()==2) {
				Pattern pattern = Pattern.compile("[a-cA-C][1-3]");
				Matcher checkMatcher = pattern.matcher(s);
				boolean find = checkMatcher.matches();
				String input = s.toUpperCase();
				if(find){
					char c = input.charAt(0);
					int row=0;
					switch (c) {
					case 'A':
						row =0;
						break;
					case 'B':
						row = 1;
						break;
					case 'C':
						row = 2;
						break;
					default:
						break;
					}
					
					String col= input.substring(1);
					int column = Integer.parseInt(col)-1;
					if(board[row][column] == ' '){
						board[row][column]= player;
						print(input);
						validPlay = true;
					}else{
						System.out.println("This move has already been made. Please make another move");
						validPlay = false;
					}
				}else{
					//to check if input length is 2 but doesn't follow the valid input format
					System.out.println("Invalid Input. Please provide the valid input");
					validPlay = false;
				}
				return validPlay; 
			}
			
		}
		return validPlay;
		
	}

	
	/*
	 * Switches the current player from X to O, or O to X.
	 */
	public void switchTurn() {
		// Step 3: Fill in with your code to toggle between
		// 'X' and 'O'
		char player = getPlayer();
		if(player =='X'){
			this.player ='O';
		}else{
			this.player ='X';
		}
	}
	
	public char getPlayer() {
		return player;
	}
	/*
	 * Ra1eturns true if the current player has won the game.
	 * Three in a row, column or either diagonal.
	 * Otherwise, return false.
	 */
	public boolean won() {
		
		/* Step 5: Fill in the code for the won method. This method
        * should return true if the current player has 3 in-a-row 
		* in any row, column or diagonal. Otherwise, return false.
		*/
		//check for rows
		boolean gameWon = false;
		
		if(checkRowsForWin()||checkColsForWin()||checkDiagnolsForWin()){
			gameWon = true;
			System.out.println("status:"+ gameWon);
		}
		return gameWon; 
	}
	
	/**
	 * This method will return true if any of the rows contain 
	 * 'X' or 'O'  in all section
	 * @return boolean Returns true or false if rows match
	 */
	public boolean checkRowsForWin(){
		boolean rowsMatched = false;
		for (int i = 0; i<3 ; i++ ) {
			if (checkValue(board[i][0], board[i][1], board[i][2])){
				rowsMatched = true;
				return rowsMatched;
			}
		}
		return rowsMatched;
	}
	
	/**
	 * This method will return true if any of the columns contain 
	 * 'X' or 'O'  in all section
	 * @return boolean Returns true or false if columns match
	 */
	public boolean checkColsForWin() {
		boolean colsMatched = false;
		/**/
		for (int i = 0; i<3 ; ++i ) {
			if (checkValue(board[0][i], board[1][i], board[2][i])){
				colsMatched = true;
				return colsMatched;
			}
		}
		return colsMatched;
	}
	
	/**
	 * This method will return true if any of the columns contain 
	 * 'X' or 'O'  in all section
	 * @return boolean Returns true or false if diagonals match
	 */
	public boolean checkDiagnolsForWin() {
		boolean diaMatched = false;
		if(checkValue(board[0][0], board[1][1], board[2][2])||checkValue(board[0][2], board[1][1], board[2][0])){
			diaMatched = true;
		}
		return diaMatched;
	}
	
	/**
	 * This method will return true if all three value matches 
	 * @param val1, val2, val3
	 * @return boolean Returns true or false if value match
	 */
	public boolean checkValue( char val1, char val2, char val3){
		if(((val1 == val2) && (val2 == val3) && (val1 == val3) && (val1 == 'X' || val1 == 'O'))){
			return true;
		}else
			return false;
	}
	
	public boolean boardFull() {
		boolean isFull = true;
		for (int i=0; i<3; i++){
			for (int j=0; j<3; j++){
				if(board[i][j] == ' '){
					isFull = false;
					return isFull;
				}
			}
		}
		return isFull;
	}
	
	
	public static void main(String[] args) {
		TicTacToePlayer ticTacToePlayer = new TicTacToePlayer();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to tic-tac-toe");
		
		ticTacToePlayer.print("");
		
			while(!(ticTacToePlayer.won())&&!(ticTacToePlayer.boardFull())){
				if(ticTacToePlayer.won()){
					
					System.out.println("game won");
					System.exit(0);
					break;
				}
				System.out.println("Enter coordinates for your move following the X and O prompts:");
				if (ticTacToePlayer.play(scanner.next())) {
					
					ticTacToePlayer.switchTurn();
				}
			}
			System.out.println("You cant make more moves");
		
		scanner.close();
	}
	/**
	 * @param args
	 */
	public void print(String input) {
		
		
		System.out.println("\t   1   2   3");
		System.out.println();
		System.out.println("\tA  "+ board[0][0] +" | "+ board[0][1]+ " | " + board[0][2]);
		System.out.println("\t  -----------");
		System.out.println("\tB  "+ board[1][0] +" | " + board[1][1]+ " | " + board[1][2]);
		System.out.println("\t  -----------");
		System.out.println("\tC  "+ board[2][0] +" | " + board[2][1]+ " | " + board[2][2]);
		System.out.println();
		

	}

}
