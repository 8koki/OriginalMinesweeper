package kadai7;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GuiShow {
	
	Board board;
	Image backGround = new Image("file:///C:./src/kadai7/image/backGround.jpg");
	Image Minesweeper = new Image("file:///C:./src/kadai7/image/title.png");
	public GuiShow() {
		this.board=new Board();
	}
	
	public void StartShow(Stage primaryStage) {
		AnchorPane ap = new AnchorPane();
		ImageView backG = new ImageView(backGround);
		ImageView titleShow = new ImageView(Minesweeper);
		backG.setFitWidth(1050);
		backG.setFitHeight(730);
		//titleShow.setFitHeight(150);
		//titleShow.setFitWidth(800);
		//ap.getChildren().add(backG);
		//ap.getChildren().add(titleShow);
		//起動時Windowの大きさ
		Scene scene = new Scene(ap,1050,730);
		primaryStage.setScene(scene);
		//サイズ固定
		primaryStage.setTitle("マインスイーパー");
		//ラベル,ボタンの作成
		//Label title = new Label("マインスイーパー");
		Button start = new Button("Start");
		Button exit = new Button("終了");
		VBox vbox = new VBox(20);
		//配置位置,大きさの設定
		//title.setFont(new Font(45));
		start.setFont(new Font(20));
		start.setPrefSize(100, 50);
		exit.setFont(new Font(20));
		exit.setPrefSize(100,50);
		vbox.getChildren().addAll(titleShow,start,exit);
		vbox.setAlignment(Pos.CENTER);
		ap.getChildren().addAll(backG,vbox);
		AnchorPane.setTopAnchor(vbox, 260.);
		AnchorPane.setRightAnchor(vbox, 120.);
		//Startボタンが押された処理
		start.setOnAction((ActionEvent)->{
			board.BoardShow(primaryStage);
		});
		//終了ボタンが押された処理
		exit.setOnAction((ActionEvent)->{
			System.exit(0);
		});
		primaryStage.show();
	}
}
