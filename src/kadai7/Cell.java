package kadai7;

public class Cell {
	
	private boolean isFlag;//旗たてられているか
	private boolean isOpen;//マスが開かれているか
	private boolean isBomb;//爆弾かどうか
	private boolean isGameOver;//ゲームオーバーかどうか
	private int CellX;//座標
	private int CellY;//座標
	private int count = 0;
	
	//コンストラクタ
	public Cell(int x,int y) {
		isFlag = false;
		isOpen = false;
		isBomb = false;
		isGameOver = false;
		CellX = x;
		CellY = y;
	}
	//countを＋1する
	public void addCount() {
		this.count++;
	}
	
	public int getCellX() {
		return CellX;
	}
	public int getCellY() {
		return CellY;
	}
	public void setCellX(int CellX) {
		this.CellX = CellX;
	}
	public void setCellY(int CellY) {
		this.CellY = CellY;
	}
	public boolean getIsBomb() {
		return isBomb;
	}
	public void setIsBomb() {
		this.isBomb = true;
	}
	public boolean getIsOpen() {
		return isOpen;
	}
	public void setIsOpen() {
		this.isOpen=true;
	}
	public boolean getIsFlag() {
		return isFlag;
	}
	public void setIsFlag(boolean isFlag) {
		this.isFlag = isFlag;
	}
	public boolean getIsGameOver() {
		return isGameOver;
	}
	public void setIsGameOver() {
		this.isGameOver = true;
	}
	public int getCount() {
		return this.count;
	}
}