package kadai7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bomb {
	
	Board board;
	CellInfo cellInfo;
	Cell[][] cell;
	
	private int bombs = 30;
	private int num1,num2;
	private List <Integer> xValue = new ArrayList<Integer>();
	private List <Integer> yValue = new ArrayList<Integer>();
	
	//コンストラクタ(インスタンス化)
	public Bomb(CellInfo cellInfo) {
		this.cellInfo = cellInfo;
		this.cell= cellInfo.getCell();
	}
	
	//爆弾の作成
	public void makeAllBomb(int x,int y,int height) {
		int count=0;
			while(count < bombs) {
			Random random = new Random();
			num1 = random.nextInt(12);
			num2 = random.nextInt(12);
			if(yValue.size() >= 0) {
				boolean isSelectedNumber = false;
				for(int j = 0;j < yValue.size();j++) {
					if(xValue.get(j) == num1 && yValue.get(j) == num2) {
						isSelectedNumber = true;
					}
				}
				if(!isSelectedNumber&&x!=num1&&y!=num2&&x-1!=num1&&y-1!=num2&&x+1!=num1&&y+1!=num2) {
					xValue.add(num1);
					yValue.add(num2);
					count++;
					cell[num2][num1].setIsBomb();
					for(int j = -1; j < 2; j++) {
						for(int k = -1; k < 2; k++) {
							//二次元配列の範囲内で
							if(-1 < num2 + k && num2 + k < height && -1 < num1 + j && num1 + j < height) {
								//cellに周辺の爆弾数を格納する。
								cell[num2 + k][num1 + j].addCount();
							}
						}
					}
				}
			}
			}
	}
	
	public int getBombs() {
		return bombs;
	}
	public List<Integer> getyValue() {
		return yValue;
	}
	public List<Integer> getxValue() {
		return xValue;
	}
	public void setyValue(List<Integer> yValue) {
		this.yValue = yValue;
	}
	public void setxValue(List<Integer> xValue) {
		this.xValue = xValue;
	}
	public void testBombCount() {
		System.out.println("testBombCount is called");
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(cell[i][j].getIsBomb()) {
					System.out.println("(x:"+j+",y:"+i+")");
				}
			}
		}
	}
}
