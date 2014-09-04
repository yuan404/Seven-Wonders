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

public class GUIManager{
	
	private double XScreen;
	private double YScreen;
	
	private Group root;
	private Scene scene;
	private Stage stage;
	
	private Block block;
	
	private Image icon = new Image("resource/image/icon.png");
	
	public GUIManager(){
		XScreen = 1099;
		YScreen = 713;
		root = new Group();
		block = new Block(XScreen,YScreen);
	}
	
	public void initScene(){
		scene = new Scene(root,XScreen,YScreen);
	}
	
	public void initStage() throws Exception{
		stage = new Stage();
		stage.setTitle("Seven Wonders");
		stage.setResizable(false);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(scene);
		stage.getIcons().add(icon);
		setBlock();
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
	
	public void setBlock(){
		root.getChildren().add(block.getBlock());
		root.getChildren().add(block.getLogo());
		root.getChildren().add(block.getVersion());
		root.getChildren().add(block.getpt());
		root.getChildren().add(block.getpm());
		root.getChildren().add(block.getpf());
		root.getChildren().add(block.getMenu());
		for(int i = 0; i < 7; i++)
			root.getChildren().add(block.getLabel(i));
		block.setStartEffect();
	}
	
}
