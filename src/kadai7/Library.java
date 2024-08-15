package kadai7;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Library {
	
	//背景,説明で使う画像
	private Image backGround = new Image("file:///C:./src/kadai7/image/backGround.jpg");
	private Image paper = new Image("file:///C:./src/kadai7/image/paper.png");
	private Image gyutan = new Image("file:///C:./src/kadai7/image/gyutan.jpg");//1
	private Image zunda = new Image("file:///C:./src/kadai7/image/zunda.jpg");
	private Image sasakama = new Image("file:///C:./src/kadai7/image/sasakama.jpg");
	private Image hiyasi = new Image("file:///C:./src/kadai7/image/hiyasi.jpg");
	private Image mabo = new Image("file:///C:./src/kadai7/image/ma-bo-.jpg");
	private Image sendaiCastle = new Image("file:///C:./src/kadai7/image/sendaicastle.jpg");//6
	private Image tanabata = new Image("file:///C:./src/kadai7/image/tanabata.jpg");
	private Image aoba = new Image("file:///C:./src/kadai7/image/aoba.jpg");
	private Image hikari = new Image("file:///C:./src/kadai7/image/hikari.jpg");
	private Image onsen = new Image("file:///C:./src/kadai7/image/onsen.jpg");
	private Image gyutanE = new Image("file:///C:./src/kadai7/image/explanation1.PNG");
	private Image zundaE = new Image("file:///C:./src/kadai7/image/explanation2.PNG");
	private Image sasakamaE = new Image("file:///C:./src/kadai7/image/explanation3.PNG");
	private Image hiyasiE = new Image("file:///C:./src/kadai7/image/explanation4.PNG");
	private Image maboE = new Image("file:///C:./src/kadai7/image/explanation5.PNG");
	private Image sendaiCastleE = new Image("file:///C:./src/kadai7/image/explanation6.PNG");
	private Image tanabataE = new Image("file:///C:./src/kadai7/image/explanation7.PNG");
	private Image aobaE = new Image("file:///C:./src/kadai7/image/explanation8.PNG");
	private Image hikariE = new Image("file:///C:./src/kadai7/image/explanation9.PNG");
	private Image onsenE = new Image("file:///C:./src/kadai7/image/explanation10.PNG");
	//
	private List<String> itemList = new ArrayList<>();
	private Button itemButton1,itemButton2,itemButton3,itemButton4,itemButton5,
	itemButton6,itemButton7,itemButton8,itemButton9,itemButton10;
	private HBox hbox1;
	private HBox hbox2;
	private VBox vbox;
	private Button exit;
	private Label resource;
	private ImageView explanation;
	private ImageView picture;
	
	public Library() {
		itemButton1 = new Button();
		itemButton2 = new Button();
		itemButton3 = new Button();
		itemButton4 = new Button();
		itemButton5 = new Button();
		itemButton6 = new Button();
		itemButton7 = new Button();
		itemButton8 = new Button();
		itemButton9 = new Button();
		itemButton10 = new Button();
		hbox1 = new HBox();
		hbox2 = new HBox();
		vbox = new VBox();
		exit = new Button("終了");
		resource = new Label();
		picture = new ImageView();
		explanation = new ImageView();
	}
	
	public void libraryShow(Stage primaryStage) {
		ImageView backG = new ImageView(backGround);
		ImageView paperG = new ImageView(paper);
		AnchorPane ap = new AnchorPane();
		//背景の大きさ
		backG.setFitWidth(1050);
		backG.setFitHeight(730);
		//紙の大きさ
		paperG.setFitWidth(1100);
		paperG.setFitHeight(720);
		AnchorPane.setTopAnchor(paperG, 0.);
		AnchorPane.setRightAnchor(paperG, -40.);
		//ボタンの大きさ,位置
		hbox1.getChildren().addAll(itemButton1,itemButton2,itemButton3,itemButton4,itemButton5);
		hbox2.getChildren().addAll(itemButton6,itemButton7,itemButton8,itemButton9,itemButton10);
		vbox.getChildren().addAll(hbox1,hbox2);//ボタン
		itemButton1.setPrefSize(50, 50);
		itemButton2.setPrefSize(50, 50);
		itemButton3.setPrefSize(50, 50);
		itemButton4.setPrefSize(50, 50);
		itemButton5.setPrefSize(50, 50);
		itemButton6.setPrefSize(50, 50);
		itemButton7.setPrefSize(50, 50);
		itemButton8.setPrefSize(50, 50);
		itemButton9.setPrefSize(50, 50);
		itemButton10.setPrefSize(50, 50);
		AnchorPane.setTopAnchor(vbox, 585.);
		AnchorPane.setRightAnchor(vbox, 250.);
		//ボタンに画像を入れる
		setItemImage();
		//取得して未使用のアイテムのみボタンを押せるようにする。
		setAcceptButton();
		//終了ボタンの調整
		exit.setPrefSize(100, 50);
		AnchorPane.setTopAnchor(exit, 610.);
		AnchorPane.setRightAnchor(exit, 120.);
		//観光資源名の大きさ,位置
		resource.setPrefSize(300, 300);
		resource.setFont(new Font(30));
		AnchorPane.setTopAnchor(resource, -70.);
		//観光資源画像の大きさ,位置
		picture.setFitWidth(400);
		picture.setFitHeight(400);
		AnchorPane.setTopAnchor(picture, 100.);
		AnchorPane.setRightAnchor(picture, 100.);
		//
		explanation.setFitWidth(450);
		explanation.setFitHeight(400);
		AnchorPane.setTopAnchor(explanation, 100.);
		AnchorPane.setRightAnchor(explanation, 500.);
		//起動時Windowの大きさ
		Scene scene = new Scene(ap,1050,730);
		ap.getChildren().addAll(backG,paperG,vbox,exit,resource,picture,explanation);
		primaryStage.setScene(scene);
		//サイズ固定
		primaryStage.setTitle("マインスイーパー");
		exit.setOnAction((ActionEvent)->{
			System.exit(0);
		});
		itemButton1.setOnAction((ActionEvent)->{
			resource.setText("牛たん焼き");
			AnchorPane.setRightAnchor(resource, 65.);
			picture.setImage(gyutan);
			explanation.setImage(gyutanE);
		});
		itemButton2.setOnAction((ActionEvent)->{
			resource.setText("ずんだ");
			AnchorPane.setRightAnchor(resource, 45.);
			picture.setImage(zunda);
			explanation.setImage(zundaE);
		});
		itemButton3.setOnAction((ActionEvent)->{
			resource.setText("笹かまぼこ");
			AnchorPane.setRightAnchor(resource, 45.);
			picture.setImage(sasakama);
			explanation.setImage(sasakamaE);
		});
		itemButton4.setOnAction((ActionEvent)->{
			resource.setText("冷やし中華");
			AnchorPane.setRightAnchor(resource, 45.);
			picture.setImage(hiyasi);
			explanation.setImage(hiyasiE);
		});
		itemButton5.setOnAction((ActionEvent)->{
			resource.setText("マーボー焼きそば");
			AnchorPane.setRightAnchor(resource, 65.);
			picture.setImage(mabo);
			explanation.setImage(maboE);
		});
		itemButton6.setOnAction((ActionEvent)->{
			resource.setText("仙台城跡");
			AnchorPane.setRightAnchor(resource, 45.);
			picture.setImage(sendaiCastle);
			explanation.setImage(sendaiCastleE);
		});
		itemButton7.setOnAction((ActionEvent)->{
			resource.setText("仙台七夕まつり");
			AnchorPane.setRightAnchor(resource, 85.);
			picture.setImage(tanabata);
			explanation.setImage(tanabataE);
		});
		itemButton8.setOnAction((ActionEvent)->{
			resource.setText("仙台・青葉まつり");
			AnchorPane.setRightAnchor(resource, 85.);
			picture.setImage(aoba);
			explanation.setImage(aobaE);
		});
		itemButton9.setOnAction((ActionEvent)->{
			resource.setText("SENDAI光のページェント");
			AnchorPane.setRightAnchor(resource, 125.);
			picture.setImage(hikari);
			explanation.setImage(hikariE);
		});
		itemButton10.setOnAction((ActionEvent)->{
			resource.setText("秋保温泉");
			AnchorPane.setRightAnchor(resource, 45.);
			picture.setImage(onsen);
			explanation.setImage(onsenE);
		});
	}
	//ボタンに画像を入れる
	private void setItemImage() {
		ImageView item1 = new ImageView(gyutan);
		itemButton1.setGraphic(item1);
		item1.setFitHeight(27);
	    item1.setFitWidth(27);
	    itemButton1.setDisable(true);
		ImageView item2 = new ImageView(zunda);
		itemButton2.setGraphic(item2);
		item2.setFitHeight(27);
	    item2.setFitWidth(27);
	    itemButton2.setDisable(true);
		ImageView item3 = new ImageView(sasakama);
		itemButton3.setGraphic(item3);
		item3.setFitHeight(27);
	    item3.setFitWidth(27);
	    itemButton3.setDisable(true);
		ImageView item4 = new ImageView(hiyasi);
		itemButton4.setGraphic(item4);
		item4.setFitHeight(27);
	    item4.setFitWidth(27);
	    itemButton4.setDisable(true);
		ImageView item5 = new ImageView(mabo);
		itemButton5.setGraphic(item5);
		item5.setFitHeight(27);
	    item5.setFitWidth(27);
	    itemButton5.setDisable(true);
		ImageView item6 = new ImageView(sendaiCastle);
		itemButton6.setGraphic(item6);
		item6.setFitHeight(27);
	    item6.setFitWidth(27);
	    itemButton6.setDisable(true);
		ImageView item7 = new ImageView(tanabata);
		itemButton7.setGraphic(item7);
		item7.setFitHeight(27);
	    item7.setFitWidth(27);
	    itemButton7.setDisable(true);
		ImageView item8 = new ImageView(aoba);
		itemButton8.setGraphic(item8);
		item8.setFitHeight(27);
	    item8.setFitWidth(27);
	    itemButton8.setDisable(true);
		ImageView item9 = new ImageView(hikari);
		itemButton9.setGraphic(item9);
		item9.setFitHeight(27);
	    item9.setFitWidth(27);
	    itemButton9.setDisable(true);
		ImageView item10 = new ImageView(onsen);
		itemButton10.setGraphic(item10);
		item10.setFitHeight(27);
	    item10.setFitWidth(27);
	    itemButton10.setDisable(true);
	}
	//
	private void setAcceptButton() {
		if(itemList.contains("牛たん焼き")) {
			itemButton1.setDisable(false);
		}
		if(itemList.contains("ずんだ")){
			itemButton2.setDisable(false);
		}
		if(itemList.contains("笹かまぼこ")) {
			itemButton3.setDisable(false);
		}
		if(itemList.contains("冷やし中華")) {
			itemButton4.setDisable(false);
		}
		if(itemList.contains("マーボー焼きそば")) {
			itemButton5.setDisable(false);
		}
		if(itemList.contains("仙台城跡")) {
			itemButton6.setDisable(false);
		}
		if(itemList.contains("仙台七夕まつり")) {
			itemButton7.setDisable(false);
		}
		if(itemList.contains("仙台・青葉まつり")) {
			itemButton8.setDisable(false);
		}
		if(itemList.contains("SENDAI光のページェント")) {
			itemButton9.setDisable(false);
		}
		if(itemList.contains("秋保温泉")) {
			itemButton10.setDisable(false);
		}
	}

	public void setList(List<String> playerItemList) {
		this.itemList = playerItemList;
	}

}
