package GUI;

import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * @author Lane
 * 
 */
public class GUIManager {

	private Group root = new Group();
	private Stage stage;
	private Scene scene;

	/**
	 * 屏幕的长
	 */
	private double xScreen = 1099;
	/**
	 * 屏幕的宽
	 */
	private double yScreen = 713;
	/**
	 * 图标
	 */
	private Image icon = new Image("resource/image/icon.png");
	/**
	 * 光标
	 */
	private Image cursor = new Image("resource/image/arrow.png");
	/**
	 * 背景控制类
	 */
	private BackGround bg = new BackGround();

	/**
	 * 设置Stage
	 * 
	 * @return
	 */
	public void setStage(Stage stage) {
		this.stage = stage;

		scene = new Scene(root, xScreen, yScreen);
		scene.setCursor(new ImageCursor(cursor));

		stage.setScene(scene);

		stage.setTitle("Seven Wonders");
		stage.setResizable(false);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.getIcons().add(icon);
	}

	/**
	 * 关闭Stage
	 * 
	 * @return
	 */
	public void removeStage() {
		stage.close();
	}

	/**
	 * @return Group
	 */
	public Group getGroup() {
		return root;
	}

	/**
	 * 设置背景
	 */
	public void setBackGround() {
		bg.setBackGround();
	}

}
