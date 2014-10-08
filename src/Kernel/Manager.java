package Kernel;

import java.io.IOException;

import GUI.GUIManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 总接口调入口
 * 
 * @author Lane
 * 
 */
public class Manager extends Application {
	/**
	 * 界面管理者
	 */
	private static GUIManager gm = new GUIManager();
	/**
	 * 游戏管理者
	 */
	private static KernelManager km;

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

	/**
	 * @return KernelManager
	 */
	public KernelManager getKernelManager() {
		return km;
	}

	/**
	 * 游戏开始
	 */
	public void startGame() {
		for (int i = 0; i < 5; i++){
			try {
				km = new KernelManager();
				km.init(5);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
