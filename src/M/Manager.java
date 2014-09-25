package M;

import GUI.GUIManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * @author Lane
 *
 */
public class Manager extends Application {
	/**
	 * 界面管理者
	 */
	public static GUIManager gm = new GUIManager();

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		gm.setStage(stage);
		stage.show();
		gm.setBackGround();
	}

	/**
	 * @return GUIManager
	 */
	public GUIManager getGUIManager() {
		return gm;
	}
}
