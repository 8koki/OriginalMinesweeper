package kadai7;

public class CellInfo {
	
	Bomb bomb;
	
	private Cell[][] cells;// = new Cell[width][height];
	private int x = 0;
	private int y = 0;

	//二次元配列分のセルを作成する
	public CellInfo(int width,int height) {
		//System.out.println("InfoX座標:"+ selectX + "InfoY座標" + selectY);
		cells = new Cell[width][height];
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < height; j++) {
				x = j;
				y = i;
				cells[i][j] = new Cell(x,y);
			}
		}
	}
	
	public Cell[][] getCell() {
		return cells;
	}
	public void setCell(Cell[][] cell) {
		this.cells = cell;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}