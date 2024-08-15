package kadai7;

import java.util.List;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Board {
	
	private CellInfo cellInfo;
	private Bomb bomb;
	private ClearDecision clearDecision;
	private RandomEvent randomEvent;
	
	Cell[][] cell;
	
	private int width = 12;
	private int height = 12;
	private int bombs;
	private Button[][] button;
	private int count = 0;
	private boolean isFlag;
	private int cellCount = 0;
	private Border border = new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT));
	private int health;
	private Label l1,l2,l3,l4,playerHP,enemyHP,player,enemy,plus,resource;
	private Label commandLine1,commandLine2;
	private ImageView image,explanation;
	private AnchorPane ap = new AnchorPane();
	private List<String> eventList;
	private List<String> playerItemList;
	private Button itemButton1,itemButton2,itemButton3,itemButton4,itemButton5,
	itemButton6,itemButton7,itemButton8,itemButton9,itemButton10;
	private HBox hbox1;
	private HBox hbox2;
	private VBox vbox;
	
	//画像呼び出し
	Image cellFlag = new Image("file:///C:./src/kadai7/image/cellFlag.png");
    //ImageView cellF = new ImageView(cellFlag);
	Image cellBomb = new Image("file:///C:./src/kadai7/image/cellBomb.png");
    //ImageView cellB = new ImageView(cellBomb);
	Image cellClose = new Image("file:///C:./src/kadai7/image/cellClose.png");
    //ImageView cellC = new ImageView(cellClose);
    Image cellOpen = new Image("file:///C:./src/kadai7/image/cellOpen.png");
    //ImageView cellO = new ImageView(cellOpen);
    Image cellOpen1 = new Image("file:///C:./src/kadai7/image/cellOpen1.png");
    //ImageView cellO1 = new ImageView(cellOpen1);
    Image cellOpen2 = new Image("file:///C:./src/kadai7/image/cellOpen2.png");
    //ImageView cellO2 = new ImageView(cellOpen2);
    Image cellOpen3 = new Image("file:///C:./src/kadai7/image/cellOpen3.png");
    //ImageView cellO3 = new ImageView(cellOpen3);
    Image cellOpen4 = new Image("file:///C:./src/kadai7/image/cellOpen4.png");
    //ImageView cellO4 = new ImageView(cellOpen4);
    Image cellOpen5 = new Image("file:///C:./src/kadai7/image/cellOpen5.png");
    //ImageView cellO5 = new ImageView(cellOpen5);
    Image cellOpen6 = new Image("file:///C:./src/kadai7/image/cellOpen6.png");
    //ImageView cellO6 = new ImageView(cellOpen6);
    Image cellOpen7 = new Image("file:///C:./src/kadai7/image/cellOpen7.png");
    //ImageView cellO7 = new ImageView(cellOpen7);
    Image cellOpen8 = new Image("file:///C:./src/kadai7/image/cellOpen8.png");
    //ImageView cellO8 = new ImageView(cellOpen8);
    Image messageWindow = new Image("file:///C:./src/kadai7/image/messageWindow.png");
    Image backGround = new Image("file:///C:./src/kadai7/image/backGround.jpg");
    Image paper = new Image("file:///C:./src/kadai7/image/paper.png");
    Image masamune = new Image("file:///C:./src/kadai7/image/masamune.png");
    Image gyutan = new Image("file:///C:./src/kadai7/image/gyutan.jpg");//1
    Image zunda = new Image("file:///C:./src/kadai7/image/zunda.jpg");
    Image sasakama = new Image("file:///C:./src/kadai7/image/sasakama.jpg");
    Image hiyasi = new Image("file:///C:./src/kadai7/image/hiyasi.jpg");
    Image mabo = new Image("file:///C:./src/kadai7/image/ma-bo-.jpg");
    Image sendaiCastle = new Image("file:///C:./src/kadai7/image/sendaicastle.jpg");//6
    Image tanabata = new Image("file:///C:./src/kadai7/image/tanabata.jpg");
    Image aoba = new Image("file:///C:./src/kadai7/image/aoba.jpg");
    Image hikari = new Image("file:///C:./src/kadai7/image/hikari.jpg");
    Image onsen = new Image("file:///C:./src/kadai7/image/onsen.jpg");
    Image gyutanE = new Image("file:///C:./src/kadai7/image/expla1.PNG");
    Image zundaE = new Image("file:///C:./src/kadai7/image/expla2.PNG");
    Image sasakamaE = new Image("file:///C:./src/kadai7/image/expla3.PNG");
    Image hiyasiE = new Image("file:///C:./src/kadai7/image/expla4.PNG");
    Image maboE = new Image("file:///C:./src/kadai7/image/expla5.PNG");
    Image sendaiCastleE = new Image("file:///C:./src/kadai7/image/expla6.PNG");
    Image tanabataE = new Image("file:///C:./src/kadai7/image/expla7.PNG");
    Image aobaE = new Image("file:///C:./src/kadai7/image/expla8.PNG");
    Image hikariE = new Image("file:///C:./src/kadai7/image/expla9.PNG");
    Image onsenE = new Image("file:///C:./src/kadai7/image/expla10.PNG");
    
	public Board() {
		this.cellInfo = new CellInfo(width, height);
		this.randomEvent = new RandomEvent();
		this.cell = cellInfo.getCell();
		bomb = new Bomb(cellInfo);
		//bombs = bomb.getBombs();
		button = new Button[width][height];
		//countAllCell = width * height;
		this.clearDecision = new ClearDecision();
		health = 4;
		l1 = new Label("");
		l2 = new Label("");
		l3 = new Label("");
		l4 = new Label("");
		playerHP = new Label("");
		enemyHP = new Label("");
		player = new Label("playerHP:");
		enemy = new Label("enemyHP:");
		plus = new Label("");
		resource = new Label("");
		eventList = randomEvent.getList();
		playerItemList = randomEvent.getItemList();
		image = new ImageView();
		explanation = new ImageView();
		commandLine1 = new Label("");
		commandLine2 = new Label("");
		hbox1 = new HBox();
		hbox2 = new HBox();
		vbox = new VBox();
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
	}
	
	public void BoardShow(Stage primaryStage) {
		//AnchorPane ap = new AnchorPane();
		FlowPane fp = new FlowPane();
		//ap画像表示
		ImageView backG = new ImageView(backGround);
		ap.getChildren().add(backG);
		backG.setFitHeight(730);
		backG.setFitWidth(1050);
		//マインスイーパー(fp)のサイズ
		fp.setPrefSize(540,540);
		//メッセージWindowの表示,位置指定
		ImageView messageW = new ImageView(messageWindow);
		messageW.setFitHeight(275);
		messageW.setFitWidth(500);
		AnchorPane.setTopAnchor(messageW, 470.);
		AnchorPane.setRightAnchor(messageW, 5.);
		//バーの背景
		l1.setBackground(new Background(new BackgroundFill( Color.DARKGRAY , new CornerRadii(0) , Insets.EMPTY )));
		l1.setPrefSize(530, 170);
		l1.setBorder(border);
		AnchorPane.setTopAnchor(l1, 550.);
		AnchorPane.setRightAnchor(l1, 515.);
		//アイテム欄の作成
		l4.setBackground(new Background(new BackgroundFill( Color.BISQUE , new CornerRadii(0) , Insets.EMPTY )));
		l4.setPrefSize(275, 150);
		l4.setBorder(border);
		AnchorPane.setTopAnchor(l4, 560.);//アイテム欄(外枠)
		AnchorPane.setRightAnchor(l4, 525.);
		//アイテムボタン作成
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
		AnchorPane.setRightAnchor(vbox, 535.);
		setItemImage();
		//文字の作成
		player.setFont(new Font(20));
		enemy.setFont(new Font(20));
		//HPバーの作成
		l2.setPrefSize(150,45);
		l3.setPrefSize(150,45);
		playerHP.setPrefSize(150, 45);
		enemyHP.setPrefSize(150, 45);
		AnchorPane.setTopAnchor(l2, 575.);//Player下地(黒)
		AnchorPane.setRightAnchor(l2, 805.);
		AnchorPane.setTopAnchor(l3, 645.);//Enemy下地(黒)
		AnchorPane.setRightAnchor(l3, 805.);
		AnchorPane.setTopAnchor(playerHP, 575.);
		AnchorPane.setRightAnchor(playerHP, 805.);
		AnchorPane.setTopAnchor(enemyHP, 645.);
		AnchorPane.setRightAnchor(enemyHP, 805.);
		playerHP.setBorder(border);
		enemyHP.setBorder(border);
		//プレイヤーの体力が4以上の場合
		plus.setPrefSize(50, 50);
		plus.setFont(new Font(40));
		AnchorPane.setTopAnchor(plus, 565.);
		AnchorPane.setRightAnchor(plus, 845.);
		plus.setTextFill(Color.BLUE);
		//プレイヤー,敵の名前
		player.setPrefSize(300, 45);
		enemy.setPrefSize(300, 45);
		player.setTextFill(Color.WHITE);
		enemy.setTextFill(Color.WHITE);
		AnchorPane.setTopAnchor(player, 575.);
		AnchorPane.setRightAnchor(player, 742.);
		AnchorPane.setTopAnchor(enemy, 645.);
		AnchorPane.setRightAnchor(enemy, 744.);
		//情報載せる紙の表示
		ImageView backP = new ImageView(paper);
		backP.setFitWidth(600);
		backP.setFitHeight(530);
		AnchorPane.setTopAnchor(backP, 5.);
		AnchorPane.setRightAnchor(backP, -53.);
		//敵(伊達政宗)の表示
		ImageView enemyImage = new ImageView(masamune);
		enemyImage.setFitHeight(400);
		enemyImage.setFitWidth(300);
		AnchorPane.setTopAnchor(enemyImage, 330.);
		AnchorPane.setRightAnchor(enemyImage, -45.);
		//観光資源名の表示
		resource.setPrefSize(300, 300);
		resource.setFont(new Font(30));
		AnchorPane.setTopAnchor(resource, -100.);
		//観光資源画像の設定
		image.setFitHeight(300);
		image.setFitWidth(380);
		AnchorPane.setTopAnchor(image, 80.);
		AnchorPane.setRightAnchor(image, 60.);
		//説明の位置調整
		explanation.setFitWidth(300);
		explanation.setFitHeight(135);
		AnchorPane.setTopAnchor(explanation, 380.);
		AnchorPane.setRightAnchor(explanation, 190.);
		//
		commandLine1.setFont(new Font(20));
		commandLine2.setFont(new Font(20));
		//commandLine1.setText("playerはダメージを受けた");
		//commandLine2.setText("[イベント]playerのHPが回復した");
		commandLine1.setTextFill(Color.WHITE);
		commandLine2.setTextFill(Color.WHITE);
		AnchorPane.setTopAnchor(commandLine1, 580.);
		AnchorPane.setTopAnchor(commandLine2, 610.);
		AnchorPane.setRightAnchor(commandLine1, 275.);
		AnchorPane.setRightAnchor(commandLine2, 255.);
		//一部ラベルの外枠
		l2.setBackground(new Background(new BackgroundFill( Color.BLACK , new CornerRadii(0) , Insets.EMPTY )));
		l3.setBackground(new Background(new BackgroundFill( Color.BLACK , new CornerRadii(0) , Insets.EMPTY )));
		playerHP.setBackground(new Background(new BackgroundFill( Color.GREENYELLOW , new CornerRadii(0) , Insets.EMPTY )));
		enemyHP.setBackground(new Background(new BackgroundFill( Color.GREENYELLOW , new CornerRadii(0) , Insets.EMPTY )));
		//apに追加
		ap.getChildren().addAll(l1,l2,l3,playerHP,enemyHP,player,enemy,backP,enemyImage,messageW,plus,resource,image,explanation,
				commandLine1,commandLine2,l4,vbox,fp);
		//Window大きさ
		Scene scene = new Scene(ap,1050,730);
		primaryStage.setScene(scene);
		//サイズ固定
		primaryStage.setResizable(false);
		//Windowタイトル
		primaryStage.setTitle("マインスイーパー");
		//位置指定
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < height; j++) {
				
				int x = j;
				int y = i;
				
				button[i][j] = new Button();
				//縦横の指定
				button[i][j].setPrefWidth(45);
				button[i][j].setPrefHeight(45);
				fp.getChildren().add(button[i][j]);
				//画像の挿入(cellClose)
				ImageView cellC = new ImageView(cellClose);
			    button[i][j].setGraphic(cellC);
			    cellC.setFitHeight(27);
			    cellC.setFitWidth(27);
			    button[i][j].setBackground(new Background(new BackgroundFill(Color.BURLYWOOD,null,null)));
			    button[i][j].setBorder(border);
				EventHandler<MouseEvent> mouseClicked = ( event ) -> this.mouseClicked( event, x, y, primaryStage );
				 button[i][j].addEventHandler( MouseEvent.MOUSE_CLICKED , mouseClicked );
			}
		}
		//アイテムボタンが押された際の処理
		itemButton1.setOnAction((ActionEvent)->{
			playerItemList.remove("牛たん焼き");
			//System.out.println(playerItemList);
			itemButton1.setDisable(true);
			health++;
			setHealthImage();
			AnchorPane.setRightAnchor(commandLine1, 315.);
			AnchorPane.setRightAnchor(commandLine2, 285.);
			commandLine1.setText("牛タン焼きを食べた");//
			commandLine2.setText("playerのHPが回復した!");
		});
		itemButton2.setOnAction((ActionEvent)->{
			playerItemList.remove("ずんだ");
			//System.out.println(playerItemList);
			itemButton2.setDisable(true);
			health++;
			setHealthImage();
			AnchorPane.setRightAnchor(commandLine1, 355.);
			AnchorPane.setRightAnchor(commandLine2, 285.);
			commandLine1.setText("ずんだを食べた");//
			commandLine2.setText("playerのHPが回復した!");
		});
		itemButton3.setOnAction((ActionEvent)->{
			playerItemList.remove("笹かまぼこ");
			//System.out.println(playerItemList);
			itemButton3.setDisable(true);
			health++;
			setHealthImage();
			AnchorPane.setRightAnchor(commandLine1, 325.);
			AnchorPane.setRightAnchor(commandLine2, 285.);
			commandLine1.setText("笹かまぼこを食べた");//
			commandLine2.setText("playerのHPが回復した!");
		});
		itemButton4.setOnAction((ActionEvent)->{
			playerItemList.remove("冷やし中華");
			//System.out.println(playerItemList);
			itemButton4.setDisable(true);
			health++;
			setHealthImage();
			AnchorPane.setRightAnchor(commandLine1, 315.);
			AnchorPane.setRightAnchor(commandLine2, 285.);
			commandLine1.setText("冷やし中華を食べた");//
			commandLine2.setText("playerのHPが回復した!");
		});
		itemButton5.setOnAction((ActionEvent)->{
			playerItemList.remove("マーボー焼きそば");
			//System.out.println(playerItemList);
			itemButton5.setDisable(true);
			health++;
			setHealthImage();
			AnchorPane.setRightAnchor(commandLine1, 275.);
			AnchorPane.setRightAnchor(commandLine2, 285.);
			commandLine1.setText("マーボー焼きそばを食べた");//
			commandLine2.setText("playerのHPが回復した!");
		});
		itemButton6.setOnAction((ActionEvent)->{
			playerItemList.remove("仙台城跡");
			//System.out.println(playerItemList);
			itemButton6.setDisable(true);
			health++;
			setHealthImage();
			AnchorPane.setRightAnchor(commandLine1, 305.);
			AnchorPane.setRightAnchor(commandLine2, 285.);
			commandLine1.setText("仙台城跡を観光した");//
			commandLine2.setText("playerのHPが回復した!");
		});
		itemButton7.setOnAction((ActionEvent)->{
			playerItemList.remove("仙台七夕まつり");
			//System.out.println(playerItemList);
			itemButton7.setDisable(true);
			health++;
			setHealthImage();
			AnchorPane.setRightAnchor(commandLine1, 265.);
			AnchorPane.setRightAnchor(commandLine2, 285.);
			commandLine1.setText("仙台七夕まつりを観光した");//
			commandLine2.setText("playerのHPが回復した!");
		});
		itemButton8.setOnAction((ActionEvent)->{
			playerItemList.remove("仙台・青葉まつり");
			//System.out.println(playerItemList);
			itemButton8.setDisable(true);
			health++;
			setHealthImage();
			AnchorPane.setRightAnchor(commandLine1, 255.);
			AnchorPane.setRightAnchor(commandLine2, 285.);
			commandLine1.setText("仙台・青葉まつりを観光した");//
			commandLine2.setText("playerのHPが回復した!");
		});
		itemButton9.setOnAction((ActionEvent)->{
			playerItemList.remove("SENDAI光のページェント");
			//System.out.println(playerItemList);
			itemButton9.setDisable(true);
			health++;
			setHealthImage();
			AnchorPane.setRightAnchor(commandLine1, 195.);
			AnchorPane.setRightAnchor(commandLine2, 285.);
			commandLine1.setText("SENDAI光のページェントを観光した");
			commandLine2.setText("playerのHPが回復した!");
		});
		itemButton10.setOnAction((ActionEvent)->{
			playerItemList.remove("秋保温泉");
			//System.out.println(playerItemList);
			itemButton10.setDisable(true);
			health++;
			setHealthImage();
			AnchorPane.setRightAnchor(commandLine1, 325.);
			AnchorPane.setRightAnchor(commandLine2, 285.);
			commandLine1.setText("秋保温泉に入った");//
			commandLine2.setText("playerのHPが回復した!");
		});
	}
	
	private void mouseClicked(MouseEvent e, int x, int y,Stage primaryStage) {
		switch(e.getButton()) {
		case PRIMARY:
		count ++;
		commandLine1.setText("");
		commandLine2.setText("");
		AnchorPane.setRightAnchor(commandLine1, 275.);
		AnchorPane.setRightAnchor(commandLine2, 255.);
		if(count == 1) {
			//爆弾作成
			bomb.makeAllBomb(x,y,height);
			//爆弾の数をgetする
			bombs=bomb.getBombs();
			//(デバッグ)爆弾の位置表示
			bombShow();
			//cell内部のカウントがない(0)の場合カウント,開く
			open(x,y,primaryStage);
			setEnemyHealthImage();
		}else if(2 <= count){
			//フラグがtrueならセルを開かせない
			isFlag = cell[y][x].getIsFlag();
			if(isFlag == true) {
			}else {
				setDamagePlayer(x,y);
				//敵の体力の確認
				setEnemyHealthImage();
				//イベントの確認
				eventCheck();
				open(x,y,primaryStage);
			}
		}
		break;
		case SECONDARY:
			if(count == 0) {
				//System.out.println("旗立てさせない");
			}else {
				isFlag = cell[y][x].getIsFlag();
					if(isFlag == false) {
						ImageView cellF = new ImageView(cellFlag);
						 button[y][x].setGraphic(cellF);
						    cellF.setFitHeight(27);
						    cellF.setFitWidth(27);
						cell[y][x].setIsFlag(true);
					}else {
						cell[y][x].setIsFlag(false);
						ImageView cellC = new ImageView(cellClose);
					    button[y][x].setGraphic(cellC);
					    cellC.setFitHeight(27);
					    cellC.setFitWidth(27);
					}
				}
			break;
		default:
			break;
		}
	}
	
	//countによる周辺の爆弾数画像
	private void countShow() {
		List<Integer> resultNum1 = bomb.getxValue();
		List<Integer> resultNum2 = bomb.getyValue();
		for(int i = 0; i < bombs; i++) {	
			int num1 = resultNum1.get(i);
			int num2 = resultNum2.get(i);
			for(int j = -1; j < 2; j++) {
				for(int k = -1; k <  2; k++) {
						if(-1 < num2 + k && num2 + k < height  && -1 < num1 + j && num1 + j < height ) {
							//System.out.println("called");
							if(!cell[num2 + k][num1 + j].getIsBomb() && cell[num2 + k][num1 + j].getCount() > 0) {
							//button[num2 + k][num1 + j].setText(String.valueOf(cell[num2 + k][num1 + j].getCount()));
							if(cell[num2 + k][num1 + j].getIsOpen()) {
								if(cell[num2 + k][num1 + j].getCount() == 0) {
									ImageView cellO = new ImageView(cellOpen);
									button[num2 + k][num1 + j].setGraphic(cellO);
									cellO.setFitHeight(27);
									cellO.setFitWidth(27);
								}
								if(cell[num2 + k][num1 + j].getCount() == 1) {
								ImageView cellO1 = new ImageView(cellOpen1);
								 button[num2 + k][num1 + j].setGraphic(cellO1);
								    cellO1.setFitHeight(27);
								    cellO1.setFitWidth(27);
								    }
								if(cell[num2 + k][num1 + j].getCount() == 2) {
								ImageView cellO2 = new ImageView(cellOpen2);
								 button[num2 + k][num1 + j].setGraphic(cellO2);
								    cellO2.setFitHeight(27);
								    cellO2.setFitWidth(27);
								}
								if(cell[num2 + k][num1 + j].getCount() == 3) {
								ImageView cellO3 = new ImageView(cellOpen3);
								 button[num2 + k][num1 + j].setGraphic(cellO3);
								    cellO3.setFitHeight(27);
								    cellO3.setFitWidth(27);
								}
								if(cell[num2 + k][num1 + j].getCount() == 4) {
								ImageView cellO4 = new ImageView(cellOpen4);
								 button[num2 + k][num1 + j].setGraphic(cellO4);
								    cellO4.setFitHeight(27);
								    cellO4.setFitWidth(27);
								}
								if(cell[num2 + k][num1 + j].getCount() == 5) {
								ImageView cellO5 = new ImageView(cellOpen5);
								 button[num2 + k][num1 + j].setGraphic(cellO5);
								    cellO5.setFitHeight(27);
								    cellO5.setFitWidth(27);
								}
								if(cell[num2 + k][num1 + j].getCount() == 6) {
								ImageView cellO6 = new ImageView(cellOpen6);
								 button[num2 + k][num1 + j].setGraphic(cellO6);
								    cellO6.setFitHeight(27);
								    cellO6.setFitWidth(27);
								}
								if(cell[num2 + k][num1 + j].getCount() == 7) {
								ImageView cellO7 = new ImageView(cellOpen7);
								 button[num2 + k][num1 + j].setGraphic(cellO7);
								    cellO7.setFitHeight(27);
								    cellO7.setFitWidth(27);
								}
								if(cell[num2 + k][num1 + j].getCount() == 8) {
								ImageView cellO8 = new ImageView(cellOpen8);
								 button[num2 + k][num1 + j].setGraphic(cellO8);
								    cellO8.setFitHeight(27);
								    cellO8.setFitWidth(27);
								}
							}
							}
						}
				}
			}
		}
	}
	
	//(デバッグ用)爆弾の表示
	private void bombShow() {
		List<Integer> resultNum1 = bomb.getxValue();
		List<Integer> resultNum2 = bomb.getyValue();
		for(int i = 0; i < bombs; i++) {
			int num1 = resultNum1.get(i);
			int num2 = resultNum2.get(i);
			ImageView cellB = new ImageView(cellBomb);
			button[num2][num1].setGraphic(cellB);
			cellB.setFitHeight(27);
			cellB.setFitWidth(27);
		}
	}
	//再帰処理
	private void open(int x,int y,Stage primaryStage) {
		cell[y][x].setIsOpen();
		button[y][x].setDisable(true);
		if(!cell[y][x].getIsBomb()) {
			cellCount++;
		}
		if(cell[y][x].getCount() == 0) {
		for(int j = -1; j < 2; j++) {
			for(int k = -1; k< 2; k++) {
				if(-1 < y + k && y + k < height  && -1 < x + j && x + j < height ) {
					if(cell[y+k][x+j].getIsOpen()) {
					}else {
					//countShow();
					//System.out.println("カウント" + cellCount);
					open(x+j,y+k,primaryStage);
					}
				}
			}
			ImageView cellO = new ImageView(cellOpen);
			 button[y][x].setGraphic(cellO);
			 cellO.setFitHeight(27);
			 cellO.setFitWidth(27);
		}
		}else {
			button[y][x].setDisable(true);
			countShow();
			if(cell[y][x].getIsBomb() == true) {
				ImageView cellB = new ImageView(cellBomb);
				button[y][x].setGraphic(cellB);
				cellB.setFitHeight(27);
				cellB.setFitWidth(27);
			}
		}
		//System.out.println("cellcount"+cellCount);
		//System.out.println("countAllCell"+countAllCell);
		if(cellCount == 114) {
			//System.out.println("クリア");
			clearDecision.setItemList(playerItemList);
			clearDecision.clearShow(primaryStage);
		}
		if(cell[y][x].getIsGameOver()) {
			//System.out.println("ゲームオーバー");
			clearDecision.gameoverShow(primaryStage);
		}
	}
	//アイテム欄のボタンに画像を表示する
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
	
	//選択されたボタンが爆弾の場合体力を1減らす。0になるとゲームオーバーをtrueにする。
	private void setDamagePlayer(int x,int y) {
			if(cell[y][x].getIsBomb()) {
				//cell[num2][num1].setIsGameOver();
				health--;
				//System.out.println("体力" + health);
				ImageView cellB = new ImageView(cellBomb);
				button[y][x].setGraphic(cellB);
				cellB.setFitHeight(27);
				cellB.setFitWidth(27);
				setHealthImage();
				commandLine1.setText("playerはダメージを受けた");
				if(health == 0) {
					cell[y][x].setIsGameOver();
				}
			}
	}
	//プレイヤーのhealthの数値によって表示する体力を切り替える
	private void setHealthImage() {
		if(5 <= health) {
			plus.setText("+");
		}else if(4 == health) {
			playerHP.setBackground(new Background(new BackgroundFill( Color.GREENYELLOW , new CornerRadii(0) , Insets.EMPTY )));
			playerHP.setPrefSize(150, 45);
			AnchorPane.setRightAnchor(playerHP, 805.);
			plus.setText("");
		}else if(health == 3) {
			playerHP.setBackground(new Background(new BackgroundFill( Color.GREENYELLOW , new CornerRadii(0) , Insets.EMPTY )));
			playerHP.setPrefSize(100, 45);
			AnchorPane.setRightAnchor(playerHP, 855.);
		}else if(health == 2) {
			playerHP.setBackground(new Background(new BackgroundFill( Color.GREENYELLOW , new CornerRadii(0) , Insets.EMPTY )));
			playerHP.setPrefSize(50, 45);
			AnchorPane.setRightAnchor(playerHP, 905.);
			//ap.getChildren().add(playerHP);
		}else if(health == 1) {
			playerHP.setBackground(new Background(new BackgroundFill( Color.RED , new CornerRadii(0) , Insets.EMPTY )));
			playerHP.setPrefSize(20, 45);
			AnchorPane.setRightAnchor(playerHP, 935.);
			//ap.getChildren().add(playerHP);
		}
	}
	//敵のセルの残り空き数によって表示する体力を切り替える。
	private void setEnemyHealthImage() {
		if(105 <= cellCount) {
			enemyHP.setBackground(new Background(new BackgroundFill( Color.RED , new CornerRadii(0) , Insets.EMPTY )));
			enemyHP.setPrefSize(20, 45);
			AnchorPane.setRightAnchor(enemyHP, 935.);
		}else if(95 <= cellCount) {
			enemyHP.setBackground(new Background(new BackgroundFill( Color.GREENYELLOW , new CornerRadii(0) , Insets.EMPTY )));
			enemyHP.setPrefSize(50, 45);
			AnchorPane.setRightAnchor(enemyHP, 905.);
		}else if(85 <= cellCount) {
			enemyHP.setBackground(new Background(new BackgroundFill( Color.GREENYELLOW , new CornerRadii(0) , Insets.EMPTY )));
			enemyHP.setPrefSize(100, 45);
			AnchorPane.setRightAnchor(enemyHP, 855.);
		}
	}
	//セルを1回開けた時にイベントを発生させるか
	private void eventCheck() {
		boolean result = randomEvent.eventCheck();
		if(result) { 
			commandLine2.setText("[イベント]アイテムを取得した");
			//System.out.println("イベント発生");
			//health++;
			//System.out.println("体力:"+health);
			setHealthImage();
			if(eventList.isEmpty()) {
				randomEvent.resetList();
				eventList = randomEvent.getList();
				//playerItemList = randomEvent.getList();
			}
			//System.out.println("イベントリスト" +eventList);
			//System.out.println("アイテムリスト" +playerItemList);
			//randomEvent.selectList();
			selectNumberImage();
		}
	}
	//RandomEventから受け取った値によって画像を表示させる。
	private void selectNumberImage() {
		if(eventList.get(0) == "牛たん焼き") {//
			resource.setText("牛たん焼き");
			AnchorPane.setRightAnchor(resource, 25.);
			//image = new ImageView(gyutan);
			image.setImage(gyutan);
			explanation.setImage(gyutanE);
			eventList.remove("牛たん焼き");
			itemButton1.setDisable(false);
		}else if(eventList.get(0) == "ずんだ") {//
			resource.setText("ずんだ");
			AnchorPane.setRightAnchor(resource, 0.);
			//image = new ImageView(zunda);
			image.setImage(zunda);
			explanation.setImage(zundaE);
			eventList.remove("ずんだ");
			itemButton2.setDisable(false);
		}else if(eventList.get(0) == "笹かまぼこ") {//
			resource.setText("笹かまぼこ");
			AnchorPane.setRightAnchor(resource, 30.);
			//image = new ImageView(sasakama);
			image.setImage(sasakama);
			explanation.setImage(sasakamaE);
			eventList.remove("笹かまぼこ");
			itemButton3.setDisable(false);
		}else if(eventList.get(0) == "冷やし中華") {//
			resource.setText("冷やし中華");
			AnchorPane.setRightAnchor(resource, 30.);
			//image = new ImageView(hiyasi);
			image.setImage(hiyasi);
			explanation.setImage(hiyasiE);
			eventList.remove("冷やし中華");
			itemButton4.setDisable(false);
		}else if(eventList.get(0) == "マーボー焼きそば") {//
			resource.setText("マーボー焼きそば");
			AnchorPane.setRightAnchor(resource, 50.);
			//image = new ImageView(mabo);
			image.setImage(mabo);
			explanation.setImage(maboE);
			eventList.remove("マーボー焼きそば");
			itemButton5.setDisable(false);
		}else if(eventList.get(0) == "仙台城跡") {//
			resource.setText("仙台城跡");
			AnchorPane.setRightAnchor(resource, 20.);
			//image = new ImageView(sendaiCastle);
			image.setImage(sendaiCastle);
			explanation.setImage(sendaiCastleE);
			eventList.remove("仙台城跡");
			itemButton6.setDisable(false);
		}else if(eventList.get(0) == "仙台七夕まつり") {//
			resource.setText("仙台七夕まつり");
			AnchorPane.setRightAnchor(resource, 50.);
			//image = new ImageView(tanabata);
			image.setImage(tanabata);
			explanation.setImage(tanabataE);
			eventList.remove("仙台七夕まつり");
			itemButton7.setDisable(false);
		}else if(eventList.get(0) == "仙台・青葉まつり") {//
			resource.setText("仙台・青葉まつり");
			AnchorPane.setRightAnchor(resource, 55.);
			//image = new ImageView(aoba);
			image.setImage(aoba);
			explanation.setImage(aobaE);
			eventList.remove("仙台・青葉まつり");
			itemButton8.setDisable(false);
		}else if(eventList.get(0) == "SENDAI光のページェント") {
			resource.setText("SENDAI光のページェント");
			AnchorPane.setRightAnchor(resource, 90.);
			//image = new ImageView(hikari);
			image.setImage(hikari);
			explanation.setImage(hikariE);
			eventList.remove("SENDAI光のページェント");
			itemButton9.setDisable(false);
		}else if(eventList.get(0) == "秋保温泉") {
			resource.setText("秋保温泉");
			AnchorPane.setRightAnchor(resource, 25.);
			image.setImage(onsen);
			explanation.setImage(onsenE);
			eventList.remove("秋保温泉");
			itemButton10.setDisable(false);
		}
	}

	public List<String> getPlayerItemList() {
		return playerItemList;
	}

	public void setPlayerItemList(List<String> playerItemList) {
		this.playerItemList = playerItemList;
	}
}