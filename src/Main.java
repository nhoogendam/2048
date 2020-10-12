import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class Main {

	public static void main(String[] args) {
		Tile[][] board = new Tile[4][4];
		reset(board);
		printBoard(board);
		spawn(board);
		printBoard(board);
		mergeRowCol(board, "Column", 1);
		printBoard(board);
	}
	
	public static void reset(Tile[][] board) {
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				board[row][col] = new Tile(row,col);
			}
		}
	}
	
	public static void printBoard(Tile[][] board) {
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col].getValue() + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void spawn(Tile[][] board) {
		Random rand = new Random();
		int firrow = 1;
		int fircol = rand.nextInt(4);
		int secrow = 1;
		int seccol = rand.nextInt(4);
		if(firrow != secrow || fircol != seccol && 
				(board[secrow][seccol].getValue() == 0 && board[firrow][fircol].getValue() == 0)) {
			board[secrow][seccol].setValue(2);
			board[firrow][fircol].setValue(2);
		}
	}
	
	@SuppressWarnings("resource")
	public static void direction(Tile[][] board) {
		Scanner input = new Scanner(System.in);
		System.out.println("  2");
		System.out.println("1   3");
		System.out.println("  4");
		System.out.print("Direction: ");
		int dir = input.nextInt();
		System.out.println();
		moveTiles(dir, board);
	}
	public static void moveTiles(int direction, Tile[][] board) {
		ArrayList<Tile> tiles = activeTiles(board);
		if(direction == 1) {
			for(int i = 0; i < 4; i++) {
				
			}
		} 
		else if(direction == 2) {
			
		}
		else if (direction == 3) {
			
		}
		else if(direction == 4) {
			
		}
	}
	
	public static ArrayList<Tile> activeTiles(Tile[][] board){
		ArrayList<Tile> list = new ArrayList<Tile>();
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board.length; col++) {
				if(board[row][col].getValue() != 0)
					list.add(board[row][col]);
			}
		}
		return list;
	}
	
	/*
	 * TODO: Figure out how to merge the tiles together so 
	 * 2 0 2 0 ----> 4 0 0 0
	 */
	public static void mergeRowCol(Tile[][] board, String colRow, int colRowNum) {
		if(colRow.equals("Column")) {
			int k = 0;
			int lastVal = 0;
			for(int i = 0; i < 4; i++) {
				Tile tile = board[colRowNum][i];
				if(tile.getValue() != 0) {
					board[colRowNum][k].setValue(tile.getValue());
					k++;
					if(i >= k) {
						tile.setValue(0);
					}
				}
			}
		}
		else if(colRow.equals("Row")) {
			
		}
	}
	public static void swap(Tile t1, Tile t2) {
		int temp = t1.getValue();
		t1.setValue(t2.getValue());
		t2.setValue(temp);
	}
	
	
}
