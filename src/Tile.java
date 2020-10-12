
public class Tile {
	
	public int row;
	public int col;
	public int value;
	
	public Tile(int x, int y) {
		this.row = x;
		this.col = y;
		this.value = 0;
	}
	
	public Tile() {
		this.value = 0;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "" + value;
	}
}
