
public class Tile {

	public int row;
	public int col;
	public int value;

	public Tile() {
		value = 0;
	}

	public Tile(final int x, final int y) {
		row = x;
		col = y;
		value = 0;
	}

	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	public int getValue() {
		return value;
	}

	public void setCol(final int col) {
		this.col = col;
	}

	public void setRow(final int row) {
		this.row = row;
	}

	public void setValue(final int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "" + value;
	}
}
