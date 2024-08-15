package kadai7;

import javafx.application.Application;
import javafx.stage.Stage;

public class Kadai7 extends Application {
	
	private GuiShow Gui ;
	//Bomb bomb = new Bomb();

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Gui=new GuiShow(); 
		Gui.StartShow(primaryStage);
	}
}