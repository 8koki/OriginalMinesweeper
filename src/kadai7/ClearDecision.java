package kadai7;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClearDecision {
	
	Library libra = new Library();
	
	private Image backGround = new Image("file:///C:./src/kadai7/image/backGround.jpg");
	private Image clear = new Image("file:///C:./src/kadai7/image/clear.png");
	private Image failed = new Image("file:///C:./src/kadai7/image/failed.png");
	private List<String> itemList = new ArrayList<>();

	//クリア時
	public void clearShow(Stage primaryStage) {
		ImageView backG = new ImageView(backGround);
		ImageView title = new ImageView(clear);
		backG.setFitWidth(1050);
		backG.setFitHeight(730);
		AnchorPane ap = new AnchorPane();
		//起動時Windowの大きさ
		Scene scene = new Scene(ap,1050,730);
		primaryStage.setScene(scene);
		//サイズ固定
		primaryStage.setTitle("マインスイーパー");
		//ラベル,ボタンの作成
		//Label title = new Label("ゲームクリア");
		VBox vbox = new VBox(20);
		Button library = new Button("資源一覧(アイテム未使用)");
		Button exit = new Button("終了");
		library.setPrefSize(200,50);
		exit.setPrefSize(100, 50);
		//配置位置,大きさの設定
		//title.setFont(new Font(40));
		vbox.getChildren().addAll(title,library,exit);
		vbox.setAlignment(Pos.CENTER);
		AnchorPane.setTopAnchor(vbox, 280.);
		AnchorPane.setRightAnchor(vbox, 130.);
		ap.getChildren().add(backG);
		ap.getChildren().add(vbox);
		//System.out.println(itemList);
		library.setOnAction((ActionEvent)->{
			libra.setList(itemList);
			libra.libraryShow(primaryStage);
		});
		exit.setOnAction((ActionEvent)->{
			System.exit(0);
		});
	}
	//ゲームオーバー時
	public void gameoverShow(Stage primaryStage) {
		ImageView backG = new ImageView(backGround);
		ImageView title = new ImageView(failed);
		backG.setFitWidth(1050);
		backG.setFitHeight(730);
		AnchorPane ap = new AnchorPane();
		//起動時Windowの大きさ
		Scene scene = new Scene(ap,1050,730);
		primaryStage.setScene(scene);
		//サイズ固定
		primaryStage.setTitle("マインスイーパー");
		//ラベル,ボタンの作成
		//Label title = new Label("ゲームオーバー");
		VBox vbox = new VBox(20);
		Button exit = new Button("終了");
		exit.setPrefSize(100, 50);
		//配置位置,大きさの設定
		//title.setFont(new Font(40));
		vbox.getChildren().addAll(title,exit);
		vbox.setAlignment(Pos.CENTER);
		AnchorPane.setTopAnchor(vbox, 280.);
		AnchorPane.setRightAnchor(vbox, 130.);
		ap.getChildren().add(backG);
		ap.getChildren().add(vbox);
		exit.setOnAction((ActionEvent)->{
			System.exit(0);
		});
	}
	
	public void setItemList(List<String> itemList) {
		this.itemList = itemList;
	}
	
}
