package kadai7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomEvent {
	
	private ArrayList<String> list = new ArrayList<>();
	private ArrayList<String> itemList = new ArrayList<>();
	private Random random = new Random();
	int number = 0;
	
	public RandomEvent() {
		//食べ物
		list.add("牛たん焼き");//
		list.add("ずんだ");//
		list.add("笹かまぼこ");//
		list.add("冷やし中華");
		list.add("マーボー焼きそば");
		//観光地
		list.add("仙台城跡");
		list.add("仙台七夕まつり");
		list.add("仙台・青葉まつり");
		list.add("SENDAI光のページェント");
		list.add("秋保温泉");
		Collections.shuffle(list);
		itemList.add("牛たん焼き");
		itemList.add("ずんだ");
		itemList.add("笹かまぼこ");
		itemList.add("冷やし中華");
		itemList.add("マーボー焼きそば");
		//観光地
		itemList.add("仙台城跡");
		itemList.add("仙台七夕まつり");
		itemList.add("仙台・青葉まつり");
		itemList.add("SENDAI光のページェント");
		itemList.add("秋保温泉");
	}
	
	public boolean eventCheck() {
		int rnd = random.nextInt(10);
		if(rnd == 0 || rnd == 1 || rnd == 2 || rnd == 3) {
			return true;
		}else {
			return false;
		}
	}
	
	public void resetList() {
			list.clear();
			//食べ物
			list.add("牛たん焼き");//
			list.add("ずんだ");//
			list.add("笹かまぼこ");//
			list.add("冷やし中華");//
			list.add("マーボー焼きそば");//
			//観光地
			list.add("仙台城跡");//
			list.add("仙台七夕まつり");//
			list.add("仙台・青葉まつり");//
			list.add("SENDAI光のページェント");
			list.add("秋保温泉");
			Collections.shuffle(list);
	}
	
	public int getNumber() {
		return number;
	}

	public ArrayList<String> getList() {
		return list;
	}
	
	public ArrayList<String> getItemList() {
		return itemList;
	}
	
}
