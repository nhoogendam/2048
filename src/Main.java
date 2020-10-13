import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static ArrayList<Tile> activeTiles(final Tile[][] board) {
		final ArrayList<Tile> list = new ArrayList<>();
		for (final Tile[] element : board) {
			for (int col = 0; col < board.length; col++) {
				if (element[col].getValue() != 0) {
					list.add(element[col]);
				}
			}
		}
		return list;
	}

	@SuppressWarnings("resource")
	public static void direction(final Tile[][] board) {
		final Scanner input = new Scanner(System.in);
		System.out.println("  2");
		System.out.println("1   3");
		System.out.println("  4");
		System.out.print("Direction: ");
		final int dir = input.nextInt();
		System.out.println();
		moveTiles(dir, board);
	}

	public static void main(final String[] args) {
		final Tile[][] board = new Tile[4][4];
		reset(board);
		printBoard(board);
		spawn(board);
		printBoard(board);
		moveTiles(1, board);
		printBoard(board);
	}

	public static void mergeRow(final Tile[][] board, final int rowNum) {
		int k = 0;
		for (int i = 0; i < 4; i++) {
			final Tile tile = board[rowNum][i];
			if (tile.getValue() != 0) {
				board[rowNum][k].setValue(tile.getValue());
				k++;
				if (i >= k) {
					tile.setValue(0);
				}
			}
		}
	}

	/*
	 * TODO: Figure out how to merge the tiles together so 2 0 2 0 ----> 4 0 0 0
	 */
	public static void mergeRowCol(final Tile[][] board, final String colRow, final int colRowNum) {
		if (colRow.equals("row")) {
			mergeRow(board, colRowNum);
			mergeRowNums(board, colRowNum);
		} else if (colRow.equals("Row")) {

		}
	}

	public static void mergeRowNums(final Tile[][] board, final int colRowNum) {
		for (int i = 0; i < 3; i++) {
			if (board[colRowNum][i].getValue() == board[colRowNum][i + 1].getValue()) {
				board[colRowNum][i].setValue(board[colRowNum][i + 1].getValue() * 2);
				board[colRowNum][i + 1].setValue(0);
				mergeRow(board, colRowNum);
			}
		}
	}

	public static void moveTiles(final int direction, final Tile[][] board) {
		activeTiles(board);
		if (direction == 1) {
			for (int i = 0; i < 4; i++) {
				mergeRowCol(board, "row", i);
			}
		} else if ((direction == 2) || (direction == 3) || (direction == 4)) {

		}
	}

	public static void printBoard(final Tile[][] board) {
		for (final Tile[] element : board) {
			for (int col = 0; col < element.length; col++) {
				System.out.print(element[col].getValue() + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void reset(final Tile[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = new Tile(row, col);
			}
		}
	}

	public static void spawn(final Tile[][] board) {
		board[1][3].setValue(2);
		board[1][0].setValue(2);
		board[1][1].setValue(2);
		board[1][2].setValue(2);
	}

	public static void swap(final Tile t1, final Tile t2) {
		final int temp = t1.getValue();
		t1.setValue(t2.getValue());
		t2.setValue(temp);
	}

}
