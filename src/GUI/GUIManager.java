package GUI;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Lane
 * 界面管理者-通过该类管理所有界面
 */

public class GUIManager {
	
	public double XScreen;
	public double YScreen;
	
	public Group root;
	public Scene scene;
	public Stage stage;
	
	public Image icon = new Image("resource/image/icon.png");
	
	public GUIManager(){
		XScreen = 1099;
		YScreen = 713;
		root = new Group();
	}
	
	public void initScene(){
		scene = new Scene(root,XScreen,YScreen);
	}
	
	public void initStage(){
		stage = new Stage();
		stage.setTitle("Seven Wonders");
		stage.setResizable(false);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(scene);
		stage.getIcons().add(icon);
	}
	
	public Group getGroup(){
		return root;
	}
	
	public Scene getScene(){
		return scene;
	}
	
	public Stage getStage(){
		return stage;
	}
	
}
