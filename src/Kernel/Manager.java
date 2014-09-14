package Kernel;

import GUI.GUIManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Lane 游戏管理者-游戏开始的入口
 */

public class Manager extends Application {

	// 单击游戏时采用static，如果更改成局域网或许需要改成数组形式.
	private static GUIManager gm = new GUIManager();
	private static KernelManager km;

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage stage) throws Exception {
		gm.initScene();
		gm.initStage();
		stage = gm.getStage();
		stage.show();
	}

	public GUIManager getGUIManager() {
		return gm;
	}

	public KernelManager getKenelManager() {
		return km;
	}

	public void startGame() {
		km = new KernelManager(getGUIManager().PlayerNum.getSelectionModel()
				.getSelectedItem());
		km.initGame();
		gm.startGame();
		
	}
}