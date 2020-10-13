
public class Cell {
	private int row;
	private int col;
	private char value;

	public Cell(final int row, final int col, final char value) {
		this.row = row;
		this.col = col;
		this.value = value;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public char getValue() {
		return value;
	}

	public void setCol(final int col) {
		this.col = col;
	}

	public void setRow(final int row) {
		this.row = row;
	}

	public void setValue(final char value) {
		this.value = value;
	}

}
